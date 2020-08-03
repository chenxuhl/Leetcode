/*
剑指 Offer 32 - III. 从上到下打印二叉树 III
请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。

 

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
  [20,9],
  [15,7]
]
 

提示：

节点总数 <= 1000
*/

//Java
//Author:Joey
//Date：2020/08/03

/*
解题思路: 队列 链表addLast,addFirst
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
        Queue<TreeNode> que = new LinkedList();
        que.offer(root);
        while (!que.isEmpty()) {
            LinkedList<Integer> temp = new LinkedList();
            for (int i = que.size(); i > 0; i--) {
                TreeNode node = que.poll();
                if (res.size() % 2 == 0) temp.addLast(node.val); //从右往左 
                else temp.addFirst(node.val);
                if (node.left != null) que.offer(node.left);
                if (node.right != null) que.offer(node.right);
            }
            res.add(temp);
        }
        return res;
    }
}