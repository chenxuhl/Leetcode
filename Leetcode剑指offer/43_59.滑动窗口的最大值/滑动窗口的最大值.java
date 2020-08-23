/*
剑指 Offer 59 - I. 滑动窗口的最大值
给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。

示例:

输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
输出: [3,3,5,5,6,7] 
解释: 

  滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 

提示：

你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。

注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/
*/

//Java
//Author:Joey
//Date：2020/08/20

//解题思路：暴力

//时间复杂度：O(n*(n-k)), 空间复杂度：O(n-k)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];
        int n = nums.length;
        int[] res = new int[n-k+1];
        int left = 0, right = k -1;
        while (right < n) {
            int temp = Integer.MIN_VALUE;
            for (int i = left; i <= right; i++) {
                temp = Math.max(temp, nums[i]);
            }
            res[left] = temp;
            left++;
            right++;
        }
        return res;

    }
}