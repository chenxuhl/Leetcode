/*
121. 买卖股票的最佳时机
给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。

注意：你不能在买入股票前卖出股票。

 

示例 1:

输入: [7,1,5,3,6,4]
输出: 5
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
示例 2:

输入: [7,6,4,3,1]
输出: 0
解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
*/

//Java
//Author:Joey
//Date：2020/07/10

//方法一：暴力遍历法 时间复杂度O(n2)

/*
执行结果：
执行用时：427 ms, 在所有 Java 提交中击败了5.02%的用户
内存消耗：39.8 MB, 在所有 Java 提交中击败了5.32%的用户
*/
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0 && n == 1) return 0;        
        int max_profit = 0;
        for (int i = 0; i < n -1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (prices[i] >= prices[j]) continue;
                int temp = prices[j] - prices[i];
                if (temp > max_profit) {
                    max_profit = temp;
                }
            }
        }
        return max_profit;

    }
}

//方法二：一次遍历，记录价格最低点
/*
执行结果：
执行用时：1 ms, 在所有 Java 提交中击败了98.93%的用户
内存消耗：39.7 MB, 在所有 Java 提交中击败了5.32%的用户
*/
class Solution {
    public int maxProfit(int[] prices) {
        int min_price = Integer.MAX_VALUE;  //初始化最低价格
        int n = prices.length;
        int max_profit = 0;
        for (int i = 0; i < n; i++) {
            if (prices[i] < min_price) {
                min_price = prices[i];
            }
            else if (prices[i] - min_price > max_profit) {  //若不大于最大利润则不必保存
                max_profit = prices[i] - min_price;
            }
        }
        return max_profit;

    }
}