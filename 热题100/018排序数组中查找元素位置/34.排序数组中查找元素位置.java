/**
 * 34. �����������в���Ԫ�صĵ�һ�������һ��λ��
 * ����һ�������������е��������� nums����һ��Ŀ��ֵ target���ҳ�����Ŀ��ֵ�������еĿ�ʼλ�úͽ���λ�á�
 * <p>
 * ����㷨ʱ�临�Ӷȱ�����?O(log n) ����
 * <p>
 * ��������в�����Ŀ��ֵ������?[-1, -1]��
 * <p>
 * ʾ�� 1:
 * <p>
 * ����: nums = [5,7,7,8,8,10], target = 8
 * ���: [3,4]
 * ʾ��?2:
 * <p>
 * ����: nums = [5,7,7,8,8,10], target = 6
 * ���: [-1,-1]
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * <p>
 * ����˼·��
 * �����ö��ַ��ҵ�һ��target��Ȼ�������ҵ��߽�����
 **/

//Java
//-*- coding:utf-8 -*-
//JoeyChen
//2020/04/14

//����һ�����ַ�

/**
 ����˼·��
 �����ö��ַ��ҵ�һ��target��Ȼ�������ҵ��߽�����
 **/

/**
 ִ�н����
 ִ����ʱ :0 ms, ������ Java �ύ�л�����100.00%���û�
 �ڴ����� :42.8 MB, ������ Java �ύ�л�����70.18%���û�
 **/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int sign = -1;  //��¼���ַ��ҵ�targetֵ��Ӧnums�е�index
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (right + left) / 2;
            //Ψһ����,ҲҪ���ǵ��Ҳ������
            if (nums[mid] == target) {
                sign = mid;
                break;
            } else if (nums[mid] > target) {
                if (mid == right) break; //�Ҳ����������������ѭ��
                right = mid;
            } else {
                if (mid == left) break;  //�Ҳ��������
                left = mid;
            }
        }

        if (sign == -1) return new int[]{-1, -1};
        else {
            int a = sign, b = sign;
            while (a > 0 && nums[a - 1] == target) a--;
            while (b < nums.length - 1 && nums[b + 1] == target) b++;  //�ҵ����ұ߽�
            return new int[]{a, b};
        }


    }
}

