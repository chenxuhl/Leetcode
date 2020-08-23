/*
剑指 Offer 49. 丑数
我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。

 

示例:

输入: n = 10
输出: 12
解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
说明:  

1 是丑数。
n 不超过1690。
注意：本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/
*/

//Java
//Author:Joey
//Date：2020/08/20

//解题思路：动态规划

//时间复杂度：O(n), 空间复杂度：O(n)

class Solution {
    public int nthUglyNumber(int n) {  //动态规划
        if (n == 0) return 0;
        int[] dp = new int[n];
        int a = 0, b = 0, c = 0;
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[a]*2, Math.min(dp[b]*3, dp[c]*5));
            if (dp[i] == dp[a]*2) a++;
            if (dp[i] == dp[b]*3) b++;
            if (dp[i] == dp[c]*5) c++;
        }
        return dp[n-1];
    }
}