class Solution:
    def findKthLargest(self, nums, k):
        nums.sort(reverse=True)
        result = nums[k-1]
        return result
        