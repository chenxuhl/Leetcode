#53.最大子序和
"""
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
"""
#示例：
"""
输入: [-2,1,-3,4,-1,2,1,-5,4],
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-subarray
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
#解题思路：
"""
定义两个参数；res,curSum ，res用来存放最终要返回的结果，curSum初始值为0，每遍历一个数字num

比较curSum和curSum + num的大小，值较大的存入curSum，然后再把curSum和res中最大的值存入res

直至便利完整个数组，可得到最大子数组的值存入res

"""
#python3
class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        curSum = 0
        res = float('-Inf')
        for i in range(len(nums)):
            curSum = max(curSum + nums[i], nums[i])
            res = max(res, curSum)
        return res
