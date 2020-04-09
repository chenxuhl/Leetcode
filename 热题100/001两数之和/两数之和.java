/**
1.两数之和
题目描述：
给定一个整数数组 nums?和一个目标值 target，请你在该数组中找出和为目标值的那?两个?整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

示例:

给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/two-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
**/

/**
分析：只需要将目标值和给定数组中值相减，并利用map便可得出结果。
**/

//Java 
//- * - coding：utf-8 - * -
//Author:JoeyChen
//Data:2020/04/01

/**
执行结果：
执行用时 :2 ms, 在所有 Java 提交中击败了99.58%的用户
内存消耗 :40.3 MB, 在所有 Java 提交中击败了5.10%的用户
**/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int [] res = new int[2];
        for (int i = 0, len = nums.length; i < len; ++i) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target-nums[i]), i};
            } else{
                map.put(nums[i], i);
            }
        }
        return res;

    }
}