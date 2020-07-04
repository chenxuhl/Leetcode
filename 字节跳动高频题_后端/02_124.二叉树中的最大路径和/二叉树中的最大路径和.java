/*
124. 二叉树中的最大路径和
给定一个非空二叉树，返回其最大路径和。

本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，
且不一定经过根节点。

示例 1:

输入: [1,2,3]

       1
      / \
     2   3

输出: 6
示例 2:

输入: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

输出: 42

*/

/*
解题思路：
运用递归，递归函数传入根节点，返回最大值max = left分支最大路径和 + right分支最大路径和 + 当前节点值
*/

//Java
//Author:Joey
//Date：2020/07/04

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
    int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        dfs(root);
        return max;
    }
    //中序搜索
    public int dfs(TreeNode node) {
        if (node == null) return 0;  //递归出口

        int left = Math.max(dfs(node.left), 0);  //若left分支最大路径和小于0，则不用加left分支
        int right = Math.max(dfs(node.right), 0);  //同理

        max = Math.max(max, left + right + node.val);  //max值为当前节点值+左右分支最大累加值
        
        return Math.max(0, (node.val + Math.max(left, right)));
    }
}