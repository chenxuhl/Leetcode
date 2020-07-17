/*
110. 平衡二叉树
给定一个二叉树，判断它是否是高度平衡的二叉树。

本题中，一棵高度平衡二叉树定义为：

一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。

示例 1:

给定二叉树 [3,9,20,null,null,15,7]

    3
   / \
  9  20
    /  \
   15   7
返回 true 。

示例 2:

给定二叉树 [1,2,2,3,3,null,null,4,4]

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
返回 false 。
*/

//解题思路：递归

//Java
//Author:Joey
//Date：2020/07/17

/*
执行结果：
执行用时：1 ms, 在所有 Java 提交中击败了99.73%的用户
内存消耗：40.1 MB, 在所有 Java 提交中击败了23.53%的用户
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        //左右子树高度差
        return Math.abs(helper(root.left) - helper(root.right)) < 2 && isBalanced(root.left) && isBalanced(root.right);
    }
    public int helper(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(helper(root.left), helper(root.right));
    }
}