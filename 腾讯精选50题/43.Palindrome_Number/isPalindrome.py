#9.回文数
"""
题目描述：

判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

示例1：
输入: -121
输出: false
解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。

示例2：
输入: 10
输出: false
解释: 从右向左读, 为 01 。因此它不是一个回文数。

示例3：
输入: 121
输出: true

"""
#解题思路
"""
依从对比两端数值，若存在不等，则直接返回False

"""
#python
#- * - coding：utf-8 - *-
#Author:JoeyChen
class Solution(object):
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        if x < 0:
            return False
        div = 1
        while x // div >= 10: #先找到第一个div，把最高位数整除出来
            div *= 10
        while (x > 0):
            left = x // div
            right = x % 10
            if right != left:
                return False
            x = (x % div) // 10  #去掉最高位和最低位
            div //= 100
        return True
