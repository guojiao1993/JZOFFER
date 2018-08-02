package J28_SymmetricalBinaryTree;

public class SymmetricalBinaryTree {
    boolean isSymmetrical(TreeNode pRoot) {
        return isSymmetricalUsingRecursion(pRoot, pRoot);
    }

    boolean isSymmetricalUsingRecursion(TreeNode tn1, TreeNode tn2) {
        if (tn1 == null && tn2 == null) {
            return true;
        }
        if ((tn1 == null && tn2 != null) || (tn1 != null && tn2 == null)) {
            return false;
        }
        if (tn1.val != tn2.val) {
            return false;
        }
        return isSymmetricalUsingRecursion(tn1.left, tn2.right) && isSymmetricalUsingRecursion(tn1.right, tn2.left);
    }
}
