# 剑指Offer
## 第3章 高质量的代码
### 代码的鲁棒性
**面试题26：树的子结构**  
- 使用递归，有两个地方用到了，一是在前序遍历root1的所有节点时，二是在比较root1和root2是否相等时用到。  
- 一定要格外注意判断指针是否为空，要时刻在操作指针前加判断，防止报错NPE(Null Pointer Exception)。  
```java
public boolean HasSubtree(TreeNode root1, TreeNode root2) {
    if (root1 == null || root2 == null) {
        return false;
    }
    // 使用前序遍历递归查找root1中与root2根节点值相等的节点
    return isSubtree(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
}

public boolean isSubtree(TreeNode root1, TreeNode root2) {
    if (root1 == null && root2 == null) {
        return true;
    }
    if (root1 != null && root2 == null) {
        return true;
    }
    if (root1 == null && root2 != null) {
        return false;
    }
    if (root1.val != root2.val) {
        return false;
    }
    return isSubtree(root1.left, root2.left) && isSubtree(root1.right, root2.right);
}
```
[牛客网OJ](https://www.nowcoder.com/practice/6e196c44c7004d15b1610b9afca8bd88?tpId=13&tqId=11170&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)
## 第4章 解决面试题的思路
### 画图让抽象问题形象化
**面试题27：二叉树的镜像**  
- 使用递归
```java
public void Mirror(TreeNode root) {
    if(root == null) {
        return;
    }
    TreeNode temp = root.left;
    root.left = root.right;
    root.right = temp;
    Mirror(root.left);
    Mirror(root.right);
}
```
[牛客网OJ](https://www.nowcoder.com/practice/564f4c26aa584921bc75623e48ca3011?tpId=13&tqId=11171&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

**面试题28：对称的二叉树**  
- 使用递归
- 定义一种新的遍历方式“对称前序遍历”：先访问根节点，再访问右节点，最后访问左节点
- 比较前序遍历的值和“对称的前序遍历”的值是否完全相同
```java
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
```
[牛客网OJ](https://www.nowcoder.com/practice/ff05d44dfdb04e1d83bdbdab320efbcb?tpId=13&tqId=11211&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)
