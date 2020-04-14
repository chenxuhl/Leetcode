/**
33.搜索旋转排序数组
假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组?[0,1,2,4,5,6,7]?可能变为?[4,5,6,7,0,1,2]?)。

搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回?-1?。

你可以假设数组中不存在重复的元素。

你的算法时间复杂度必须是?O(log?n) 级别。

示例 1:

输入: nums = [4,5,6,7,0,1,2], target = 0
输出: 4
示例?2:

输入: nums = [4,5,6,7,0,1,2], target = 3
输出: -1

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
**/

//Java
//-*- coding:utf-8 -*-
//JoeyChen
//2020/04/14

//方法一：二分法

/**
解题思路：
	根据题目时间复杂度要求，采用二分法。分析可知，每次二分后数组必定有一边是有序的，
	判断出有序数组的一边，接下来就比较容易判断出应该保留数组的哪一边。利用递归，找好递归出口，
	二分依次查找即可。
**/

/**
执行结果：
执行用时 :1 ms, 在所有 Java 提交中击败了50.28%的用户
内存消耗 :39.4 MB, 在所有 Java 提交中击败了17.74%的用户
**/

class Solution {
    public int search(int[] nums, int target) {
        return searchHelp(nums, 0, nums.length -1, target);
    }

    private int searchHelp(int[] nums, int left, int right, int target) {
        if (left > right) return -1;
        int mid = left + (right - left) / 2;
        //递归出口
        if (nums[left] == target) return left;
        if (nums[right] == target) return right;
        if (nums[mid] == target) return mid;

        if (nums[left] < nums[mid]) {  //左半边有序
            if (target > nums[left] && target < nums[mid]) {  //在左半边
                return searchHelp(nums, left+1, mid-1, target);
            } else {
                return searchHelp(nums, mid+1, right-1, target);  //在右半边
            }
        } else {  // 右半边有序
            if (target > nums[mid] && target < nums[right]) {  //右半边
                return searchHelp(nums, mid+1, right-1, target); 
            }else {
                return searchHelp(nums, left+1, mid-1, target); //左半边
            }
        }
    
    }
}

