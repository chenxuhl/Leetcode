/**
 * 33.������ת��������
 * ���谴�����������������Ԥ��δ֪��ĳ�����Ͻ�������ת��
 * <p>
 * ( ���磬����?[0,1,2,4,5,6,7]?���ܱ�Ϊ?[4,5,6,7,0,1,2]?)��
 * <p>
 * ����һ��������Ŀ��ֵ����������д������Ŀ��ֵ���򷵻��������������򷵻�?-1?��
 * <p>
 * ����Լ��������в������ظ���Ԫ�ء�
 * <p>
 * ����㷨ʱ�临�Ӷȱ�����?O(log?n) ����
 * <p>
 * ʾ�� 1:
 * <p>
 * ����: nums = [4,5,6,7,0,1,2], target = 0
 * ���: 4
 * ʾ��?2:
 * <p>
 * ����: nums = [4,5,6,7,0,1,2], target = 3
 * ���: -1
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * <p>
 * ����˼·��
 * ������Ŀʱ�临�Ӷ�Ҫ�󣬲��ö��ַ���������֪��ÿ�ζ��ֺ�����ض���һ��������ģ�
 * �жϳ����������һ�ߣ��������ͱȽ������жϳ�Ӧ�ñ����������һ�ߡ����õݹ飬�Һõݹ���ڣ�
 * �������β��Ҽ��ɡ�
 **/

//Java
//-*- coding:utf-8 -*-
//JoeyChen
//2020/04/14

//����һ�����ַ�

/**
 ����˼·��
 ������Ŀʱ�临�Ӷ�Ҫ�󣬲��ö��ַ���������֪��ÿ�ζ��ֺ�����ض���һ��������ģ�
 �жϳ����������һ�ߣ��������ͱȽ������жϳ�Ӧ�ñ����������һ�ߡ����õݹ飬�Һõݹ���ڣ�
 �������β��Ҽ��ɡ�
 **/

/**
 ִ�н����
 ִ����ʱ :1 ms, ������ Java �ύ�л�����50.28%���û�
 �ڴ����� :39.4 MB, ������ Java �ύ�л�����17.74%���û�
 **/

class Solution {
    public int search(int[] nums, int target) {
        return searchHelp(nums, 0, nums.length - 1, target);
    }

    private int searchHelp(int[] nums, int left, int right, int target) {
        if (left > right) return -1;
        int mid = left + (right - left) / 2;
        //�ݹ����
        if (nums[left] == target) return left;
        if (nums[right] == target) return right;
        if (nums[mid] == target) return mid;

        if (nums[left] < nums[mid]) {  //��������
            if (target > nums[left] && target < nums[mid]) {  //������
                return searchHelp(nums, left + 1, mid - 1, target);
            } else {
                return searchHelp(nums, mid + 1, right - 1, target);  //���Ұ��
            }
        } else {  // �Ұ������
            if (target > nums[mid] && target < nums[right]) {  //�Ұ��
                return searchHelp(nums, mid + 1, right - 1, target);
            } else {
                return searchHelp(nums, left + 1, mid - 1, target); //����
            }
        }

    }
}

