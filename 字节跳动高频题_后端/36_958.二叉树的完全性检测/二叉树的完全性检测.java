/*

*/

//Java
//Author:Joey
//Date：2020/07/25

//解题思路：广度优先，层次遍历 ，队列，判断相邻节点前一个为null，后一个不为null


/*
执行结果：
执行用时：1 ms, 在所有 Java 提交中击败了94.92%的用户
内存消耗：39.1 MB, 在所有 Java 提交中击败了25.00%的用户
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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> temp = new LinkedList();
        temp.add(root);  //初始值，根节点入队列
        TreeNode prev = root;
        while (!temp.isEmpty()) {
            TreeNode cur = temp.remove();  //当前节点
            if (cur != null && prev == null) return false;
            if (cur != null) {
                temp.add(cur.left);
                temp.add(cur.right);
            }
            prev = cur;  //当前节点前一个节点
        }
        return true;
    }
}