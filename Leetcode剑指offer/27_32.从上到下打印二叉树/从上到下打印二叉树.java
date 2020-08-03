/*
剑指 Offer 32 - I. 从上到下打印二叉树
从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。

 

例如:
给定二叉树: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回：

[3,9,20,15,7]
 

提示：

节点总数 <= 1000
*/

//Java
//Author:Joey
//Date：2020/08/03

/*
解题思路: 队列，广度优先
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
    public int[] levelOrder(TreeNode root) {  //队列实现
        if (root == null) return new int[0];
        List<Integer> res = new ArrayList();

        Queue<TreeNode> temp = new LinkedList();
        temp.offer(root);  //队列，先进先出
        while (!temp.isEmpty()) {
            TreeNode node = temp.poll();
            res.add(node.val);
            if (node.left != null) temp.offer(node.left);
            if (node.right != null) temp.offer(node.right);            
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}