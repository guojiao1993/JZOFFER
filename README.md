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
