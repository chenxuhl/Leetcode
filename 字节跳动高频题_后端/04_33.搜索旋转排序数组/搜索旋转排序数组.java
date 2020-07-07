/*
33. 搜索旋转排序数组
假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

你可以假设数组中不存在重复的元素。

你的算法时间复杂度必须是 O(log n) 级别。

示例 1:

输入: nums = [4,5,6,7,0,1,2], target = 0
输出: 4
示例 2:

输入: nums = [4,5,6,7,0,1,2], target = 3
输出: -1
*/

/*
解题思路：首先根据中点值和左端点值关系，判断数组左侧还是右侧是有序的
分别根据两种有序情况判断其端点与目标值的大小关系，逐次二分，最终得出结果
*/

//Java
//Author:Joey
//Date：2020/07/06

/*
执行结果：
执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：39.6 MB, 在所有 Java 提交中击败了17.74%的用户
*/

class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, mid = -1;  //初始化端点值
        while (right >= left) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] >= nums[left]) {  //最大值在数组右侧，左侧数组有序，“=”不可去除
                if (target >= nums[left] && target < nums[mid]) {  //target在数组左侧
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            } else {  //右侧数组有序
                if (target <= nums[right] && target > nums[mid]) {  //target在数组右侧
                    left = mid + 1;
                } else {  //target在数组左侧
                    right = mid - 1;
                }

            }

        }
        return -1;

    }
}
