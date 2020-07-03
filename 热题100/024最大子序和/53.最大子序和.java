/**
53.最大子序和
给定一个整数数组 nums?，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例:

输入: [-2,1,-3,4,-1,2,1,-5,4],
输出: 6
解释:?连续子数组?[4,-1,2,1] 的和最大，为?6。
进阶:

如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-subarray
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
**/

//Java 
//- * - coding：utf-8 - * -
//Author:JoeyChen
//Data:2020/04/19

//方法一：贪心

/**
执行结果：
执行用时 :1 ms, 在所有 Java 提交中击败了96.69%的用户
内存消耗 :39.4 MB, 在所有 Java 提交中击败了41.57%的用户
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