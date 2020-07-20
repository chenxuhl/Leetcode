/*
101. �Գƶ�����
����һ����������������Ƿ��Ǿ���ԳƵġ�

 

���磬������ [1,2,2,3,4,4,3] �ǶԳƵġ�

    1
   / \
  2   2
 / \ / \
3  4 4  3
 

����������� [1,2,2,null,3,null,3] ���Ǿ���ԳƵ�:

    1
   / \
  2   2
   \   \
   3    3
 

���ף�

��������õݹ�͵������ַ���������������
*/

//�ο��ٷ��𰸣��ݹ�

//Java
//Author:Joey
//Date��2020/07/20

/*
ִ�н����
ִ����ʱ��0 ms, ������ Java �ύ�л�����100.00%���û�
�ڴ����ģ�37.8 MB, ������ Java �ύ�л�����35.00%���û�
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
    public boolean isSymmetric(TreeNode root) {  //�ѵ����ڣ��õ�˫ָ��
        return helper(root, root);        
    }
    public boolean helper(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && helper(p.left, q.right) && helper(p.right, q.left);
    }
}

//���������ö��У��ݹ�ĵ������÷�����

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
    public boolean isSymmetric(TreeNode root) {
        return helper(root, root);        
    }
    public boolean helper(TreeNode u, TreeNode v) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        Queue<TreeNode> p = new LinkedList<TreeNode>();

        q.offer(u);
        q.offer(v);
        while (!q.isEmpty()) {
            u = q.poll();
            v = q.poll();
            if (u == null && v == null) continue;
            if ((u == null || v == null) || (u.val != v.val)) {
                return false;
            }
            q.offer(u.left);
            q.offer(v.right);

            q.offer(u.right);
            q.offer(v.left);
        }
        return true;
    }
}