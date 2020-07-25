/*
114. 二叉树展开为链表
给定一个二叉树，原地将它展开为一个单链表。

 

例如，给定二叉树

    1
   / \
  2   5
 / \   \
3   4   6
将其展开为：

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
*/

//Java
//Author:Joey
//Date：2020/07/25

//解题思路：在原二叉树基础上变动，将左子树移到右子树位置，右子树接到原左子树底层右子树上

/*
执行结果：
执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：39.3 MB, 在所有 Java 提交中击败了6.67%的用户
*/

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
    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left == null) root = root.right;
            else {
                TreeNode temp = root.left;
                while (temp.right != null) {  //找到左子树最底层右子树
                    temp = temp.right;
                }
                temp.right = root.right;  //并将右子树接到temp右侧
                root.right = root.left;
                root.left = null;
                root = root.right;
            }            
        }
        
    }
}
