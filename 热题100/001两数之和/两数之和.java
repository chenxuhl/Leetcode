/**
 * 1.����֮��
 * ��Ŀ������
 * ����һ���������� nums?��һ��Ŀ��ֵ target�������ڸ��������ҳ���ΪĿ��ֵ����?����?���������������ǵ������±ꡣ
 * <p>
 * ����Լ���ÿ������ֻ���Ӧһ���𰸡����ǣ��㲻���ظ��������������ͬ����Ԫ�ء�
 * <p>
 * ʾ��:
 * <p>
 * ���� nums = [2, 7, 11, 15], target = 9
 * <p>
 * ��Ϊ nums[0] + nums[1] = 2 + 7 = 9
 * ���Է��� [0, 1]
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/two-sum
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * <p>
 * ������ֻ��Ҫ��Ŀ��ֵ�͸���������ֵ�����������map��ɵó������
 **/

/**
 ������ֻ��Ҫ��Ŀ��ֵ�͸���������ֵ�����������map��ɵó������
 **/

//Java 
//- * - coding��utf-8 - * -
//Author:JoeyChen
//Data:2020/04/01

/**
 ִ�н����
 ִ����ʱ :2 ms, ������ Java �ύ�л�����99.58%���û�
 �ڴ����� :40.3 MB, ������ Java �ύ�л�����5.10%���û�
 **/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] res = new int[2];
        for (int i = 0, len = nums.length; i < len; ++i) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return res;

    }
}