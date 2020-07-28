/*
剑指 Offer 07. 重建二叉树
输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。


例如，给出

前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7
 

限制：

0 <= 节点个数 <= 5000


注意：本题与主站 105 题
重复：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
*/

//Java
//Author:Joey
//Date：2020/07/28

//解题思路: 前序遍历：根左右，中序遍历：左根右,故取前序遍历首节为根节点，并在中序遍历中找到相同值temp
//中序遍历中target左侧为左子树，右侧为右子树，并找出其对应前序遍历，递归，直到数组为空

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = null;
        if (preorder.length == 0) return root;
        return helper(preorder, inorder, root);
    }
    public TreeNode helper(int[] preorder, int[] inorder, TreeNode root) {
        if (preorder.length == 0) return root;
        int temp = preorder[0];
        int label = -1;
		//找出temp在中序遍历中位置
        for (int i = 0; i < inorder.length; i++) {  //中序遍历拆分
            if (inorder[i] == temp){
                label = i;
                break;
            }
        }
		//子前中序遍历1
        int[] temp1_preorder = new int[label];  
        int[] temp1_inorder = new int[label];
        for (int i = 0; i < label; i++) {
            temp1_preorder[i] = preorder[i+1];
            temp1_inorder[i] = inorder[i];
        }
		//子前中序遍历2
        int[] temp2_preorder = new int[preorder.length-label-1];  
        int[] temp2_inorder = new int[preorder.length-label-1];
        for (int j = 0; j < preorder.length-label-1; j++) {
            temp2_preorder[j] = preorder[label+1+j];
            temp2_inorder[j] = inorder[label+1+j];
        }
		//递归调用
        root = new TreeNode(temp);
        root.left = helper(temp1_preorder, temp1_inorder, root.left);
        root.right = helper(temp2_preorder, temp2_inorder, root.right);  
        return root;      
    }
}