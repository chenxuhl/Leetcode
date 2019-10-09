#215.数组中的第K个最大元素

class Solution:
    def findKthLargest(self, nums, k):
        nums.sort(reverse=True)
        result = nums[k-1]
        return result
        