/*
剑指 Offer 16. 数值的整数次方
实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。

 

示例 1:

输入: 2.00000, 10
输出: 1024.00000
示例 2:

输入: 2.10000, 3
输出: 9.26100
示例 3:

输入: 2.00000, -2
输出: 0.25000
解释: 2-2 = 1/22 = 1/4 = 0.25
 

说明:

-100.0 < x < 100.0
n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
注意：本题与主站 50 题相同：https://leetcode-cn.com/problems/powx-n/

通过次数30,188提交次数91,885
*/

//Java
//Author:Joey
//Date：2020/07/30

//解题思路: 位运算,,参考别人解答，如n=9,1001 = 1*2^0 + 1*2^1 + 1*2^2 + 1*2^3


//时间复杂度: O(log(n)), 空间复杂度：O(1)



class Solution {
    public double myPow(double x, int n) {
        if(x == 0) return 0;
        long b = n;
        double res = 1.0;
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }
        while(b > 0) {
            if((b & 1) == 1) res *= x;  //判断二进制最后一位是否为1
            x *= x;
            b >>= 1;  //去除最后一位，右移一位，相当于除2
        }
        return res;
    }
}
