#121.买卖股票的最佳时机
"""
题目描述：
给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。

注意你不能在买入股票前卖出股票。
"""
#示例1：
"""
输入: [7,1,5,3,6,4]
输出: 5
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
"""
#示例2：
"""
输入: [7,6,4,3,1]
输出: 0
解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
#解题思路:
"""
一开始使用暴力搜索法，遍历所有可能结果存到列表里，然后从列表里取最大元素返回，若列表为空，则返回0
W_W,结果超时，，换一种思路：遍历一次数组，用min_value存储遍历过的最小数，max_profit不断更新为当前
遍历到的值与最小值之间差的最大值，最后返回max_profit
"""
#python3
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        length = len(prices)
        if length == 0: #判断数组为空，直接返回0
            return 0
        else:
            max_profit = 0
            min_value = prices[0]
            for i in range(1, length):
                min_value = min(min_value, prices[i])
                max_profit = max(max_profit, prices[i] - min_value)
            return max_profit
