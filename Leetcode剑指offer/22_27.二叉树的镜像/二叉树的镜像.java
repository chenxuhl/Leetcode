/*
剑指 Offer 27. 二叉树的镜像
请完成一个函数，输入一个二叉树，该函数输出它的镜像。

例如输入：

     4
   /   \
  2     7
 / \   / \
1   3 6   9
镜像输出：

     4
   /   \
  7     2
 / \   / \
9   6 3   1

 

示例 1：

输入：root = [4,2,7,1,3,6,9]
输出：[4,7,2,9,6,3,1]
 

限制：

0 <= 节点个数 <= 1000

注意：本题与主站 226 题相同：https://leetcode-cn.com/problems/invert-binary-tree/
*/

//Java
//Author:Joey
//Date：2020/08/02

/*
解题思路: 递归
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
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return root;
        TreeNode temp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(temp);
        return root;
    }
}


//辅助栈

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
    public TreeNode mirrorTree(TreeNode root) {  //深度优先，栈
        if (root == null) return root;
        Stack<TreeNode> sk = new Stack();
        sk.push(root);
        while (!sk.isEmpty()) {
            TreeNode node = sk.pop();
            if (node.left != null) sk.push(node.left);
            if (node.right != null) sk.push(node.right);
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
        return root;
    }
}

//辅助队列

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
    public TreeNode mirrorTree(TreeNode root) { //用队列
        if (root == null) return root;
        Queue<TreeNode> qu = new LinkedList();
        qu.add(root);  //初始化队列
        while (!qu.isEmpty()) {
            TreeNode node = qu.remove();
            if (node.right != null) qu.add(node.right);
            if (node.left != null) qu.add(node.left);
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
        return root;
    }
}