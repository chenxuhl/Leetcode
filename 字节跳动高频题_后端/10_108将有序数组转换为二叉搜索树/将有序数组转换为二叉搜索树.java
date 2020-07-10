/*
108. 将有序数组转换为二叉搜索树
将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。

本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

示例:

给定有序数组: [-10,-3,0,5,9],

一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：

      0
     / \
   -3   9
   /   /
 -10  5
*/

/*
解题思路：二叉搜索树：树中任何结点的左子树中所有结点的值均比该结点小，右子树中所有结点的值均比该结点大。
对二叉搜索树进行中序遍历即得到一个递增排序的序列。
给出有序数组不能唯一确定二叉搜索树
参考：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/solution/jiang-you-xu-shu-zu-zhuan-huan-wei-er-cha-sou-s-33/
*/

//Java
//Author:Joey
//Date：2020/07/10

/*
执行结果：
执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：39.4 MB, 在所有 Java 提交中击败了8.70%的用户
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
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int left, int right) {
        //出口
        if (left > right) {  
            return null;
        }
        int mid = (left + right) / 2;  //选中间位置左边数字作为根节点

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid-1);   //递归
        root.right = helper(nums, mid+1, right);
        return root;
    }
}