#136.只出现一次的数字
#v1 self-thinking
class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        nums = sorted(nums)
        n = len(nums)
        result = None
        for i in range(0, n-1, 2):
            if nums[i] != nums[i+1]:
                result = nums[i]
                break
        if result == None:
            result = nums[n-1]
        return result
        

#v2 reference：https://github.com/grandyang/leetcode/issues/136
#a⊕b⊕a=b
class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        r = 0
        for num in nums:
            r ^= num
        return r