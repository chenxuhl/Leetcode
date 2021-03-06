#8.字符串转换成整型
"""
题目描述：

请你来实现一个 atoi 函数，使其能将字符串转换成整数。

首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。

当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。

该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。

注意：

假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
在任何情况下，若函数不能进行有效的转换时，请返回 0。

说明：
假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。
如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。

示例1：
输入: "42"
输出: 42

示例2：
输入: "   -42"
输出: -42
解释: 第一个非空白字符为 '-', 它是一个负号。
     我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。

示例3：
输入: "-91283472332"
输出: -2147483648
解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
     因此返回 INT_MIN (−231) 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/string-to-integer-atoi
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


"""
#解题思路：
"""
主要分成五种情况：
1. 若字符串开头是空格，则跳过所有空格，到第一个非空格字符，如果没有，则返回0.

2. 若第一个非空格字符是符号 +/-，则标记 sign 的正负

3. 若下一个字符不是数字，则返回0. 不考虑小数点和自然数的情况。

4. 如果下一个字符是数字，则转为整形存下来，若接下来再有非数字出现，则返回目前的结果。

5. 还需要考虑边界问题，如果超过了整型数的范围，则用边界值替代当前值。

"""
#python
#- * - coding:utf-8 - * -
#Author: JoeyChen
class Solution(object):
    def myAtoi(self, str):
        """
        :type str: str
        :rtype: int
        """
        n = len(str)
        if n == 0: #判非空
            return 0
        sign = 1
        base = 0
        i = 0
        while (i < n and str[i] == " "): #判空格
            i += 1
        if (i < n and (str[i] == "+" or str[i] == "-")): #判正负
            sign = 1 if str[i] == "+" else -1
            i += 1
        while (i < n and str[i] >= "0" and str[i] <= "9"):
            if (base > 214748364 or (base == 214748364 and int(str[i]) > 7)): #判范围
                return 2147483647 if sign == 1 else -2147483648
            base = 10 * base + int(str[i])
            i += 1
        return base * sign

