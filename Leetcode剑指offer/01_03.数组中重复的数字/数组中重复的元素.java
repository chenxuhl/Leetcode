/*
剑指 Offer 03. 数组中重复的数字
找出数组中重复的数字。


在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。

示例 1：

输入：
[2, 3, 1, 0, 2, 5, 3]
输出：2 或 3 
 

限制：

2 <= n <= 100000
*/

//Java
//Author:Joey
//Date：2020/07/26

//解法一：先排序，再遍历，，感觉不是最优解法

//时间复杂度：O(n),空间复杂度：O(1)

class Solution {
    public int findRepeatNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n -1; i++) {
            if (nums[i] == nums[i+1]) return nums[i];
        }
        return Integer.MIN_VALUE;
    }
}

//解法二：使用HashSet, Java中Set集合，用来暂存num，若在Set中存在，返回该值

//时间复杂度：O(n),空间复杂度：O(n)

class Solution {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> temp = new HashSet();
        //不用循环遍历，用迭代器
        int res = -1;
        for (int num : nums) {
            if (!temp.add(num)){
                res = num;
                break;
            }
        }
        return res;
    }
}