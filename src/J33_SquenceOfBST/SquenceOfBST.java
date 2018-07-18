package J33_SquenceOfBST;

/**
 * 面试题33：二叉搜索树的后序遍历序列
 * <p>题目：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则返回true，否则返回false。假设输入的数组的任意两个数字都互不相同。
 * OJ：https://www.nowcoder.com/practice/a861533d45854474ac791d90e447bafd?tpId=13&tqId=11176&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class SquenceOfBST {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if(sequence == null || sequence.length < 1) {
            return false;
        }
        return VerifySquenceOfBSTUsingRecursion(sequence, 0, sequence.length - 1);
    }
    public boolean VerifySquenceOfBSTUsingRecursion(int[] sequence, int left, int right) {
        if(left == right) {
            return true;
        }
        int target = sequence[right];
        int leftl = left - 1;
        int leftr = left - 1;
        int rightl = right;
        int rightr = right;
        int i = left;
        while (i < right && sequence[i] < target) {
            i++;
        }
        // 左子树有值，无值则取默认相同值，下次递归直接返回true
        if(i > left) {
            leftl = left;
            leftr = i - 1;
        }
        // 右子树有值，无值则取默认相同值，下次递归直接返回true
        if(i != right) {
            rightl = i;
            while (i < right && sequence[i] > target) {
                i++;
            }
            // 若在右子树中发现比父节点还小的值，则返回false
            if(i != right) {
                return false;
            }
            rightr = right - 1;
        }
        // 递归判断左子树和右子树
        return VerifySquenceOfBSTUsingRecursion(sequence, leftl, leftr) & VerifySquenceOfBSTUsingRecursion(sequence, rightl, rightr);
    }
}