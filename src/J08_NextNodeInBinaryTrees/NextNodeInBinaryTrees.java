package J08_NextNodeInBinaryTrees;

/**
 * 面试题8：二叉树的下一个结点
 * <p>题目：给定一棵二叉树和其中的一个结点，如何找出中序遍历顺序的下一个结点？
 * 树中的结点除了有两个分别指向左右子结点的指针以外，还有一个指向父结点的指针。
 * <p>关键在于要思路缜密，考虑到所有的情况，再加上认真编程即可
 * <p>OJ：https://www.nowcoder.com/practice/9023a0c988684a53960365b889ceaf5e?tpId=13&tqId=11210&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class NextNodeInBinaryTrees {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        // 该节点有右子树：输出右子树的最左下的叶子节点
        if(pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }
        // 其余情况：该节点无右子树
        // 该节点无父亲节点：输出空
        if(pNode.next == null) {
            return null;
        }
        // 其余情况：该节点有父亲节点
        // 该节点是父亲节点的左子树：输出父亲节点
        if(pNode == pNode.next.left) {
            return pNode.next;
        }
        // 该节点是父亲节点的右子树，向左上一直找到顶端
        while (pNode.next != null && pNode == pNode.next.right) {
            pNode = pNode.next;
        }
        // 最顶端无右父亲，则输出空
        if(pNode.next == null) {
            return null;
        }
        // 最顶端有右父亲，则输出右子树
        return pNode.next;
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}