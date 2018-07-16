package J37_SerializeBinaryTrees;

/**
 * 面试题37：序列化二叉树
 * <p>题目：请实现两个函数，分别用来序列化和反序列化二叉树。
 */
public class SerializeBinaryTrees {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(4);
        node.right = new TreeNode(3);
        node.right.left = new TreeNode(5);
        node.right.right = new TreeNode(6);
        String serialize = Serialize(node);
        TreeNode tn = Deserialize(serialize);
    }

    static String Serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        if (root == null) {
            sb.append("$,");
        } else {
            sb.append(root.val + ",");
            Serialize(root.left, sb);
            Serialize(root.right, sb);
        }
        return sb.toString();
    }

    static void Serialize(TreeNode root, StringBuffer sb) {
        if (root == null) {
            sb.append("$,");
            return;
        }
        sb.append(root.val + ",");
        Serialize(root.left, sb);
        Serialize(root.right, sb);
    }

    static TreeNode Deserialize(String str) {
        if (str == null || str.length() < 1) {
            return null;
        }
        String[] split = str.split(",");
        String num = split[0];
        if ("$".equals(num)) {
            return null;
        } else {
            int[] index = {0};
            return Deserialize(split, index);
        }
    }

    /**
     * 在这个方法上花了不少时间，要抓住二叉树遍历核心要点：根节点、左节点、右节点，分这三部分来解决，利用数据来保存返回值
     * @param split 分割后的序列化节点值
     * @param index 当前操作的节点值
     * @return 当前操作的节点
     */
    static TreeNode Deserialize(String[] split, int[] index) {
        if (index[0] >= split.length) {
            return null;
        }
        String num = split[index[0]++];
        if ("$".equals(num)) {
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.valueOf(num));
            node.left = Deserialize(split, index);
            node.right = Deserialize(split, index);
            return node;
        }
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}