/*
69. x 的平方根
实现 int sqrt(int x) 函数。

计算并返回 x 的平方根，其中 x 是非负整数。

由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

示例 1:

输入: 4
输出: 2
示例 2:

输入: 8
输出: 2
说明: 8 的平方根是 2.82842..., 
     由于返回类型是整数，小数部分将被舍去。
*/

//Java
//Author:Joey
//Date：2020/07/25

//解题思路：二分法，注意结果long型


/*
执行结果：
执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：36.3 MB, 在所有 Java 提交中击败了5.55%的用户
*/

class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        int left = 0, right = x, res = 0;
        while (left <= right) {
            int mid = (right + left) / 2;
            if ((long)mid * mid <= x) {  //加long
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}

//解法二：换底公式，x(1/2) = e(lnx * 1/2)

class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int ans = (int)Math.exp(0.5 * Math.log(x));
        return (long)(ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
    }
}
