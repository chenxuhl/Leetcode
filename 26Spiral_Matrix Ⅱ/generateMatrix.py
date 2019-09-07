#59.螺旋矩阵 Ⅱ
"""
题目描述：

给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
"""
#示例：
"""
输入: 3
输出:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
"""
#解题思路：
"""
用方向变量改变前进方向。参考：https://blog.csdn.net/qq_32424059/article/details/89035390
"""
#Python3
class Solution:
    def generateMatrix(self, n: int) -> List[List[int]]:
        res = [[0 for i in range(n)] for j in range(n)] #生成3×3的全零矩阵

        i, j, di, dj = 0, 0, 0, 1
        for number in range(1, n ** 2 + 1):
            res[i][j] = number
            if res[(i + di) % n][(j + dj) % n] != 0:  # 需要转向
                di, dj = dj, -di  #精妙的转向
            i += di
            j += dj
        return res
