/*
102. 二叉树的层序遍历
给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。

 

示例：
二叉树：[3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：

[
  [3],
  [9,20],
  [15,7]
]
*/

/*
解题思路：利用队列先进先出特性
*/

//Java
//Author:Joey
//Date：2020/07/07

/*
执行结果：
执行用时：1 ms, 在所有 Java 提交中击败了90.89%的用户
内存消耗：40.3 MB, 在所有 Java 提交中击败了5.71%的用户
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
 //方法一：利用队列  广度优先遍历BFS
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List res = new ArrayList();

        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.add(root);  //压入队列

        while (!queue.isEmpty()) {
            List level = new ArrayList();
            int n = queue.size();  //每层节点数
            for (int i = 0; i < n; i++) {
                TreeNode head = queue.poll();  //弹出当前节点
                level.add(head.val);  //当前节点值add进数组中
                if (head.left != null) {
                    queue.add(head.left);  //队列为下一次遍历做准备
                }
                if (head.right != null) {
                    queue.add(head.right);
                }

            }
            res.add(level);
            
        }
        return res;
    }
}