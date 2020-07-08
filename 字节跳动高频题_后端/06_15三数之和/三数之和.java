/*
15. 三数之和
给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。

 

示例：

给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/

/*
解题思路：类似于二分搜索的思路，定义left和right两个指针
难点在于去重
*/

//Java
//Author:Joey
//Date：2020/07/08

/*
执行结果：
执行用时：23 ms, 在所有 Java 提交中击败了83.01%的用户
内存消耗：43.9 MB, 在所有 Java 提交中击败了98.11%的用户
*/

import java.util.*;
import java.lang.Math;
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List res = new ArrayList();
		if (nums == null || n < 3) return res;
        //排序便于去重
        Arrays.sort(nums);
        for (int i = 0 ; i < n - 2; i++) {
            if (nums[i] > 0) break;  //节省时间
            //去重
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int target = -nums[i];
            int left = i + 1, right = n -1;
            while (left < right) {
                if (target == nums[left] + nums[right]) {  //同一个target找到所有可能的三元组
                    List temp = new ArrayList();
                    temp.add(-target);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    res.add(temp);
                    left++;
                    right--;
                    //去重
                    while (left < right && nums[left] == nums[left-1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right+1]) {
                        right--;
                    }
                } 
                else if (target < nums[left] + nums[right]) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }
}