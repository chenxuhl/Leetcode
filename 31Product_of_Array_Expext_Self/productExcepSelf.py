#238.除自身以外数组的乘积
"""
题目描述：

给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。


"""
#示例：
""""
输入: [1,2,3,4]
输出: [24,12,8,6]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/product-of-array-except-self
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
#解题思路：
"""
V1.0:由于题目中时间复杂度的限制，考虑分别用两个数组保存原数组中相应位置数左边所有数的乘积，
和其右边所有数的乘积，最终要返回的数组res中的每个元素值，就是L和R对应位置数的乘积
V2.0:改进如下：取消R，L两个数组，只用res保存结果，首次遍历 res中每个值，是原nums中对应位置数
左侧全部数的乘积，然后从后往前遍历，依次乘上r_val(对应原nums中相应位置右侧所有数的乘积),代码如下：
"""
#python3 ---V1.0
class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        length = len(nums)
        L = [1 for _ in range(length)]
        R = [1 for _ in range(length)]
        res = [1 for _ in range(length)]

        for i in range(length - 1):
            L[i + 1] = L[i] * nums[i]

        for j in range(length - 1, 0, -1):
            R[j - 1] = R[j] * nums[j]

        for k in range(length):
            res[k] = L[k] * R[k]

        return res
#python3---V2.0
class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        length = len(nums)
        res = [1 for _ in range(length)]
        for i in range(1, length):
            res[i] = res[i - 1] * nums[i - 1]

        r_val = 1
        for j in range(length - 1, -1, -1):
            res[j] *= r_val
            r_val *= nums[j]
        return res