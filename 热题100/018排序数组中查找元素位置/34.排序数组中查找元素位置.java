/**
34. 在排序数组中查找元素的第一个和最后一个位置
给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

你的算法时间复杂度必须是?O(log n) 级别。

如果数组中不存在目标值，返回?[-1, -1]。

示例 1:

输入: nums = [5,7,7,8,8,10], target = 8
输出: [3,4]
示例?2:

输入: nums = [5,7,7,8,8,10], target = 6
输出: [-1,-1]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
**/

//Java
//-*- coding:utf-8 -*-
//JoeyChen
//2020/04/14

//方法一：二分法

/**
解题思路：
先利用二分法找到一个target，然后左右找到边界索引
**/

/**
执行结果：
执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗 :42.8 MB, 在所有 Java 提交中击败了70.18%的用户
**/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int sign = -1;  //记录二分法找到target值对应nums中的index
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (right + left) / 2;
            //唯一出口,也要考虑到找不到情况
            if (nums[mid] == target) {
                sign = mid;
                break;
            }
            else if (nums[mid] > target) {
                if (mid == right) break; //找不到的情况，避免死循环
                right = mid;
            } else {
                if (mid == left) break;  //找不到的情况
                left = mid;
            }
        }

        if (sign == -1) return new int[]{-1, -1};
        else {
            int a = sign, b = sign;
            while (a>0 && nums[a-1] == target) a--;
            while (b<nums.length-1 && nums[b+1] == target) b++;  //找到左右边界
            return new int[]{a, b};
        }


    }
}

