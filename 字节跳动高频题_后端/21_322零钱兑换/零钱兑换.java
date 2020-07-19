/*
322. 零钱兑换
给定不同面额的硬币 coins 和一个总金额 amount。
编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
如果没有任何一种硬币组合能组成总金额，返回 -1。


示例 1:

输入: coins = [1, 2, 5], amount = 11
输出: 3 
解释: 11 = 5 + 5 + 1
示例 2:

输入: coins = [2], amount = 3
输出: -1
 

说明:
你可以认为每种硬币的数量是无限的。
*/

//解题思路：十分类似爬楼梯，，动态规划
//但尝试没解出，参考官方答案

//Java
//Author:Joey
//Date：2020/07/19

/*
执行结果：
执行用时：41 ms, 在所有 Java 提交中击败了12.13%的用户
内存消耗：39.5 MB, 在所有 Java 提交中击败了5.77%的用户
*/

public class Solution {

  public int coinChange(int[] coins, int amount) {
    if (amount < 1) return 0;
    return coinChange(coins, amount, new int[amount]);  //动态规划+递归
  }

  private int coinChange(int[] coins, int rem, int[] count) {  //初始化count，值都为0
    if (rem < 0) return -1;
    if (rem == 0) return 0;
    if (count[rem - 1] != 0) return count[rem - 1];  //三个递归出口
    int min = Integer.MAX_VALUE;
    for (int coin : coins) {  //挑选出硬币最少的组合
      int res = coinChange(coins, rem - coin, count);
      if (res >= 0 && res < min)
        min = 1 + res;
    }
    count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
    return count[rem - 1];
  }
}
