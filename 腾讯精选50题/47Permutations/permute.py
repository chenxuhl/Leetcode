#46.全排列
"""
题目描述：
给定一个没有重复数字的序列，返回其所有可能的全排列。

示例：
输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/permutations
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

"""
#解题思路：
"""
不太会，已拿好小本本记下来，，参考：https://blog.csdn.net/xiaoxiaoley/article/details/78959928

两个元素，只有两种排列：[1,2]，[2,1]。加入第三个元素，则原排列变为[1,2,3]，[2,1,3]，
在将刚得到的两个排列的前面每一个数字和最后一个互换，因为数字不重复，所以得到的排列也不重复。
可以得到[1,2,3]，[3,2,1]，[1,3,2]，[2,1,3]，[3,1,2]，[2,3,1]。
对上述的方法进行迭代，不断加入新的元素，可以得到任意长度元素的全排列

"""
#python
#- * - coding：utf-8 - * -
#Author：JoeyChen

class Solution(object):
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        if len(nums)<=1: #单个元素直接返回
            return [nums]
        output = [[nums[0],nums[1]],[nums[1],nums[0]]]
        for i in range(2,len(nums)):
            tmp = nums[i]
            output_new = []
            for j in range(len(output)):
                output[j].append(tmp)
                output_new.append(output[j])
                for k in range(len(output[j])-1):
                    line = [n for n in output[j]]
                    line[len(line)-1] = line[k]   #新加入的元素和前面每一个元素互换
                    line[k] = tmp
                    output_new.append(line)
            output = output_new
        return output