#11.盛最多水的容器
"""
题目描述：
给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

说明：你不能倾斜容器，且 n 的值至少为 2。

"""
#示例：
"""
输入: [1,8,6,2,5,4,8,3,7]
输出: 49

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/container-with-most-water
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
#解题思路：
"""
首先想到暴力遍历法，遍历所有可能组合并将结果保存在列表中，最后取出其中的最大值返回即可，
提交代码时提示超时；修改：替代保存所有可能结果入列表，每次通过max比较，只保留最大的结果res，还是超时

再次优化如下：定义两个参数i和j分别指向数组的左右两端，然后按照谁小谁移动将两个指针向中间移动，
每次移动算出的值和结果比较取最大值
"""
#python3
class Solution:
    def maxArea(self, height: List[int]) -> int:
        num = len(height)
        res = 0
        i, j = 0, num-1
        while i < j:
            res = max(res, (min(height[i], height[j]) * (j - i)))
            if height[i] < height[j]:  #谁小谁移动
                i += 1
            else:
                j -= 1
        return res