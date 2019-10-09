#5.最长回文子串
"""
题目描述：
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例1：
输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。

示例2：
输入: "cbbd"
输出: "bb"

"""
#解题思路：
"""
考虑字符串长度奇偶，具体思路见代码注释

"""
#python
#- * - coding：utf-8 - * -
#Author:JoeyChen
class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        n = len(s)
        if n < 2:
            return s
        maxlen = 0  #最长子串长度
        start = 0 #最长子串起点
        for i in range(n-1):
            if (n - i) <= maxlen // 2:
                break  #长度小于maxlen的回文子串直接舍弃
            left = right = i
            while (right < n -1) and (s[right + 1] == s[right]): #向右跳过重复项
                right += 1
            i = right + 1
            while (right < n -1) and (left > 0) and (s[right + 1] == s[left - 1]):
                right += 1
                left -= 1
            if maxlen < right - left + 1:
                maxlen = right - left + 1 #注意加一
                start = left
        return s[start:(start+maxlen)]