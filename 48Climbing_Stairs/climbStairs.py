# 70.爬楼梯
"""
题目描述：
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

注意：给定 n 是一个正整数。

示例1：
输入： 2
输出： 2
解释： 有两种方法可以爬到楼顶。
1.  1 阶 + 1 阶
2.  2 阶

示例2：
输入： 3
输出： 3
解释： 有三种方法可以爬到楼顶。
1.  1 阶 + 1 阶 + 1 阶
2.  1 阶 + 2 阶
3.  2 阶 + 1 阶

"""
#解题思路：
"""
通过分析可知，n阶 只能从n-1阶或n-2阶上来
类似斐波那契数列，动态规划：dp[n] = dp[n-1] + dp[n-2]
"""
#python
#- * - coding：utf-8 - * -
#Author：JoeyChen
class Solution(object):
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n == 1:
            return 1
        dp = [0 for _ in range(n)] #定义一个空列表
        dp[0] = 1
        dp[1] = 2
        for i in range(2, n):
            dp[i] = dp[i - 1] + dp[i - 2] #状态方程
        return dp[n-1]