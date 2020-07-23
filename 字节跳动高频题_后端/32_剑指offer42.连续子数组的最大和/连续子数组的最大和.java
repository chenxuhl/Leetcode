/*
剑指 Offer 42. 连续子数组的最大和
输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。

要求时间复杂度为O(n)。

 

示例1:

输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
*/

//Java
//Author:Joey
//Date：2020/07/23

//解题思路：动态规划思想，当前数组值保存其左侧所有可能组合最大值
//状态方程：dp[i] = 1) dp[i-1] + nums[i] ， dp[i-1] > 0
//					2) nums[i]           ， others
					

/*
执行结果：
执行用时：3 ms, 在所有 Java 提交中击败了51.60%的用户
内存消耗：40.1 MB, 在所有 Java 提交中击败了9.52%的用户
*/
//时间复杂度O(n),空间复杂度O(1)
class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i-1], 0);  //状态方程
            res = Math.max(res, nums[i]);
        }
        return res;
    }
}