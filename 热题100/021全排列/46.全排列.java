/**
 * 46.ȫ����
 * ����һ�� û���ظ� ���ֵ����У����������п��ܵ�ȫ���С�
 * <p>
 * ʾ��:
 * <p>
 * ����: [1,2,3]
 * ���:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/permutations
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 **/

//Java 
//- * - coding��utf-8 - * -
//Author:JoeyChen
//Data:2020/04/17

//����һ�����ݷ�

/**
 ִ�н����
 ִ����ʱ :2 ms, ������ Java �ύ�л�����78.96%���û�
 �ڴ����� :40.3 MB, ������ Java �ύ�л�����7.32%���û�
 **/

class Solution {
    public void backtrack(int n,
                          ArrayList<Integer> nums,
                          List<List<Integer>> output,
                          int first) {
        // �ݹ����
        if (first == n)
            output.add(new ArrayList<Integer>(nums));
        for (int i = first; i < n; i++) {
            Collections.swap(nums, first, i);
            backtrack(n, nums, output, first + 1);
            //��ԭ
            Collections.swap(nums, first, i);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new LinkedList();

        // ������ת�����б�
        ArrayList<Integer> nums_lst = new ArrayList<Integer>();
        for (int num : nums)
            nums_lst.add(num);

        int n = nums.length;
        backtrack(n, nums_lst, output, 0);
        return output;
    }
}