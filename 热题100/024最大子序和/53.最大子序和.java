/**
53.��������
����һ���������� nums?���ҵ�һ���������͵����������飨���������ٰ���һ��Ԫ�أ������������͡�

ʾ��:

����: [-2,1,-3,4,-1,2,1,-5,4],
���: 6
����:?����������?[4,-1,2,1] �ĺ����Ϊ?6��
����:

������Ѿ�ʵ�ָ��Ӷ�Ϊ O(n) �Ľⷨ������ʹ�ø�Ϊ����ķ��η���⡣

��Դ�����ۣ�LeetCode��
���ӣ�https://leetcode-cn.com/problems/maximum-subarray
����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
**/

//Java 
//- * - coding��utf-8 - * -
//Author:JoeyChen
//Data:2020/04/19

//����һ��̰��

/**
ִ�н����
ִ����ʱ :1 ms, ������ Java �ύ�л�����96.69%���û�
�ڴ����� :39.4 MB, ������ Java �ύ�л�����41.57%���û�
**/

class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0], curmax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curmax = Math.max(curmax + nums[i], nums[i]);
            res = Math.max(res, curmax);
        }
        return res;

    }
}