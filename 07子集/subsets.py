#78.子集
#reference：http://www.voidcn.com/article/p-osxncqlg-brs.html
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.results = []
        self.search(sorted(nums), [], 0)
        return self.results
    
    def search(self, nums, S, index):
        if index == len(nums):
            self.results.append(S)
            return
        self.search(nums, S + [nums[index]], index + 1)
        self.search(nums, S, index + 1)
        
            
            
        
