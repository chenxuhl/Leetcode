#16.最接近的三数之和：
"""
题目描述：

给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
找出 nums 中的三个整数，使得它们的和与 target 最接近。
返回这三个数的和。假定每组输入只存在唯一答案。

"""
#示例：
"""
例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.

与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/3sum-closest
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
#解题思路：
"""
是15题三数之和的提升。解题思路类似，还是先将数组从小到大进行排序，然后从数组位置0~n-2依次选择一个数，
然后用两个指针分别指向选择数右端的首尾，求被选择三数之和，并求其与目标值差的绝对值newDiff,若diff>newDff
则将newDiff赋值给diff，并将三数和赋值给closest，若三数和小于目标值，left加一，若三数和大于目标值，right减一
遍历完整个数组后，返回closest即为所求 P.S.由于题目中假设每组输入只存在唯一解，故不需要去重操作。
"""
#python3
class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        nums = sorted(nums)
        length = len(nums)
        closest = nums[0] + nums[1] + nums[2]
        diff = abs(target - closest)
        for i in range(length-2):
            left = i + 1
            right = length -1
            while(left < right):   #确定跳出循环条件
                sumthree = nums[i] + nums[left] + nums[right]
                newDiff = abs(target - sumthree)
                if diff > newDiff:
                    diff = newDiff
                    closest = sumthree
                if sumthree < target:
                    left += 1
                else:
                    right -= 1
        return closest