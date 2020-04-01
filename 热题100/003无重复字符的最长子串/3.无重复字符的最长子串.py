# -*- coding:utf-8 -*-
#Author:JoeyChen
"""
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
#python

class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        max_num = 0
        num = 0
        sub_s = ''
        for i in s:
            if i not in sub_s:
                sub_s = sub_s + i
                num += 1
            else:
                if num >= max_num:
                    max_num = num
                index = sub_s.index(i)
                sub_s = sub_s[(index + 1):] + i   #key_point,从第一个被重复到的字符后面字符串计算长度
                num = len(sub_s)
        if num > max_num:  #避免只含有一个字符，没有循环到for里面的else语句
            max_num = num
        return max_num

