/*
704. 二分查找
给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。


示例 1:

输入: nums = [-1,0,3,5,9,12], target = 9
输出: 4
解释: 9 出现在 nums 中并且下标为 4
示例 2:

输入: nums = [-1,0,3,5,9,12], target = 2
输出: -1
解释: 2 不存在 nums 中因此返回 -1
 

提示：

你可以假设 nums 中的所有元素是不重复的。
n 将在 [1, 10000]之间。
nums 的每个元素都将在 [-9999, 9999]之间。
*/

//Java
//Author:Joey
//Date：2020/07/24

//解题思路：左右指针


/*
执行结果：
执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：41 MB, 在所有 Java 提交中击败了5.26%的用户
*/

class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return -1;
        if (n == 1) return nums[0] == target ? 0 : -1;
        int left = 0, right = n -1;
        while (left <= right) {
            int mid = (left + right) / 2;  //二分中点
            if (target == nums[mid]) return mid;
            else if (target < nums[mid]) {
                right = mid-1;
            }
            else left = mid+1;
        }
        return -1;
    }
}