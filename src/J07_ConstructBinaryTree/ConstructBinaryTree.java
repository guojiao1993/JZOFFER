package J07_ConstructBinaryTree;

/**
 * 面试题7：重建二叉树
 * <p>题目：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输
 * 入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,
 * 2, 4, 7, 3, 5, 6, 8}和中序遍历序列{4, 7, 2, 1, 5, 3, 8, 6}，则重建出
 * 图2.6所示的二叉树并输出它的头结点。
 */
public class ConstructBinaryTree {
    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return findHead(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    public static TreeNode findHead(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        if(preStart > preEnd) {
            return null;
        }
        int headVal = pre[preStart];
        TreeNode headNode = new TreeNode(headVal);
        int i = inStart;
        while (i <= inEnd) {
            if(in[i] == headVal) {
                break;
            }
            i++;
        }
        int leftLength = i - inStart;
        int rightLength = inEnd - i;
        headNode.left = findHead(pre, preStart + 1, preStart + leftLength, in, inStart, i - 1);
        headNode.right = findHead(pre, preStart + leftLength + 1, preEnd, in, i + 1, inEnd);
        return headNode;
    }

    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        TreeNode treeNode = reConstructBinaryTree(pre, in);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}