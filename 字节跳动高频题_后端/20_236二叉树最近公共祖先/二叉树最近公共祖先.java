/*
236. 二叉树的最近公共祖先
给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]



 

示例 1:

输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
输出: 3
解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
示例 2:

输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
输出: 5
解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 

说明:

所有节点的值都是唯一的。
p、q 为不同节点且均存在于给定的二叉树中。
*/

//递归：官方解答：
//https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/er-cha-shu-de-zui-jin-gong-gong-zu-xian-by-leetc-2/

//Java
//Author:Joey
//Date：2020/07/18

/*
执行结果：
执行用时：8 ms, 在所有 Java 提交中击败了65.50%的用户
内存消耗：42 MB, 在所有 Java 提交中击败了5.71%的用户
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
    public TreeNode res;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return res;             
    }
    public boolean helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean lson = helper(root.left, p, q);
        boolean rson = helper(root.right, p, q);
        if ((lson && rson) || ((root == p || root == q) && (rson || lson))) {
            res = root;
        }
        return lson || rson || (root == p || root == q);
    }
}

//改进版，参考：https://blog.csdn.net/q_all_is_well/article/details/88136396

/*
执行结果：
执行用时：7 ms, 在所有 Java 提交中击败了99.91%的用户
内存消耗：42 MB, 在所有 Java 提交中击败了5.71%的用户
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;  //递归出口

        TreeNode left = lowestCommonAncestor(root.left, p, q);  
        TreeNode right = lowestCommonAncestor(root.right, p, q);  //开始递归，直至满足三个出口条件之一

        if (left != null && right != null) {  //最近的root分支下，分别找到p和q ，跳出
            return root;
        }
        return left == null ? right : left;  //只找到其中之一，另一个必是公共祖先
    }
}
