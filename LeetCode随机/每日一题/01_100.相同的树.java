/*
100. 相同的树
给定两个二叉树，编写一个函数来检验它们是否相同。

如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。

示例 1:

输入:       1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

输出: true
示例 2:

输入:      1          1
          /           \
         2             2

        [1,2],     [1,null,2]

输出: false
示例 3:

输入:       1         1
          / \       / \
         2   1     1   2

        [1,2,1],   [1,1,2]

输出: false
*/

//Java
//Author:Joey
//Date：2020/08/06

//解题思路：辅助栈，广度优先

//时间复杂度: O(min(n,m)), 空间复杂度：O(min(n,m))

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //辅助栈
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        Deque<TreeNode> stack1 = new ArrayDeque();
        Deque<TreeNode> stack2 = new ArrayDeque();
        stack1.push(p);
        stack2.push(q);
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            TreeNode node1 = stack1.pop();
            TreeNode node2 = stack2.pop();
            if (node1.val != node2.val) return false;
            if (node1.left == null ^ node2.left == null) return false;
            if (node1.right == null ^ node2.right == null) return false;
            if (node1.left != null) stack1.push(node1.left);
            if (node1.right != null) stack1.push(node1.right);
            if (node2.left != null) stack2.push(node2.left);
            if (node2.right != null) stack2.push(node2.right);
        }
        return stack1.isEmpty() && stack2.isEmpty();
        
    }
}

//递归：深度优先

//时间复杂度: O(min(n,m)), 空间复杂度：O(min(n,m))

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);        
    }
}
