/*
剑指 Offer 32 - II. 从上到下打印二叉树 II
从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。

 

例如:
给定二叉树: [3,9,20,null,null,15,7],

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
 

提示：

节点总数 <= 1000
注意：本题与主站 102 题相同：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
*/

//Java
//Author:Joey
//Date：2020/08/03

/*
解题思路: 队列
*/

//时间复杂度: O(n), 空间复杂度：O(n)

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        if (root == null) return res;
        //队列
        Queue<TreeNode> que = new LinkedList();
        que.offer(root);
        while (!que.isEmpty()) {
            List<Integer> temp = new ArrayList();
            int n = que.size();
            for (int i = n; i > 0; i--) {
                TreeNode node = que.poll();
                temp.add(node.val);
                if (node.left != null) que.offer(node.left);
                if (node.right != null) que.offer(node.right);
            }
            res.add(temp);          
        }
        return res;
    }
}