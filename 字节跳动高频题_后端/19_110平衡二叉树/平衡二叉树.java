/*
110. ƽ�������
����һ�����������ж����Ƿ��Ǹ߶�ƽ��Ķ�������

�����У�һ�ø߶�ƽ�����������Ϊ��

һ��������ÿ���ڵ� ���������������ĸ߶Ȳ�ľ���ֵ������1��

ʾ�� 1:

���������� [3,9,20,null,null,15,7]

    3
   / \
  9  20
    /  \
   15   7
���� true ��

ʾ�� 2:

���������� [1,2,2,3,3,null,null,4,4]

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
���� false ��
*/

//����˼·���ݹ�

//Java
//Author:Joey
//Date��2020/07/17

/*
ִ�н����
ִ����ʱ��1 ms, ������ Java �ύ�л�����99.73%���û�
�ڴ����ģ�40.1 MB, ������ Java �ύ�л�����23.53%���û�
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
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        //���������߶Ȳ�
        return Math.abs(helper(root.left) - helper(root.right)) < 2 && isBalanced(root.left) && isBalanced(root.right);
    }
    public int helper(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(helper(root.left), helper(root.right));
    }
}