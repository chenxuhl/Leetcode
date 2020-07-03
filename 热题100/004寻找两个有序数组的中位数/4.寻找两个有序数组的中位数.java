/**
 * 4.Ѱ�����������������λ��
 * ����������СΪ m �� n ����������?nums1 ��?nums2��
 * <p>
 * �����ҳ������������������λ��������Ҫ���㷨��ʱ�临�Ӷ�Ϊ?O(log(m + n))��
 * <p>
 * ����Լ���?nums1?��?nums2?����ͬʱΪ�ա�
 * <p>
 * ʾ�� 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * ����λ���� 2.0
 * ʾ�� 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * ����λ���� (2 + 3)/2 = 2.5
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * <p>
 * ����˼·��
 * ����ʱ�临�Ӷ����ƣ�����ʹ�ö��ַ���
 * ����������A �� B�ֱ���зָLeft_A Right_A �� Left_B ,Right_B
 * Left_part ���� Left_A �� Left_B
 * Right_part ���� Right_A �� Right_B
 * ��λ��= ����߲������ֵ+�ұ߲�����Сֵ��/ 2
 * ���л�Ҫ����ż�Լ����������nums1��nums2ȫ����߲��ֻ��ұ߲��֣�
 **/
/**
 ����˼·��
 ����ʱ�临�Ӷ����ƣ�����ʹ�ö��ַ���
 ����������A �� B�ֱ���зָLeft_A Right_A �� Left_B ,Right_B
 Left_part ���� Left_A �� Left_B
 Right_part ���� Right_A �� Right_B
 ��λ��= ����߲������ֵ+�ұ߲�����Сֵ��/ 2
 ���л�Ҫ����ż�Լ����������nums1��nums2ȫ����߲��ֻ��ұ߲��֣�
 **/
//Java 
//- * - coding��utf-8 - * -
//Author:JoeyChen
//Data:2020/04/04

/**
 ִ�н����
 ִ����ʱ :2 ms, ������ Java �ύ�л�����100.00%���û�
 �ڴ����� :40.4 MB, ������ Java �ύ�л�����98.89%���û�
 **/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            int templenght = m;
            m = n;
            n = templenght;
        }
        int imin = 0, imax = m, half = (m + n + 1) / 2;
        while (imin <= imax) {
            int i = (imax + imin) / 2;
            int j = half - i;
            //i��С��i����������
            if (i < imax && nums2[j - 1] > nums1[i]) {
                imin = i + 1;
            }
            //i������i�����ټ�С
            else if (i > imin && nums1[i - 1] > nums2[j]) {
                imax = i - 1;
            } else {
                int leftmax = 0;
                // left_num1Ϊ��ʱ
                if (i == 0) {
                    leftmax = nums2[j - 1];
                }
                //left_num2Ϊ��ʱ
                else if (j == 0) {
                    leftmax = nums1[i - 1];
                } else {
                    leftmax = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if ((m + n) % 2 == 1) return leftmax;

                int rightmin = 0;
                // right_num1Ϊ��ʱ
                if (i == m) {
                    rightmin = nums2[j];
                }
                // right_num2Ϊ��ʱ
                else if (j == n) {
                    rightmin = nums1[i];
                } else {
                    rightmin = Math.min(nums1[i], nums2[j]);
                }
                return (leftmax + rightmin) / 2.0;
            }
        }
        return 0.0;

    }
}