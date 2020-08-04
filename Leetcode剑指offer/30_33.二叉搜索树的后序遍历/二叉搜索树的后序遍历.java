/*
剑指 Offer 33. 二叉搜索树的后序遍历序列
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。
假设输入的数组的任意两个数字都互不相同。

 

参考以下这颗二叉搜索树：

     5
    / \
   2   6
  / \
 1   3
示例 1：

输入: [1,6,3,2,5]
输出: false
示例 2：

输入: [1,3,2,6,5]
输出: true
 

提示：

数组长度 <= 1000
*/

//Java
//Author:Joey
//Date：2020/08/04

/*
解题思路: 递归，数组末尾为root，从0开始遍历数组，小于root为左子树，
大于root为右子树，右子树中若有小于root，则返回false
*/

//时间复杂度: O(n^2), 空间复杂度：O(n)

class Solution {
    public boolean verifyPostorder(int[] postorder) {  //后序遍历
        if (postorder.length < 1) return true;
        int n = postorder.length;
        return helper(postorder, 0, n-1);      

    }
    public boolean helper(int[] postorder, int left, int right) {  //递归
        if (left >= right) return true;
        int root = postorder[right];
        int temp_left = left;
        while (temp_left < right) {
            if (postorder[temp_left] < root) temp_left++;
            else break;
        }
        int temp_right = temp_left;
        while (temp_right < right) {
            if (postorder[temp_right] < root) return false;
            temp_right++;
        }
        return helper(postorder, left, temp_left-1) && helper(postorder, temp_left,  right-1);
    }
}