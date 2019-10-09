#33.搜索旋转排序数组
"""
题目描述：

假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

你可以假设数组中不存在重复的元素。

你的算法时间复杂度必须是 O(log n) 级别。
"""
#示例1 & 2：
"""
输入: nums = [4,5,6,7,0,1,2], target = 0
输出: 4

输入: nums = [4,5,6,7,0,1,2], target = 3
输出: -1

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
#解题思路:
"""
由于题目限制时间复杂度必须是O(log n) ，故考虑使用二分搜索法。
二分搜索法关键在于获得了中间数后，判断下面要搜索左半段还是右半段。
如果中间数小于最右边数，则右半段是有序的，若中间数大于最右边数，
则左半段是有序的，故我们只需要在有序半段数用首尾两个数组来判断target
是否在这一区域，这样就可以断定保留哪半边
"""
#python3
"""
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        left = 0
        right = len(nums) - 1
        while left <= right:
            mid = left + (right - left)//2
            if nums[mid] == target:
                return mid
            if nums[mid] >= nums[left]:
                if nums[left] <= target and nums[mid] > target:
                    right = mid - 1;
                else:
                    left = mid + 1
            else:
                if nums[mid] < target and nums[right] >= target:
                    left = mid + 1
                else:
                    right = mid - 1
        return -1
        
"""