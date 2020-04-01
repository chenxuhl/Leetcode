#题目描述：
"""
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：

输入: "cbbd"
输出: "bb"

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-palindromic-substring
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
#解题思路：
"""
分两种情况：1）字符串长度为奇数：找到最长子串的中心 2）偶数：找到中间两个字符作为中心
"""
#python
#Author：JoeyChen
#data:2019.12.04
#runtime:376ms,超过85.04%提交记录
class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        nums = len(s)
        if nums < 2:
            return s
        start = 0
        max_len = 0
        for i in range(nums-1):
            if (nums - i) <= max_len // 2:  #找到最长子串
                break
            right = left = i  #起始寻找点
            while(right < nums-1) and (s[right] == s[right + 1]):  #偶数回文子串
                right += 1
            i = right + 1 
            while(right < nums - 1) and (left > 0) and (s[left - 1] == s[right + 1]):  #以中心点向两边扩散
                left -= 1
                right += 1
            if max_len < right - left + 1:  #判断是否为最长回文子串
                max_len = right - left + 1
                start = left
        return s[start:(start + max_len)]