#origin:
"""
https://leetcode-cn.com/problems/power-of-two/
"""
#Description:
"""
Given an integer, write a function to determine if it is a power of two.
"""
#Example 1:
"""
Input: 1
Output: true
Explanation: 2^0 = 1
"""
#Example 2:
"""
Input: 16
Output: true
Explanation: 2^4 = 16
"""
#Example 3:
"""
Input: 218
Output: false
"""
#Solution：
"""
Bit operation，e.g.8 & 7 (1000 & 0111 = 0000), 4 & 3 (0100 & 0011 = 0000)
"""
class Solution:
    def isPowerOfTwo(self, n: int) -> bool:
        return n > 0 and (n & n - 1) == 0
