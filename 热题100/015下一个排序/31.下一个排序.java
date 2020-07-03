/**
 * 31.��һ������
 * ʵ�ֻ�ȡ��һ�����еĺ������㷨��Ҫ���������������������г��ֵ�������һ����������С�
 * <p>
 * �����������һ����������У��������������г���С�����У����������У���
 * <p>
 * ����ԭ���޸ģ�ֻ����ʹ�ö��ⳣ���ռ䡣
 * <p>
 * ������һЩ���ӣ�����λ������У�����Ӧ���λ���Ҳ��С�
 * 1,2,3 �� 1,3,2
 * 3,2,1 �� 1,2,3
 * 1,1,5 �� 1,5,1
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/next-permutation
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * <p>
 * ����˼·��
 * ��������������飬�ҵ���һ��������ݼ������������Ҳ��ҵ����������Ҵ����������������λ�ã�
 * ��������Ҳ����������������
 * �ο���https://blog.csdn.net/qq_41645636/article/details/98349631
 **/

//Java
//-*- coding:utf-8 -*-
//JoeyChen
//2020/04/12

//����һ��

/**
 ����˼·��
 ��������������飬�ҵ���һ��������ݼ������������Ҳ��ҵ����������Ҵ����������������λ�ã�
 ��������Ҳ����������������
 �ο���https://blog.csdn.net/qq_41645636/article/details/98349631
 **/

/**
 ִ�н����
 ִ����ʱ :1 ms, ������ Java �ύ�л�����99.62%���û�
 �ڴ����� :39.8 MB, ������ Java �ύ�л�����48.12%���û�
 **/

class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        while (i > 0 && nums[i - 1] >= nums[i]) {
            i--;
        }
        if (i > 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i - 1]) {
                j--;
            }
            swap(nums, i - 1, j);
        }
        reverse(nums, i);

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int i) {
        int j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}