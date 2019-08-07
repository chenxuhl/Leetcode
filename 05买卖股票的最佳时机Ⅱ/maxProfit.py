#贪心算法，只要升值就抛售

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        n = len(prices)
        result = 0
        for i in range(1, n):
            d = prices[i] - prices[i-1]
            if d >0:
                result += d
        return result