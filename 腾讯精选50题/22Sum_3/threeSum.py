#15.三数之和
"""
题目描述：

给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。

"""
#示例：
"""
例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/3sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
#解题思路：
"""
首先对数组从小到大进行排序，然后从左往右依次选择数组中的一个数fix，fix取值范围为:0 - length-2, 
，若遍历到正数的时候就break，因为不可能满足三数相加为0；取fix相反数为target，再用双指针分别指向
fix右侧数组首尾两个数，如果两个数之和正好等于target，则将这两个数和fix一起存入结果中，然后继续遍历，
跳过重复数字，同样两个指针也需要检测重复数字；如果两个数之和小于target，则左边指针右移动一位，
如果两个数之和大于target，则右边指针左移动一位，直至遍历完毕。
"""
#python3
class Solution(object):
    def threeSum(self, nums):
        nums = sorted(nums) #排序
        len_nums = len(nums)
        res = []
        fix = None
        for i in range(len_nums-2):
            if nums[i] <= 0:
                if fix == nums[i]:
                    continue  #去重
                fix = nums[i]
                target = -fix
                left = i + 1
                right = len_nums - 1
                while left < right:
                    sumtwo = nums[left] + nums[right]
                    if target == sumtwo:
                        res.append([fix, nums[left], nums[right]])
                        while left < right and nums[left] == nums[left+1]:
                            left += 1
                        while left < right and nums[right] == nums[right-1]:
                            right -= 1   #去重
                        left += 1
                        right -= 1  #相等时同时向左向右移动
                    elif target > sumtwo:
                        left += 1
                    else:
                        right -= 1
        return res
