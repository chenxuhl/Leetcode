/*
226. 翻转二叉树
翻转一棵二叉树。

示例：

输入：

     4
   /   \
  2     7
 / \   / \
1   3 6   9
输出：

     4
   /   \
  7     2
 / \   / \
9   6 3   1
备注:
这个问题是受到 Max Howell 的 原问题 启发的 ：

谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
*/

//解题思路：递归

//Java
//Author:Joey
//Date：2020/07/15

/*
执行结果：
执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：37.5 MB, 在所有 Java 提交中击败了6.00%的用户
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

 //递归
class Solution {
    public TreeNode invertTree(TreeNode root) {
        return helper(root);
    }
    public TreeNode helper(TreeNode root) {
        if (root == null) return root;

        TreeNode temp = new TreeNode();
        temp = helper(root.right);
        root.right = helper(root.left);
        root.left = temp;
        return root;
    }
}

//官方解题

/*
执行结果：
执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：37.2 MB, 在所有 Java 提交中击败了6.00%的用户
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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);

        root.right = left;
        root.left = right;

        return root ;

    }
}