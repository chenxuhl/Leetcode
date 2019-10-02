#14.最长公共前缀
"""
题目描述：
编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例1：
输入: ["flower","flow","flight"]
输出: "fl"

示例2：
输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。

说明:
所有输入只包含小写字母 a-z 。
"""
#解题思路：
"""
暴力搜索法：直接对每一列逐行比较
"""
#python
# - * - coding: utf-8 - * -
#Author: JoeyChen
"""
执行时间：20ms 击败了93.11%用户； 内存损耗：11.9MB
"""
class Solution(object):
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        if len(strs) == 0:
            return ""
        res = ""  #用来存储结果
        for j in range(len(strs[0])): #列
            tmp = strs[0][j]
            for i in range(1, len(strs)): #逐行比较
                if j >= len(strs[i]) or strs[i][j] != tmp:
                    return res
            res += tmp #存入结果中
        return res