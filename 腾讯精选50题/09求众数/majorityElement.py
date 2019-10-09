#169.ÇóÖÚÊı
class Solution:
    def majorityElement(self, nums):
        nums.sort()
        return nums[int(len(nums)/2)]
        