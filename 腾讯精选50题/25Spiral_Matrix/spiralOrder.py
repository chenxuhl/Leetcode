#54.螺旋矩阵
"""
题目描述：

给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
"""
#示例1：
"""
输入:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
输出: [1,2,3,6,9,8,7,4,5]
"""
#示例2：
"""
输入:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
输出: [1,2,3,4,8,12,11,10,9,5,6,7]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/spiral-matrix
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
#解题思路：
"""
递归：
1、读取最上面一行，从左往右
2、将最上面一行从矩阵中删除
3、将矩阵逆时针旋转90度
4、递归，继续
参考：https://blog.csdn.net/HappyRocking/article/details/84938127
"""
#python3
class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        return matrix and [*matrix.pop(0)] + self.spiralOrder([*zip(*matrix)][::-1])

"""
说明：
1、[*zip(*matrix)] 表示将 matrix 的第一列作为第一行，第二列作为第二行… 即将矩阵进行对角线对称。
2、[*zip(*matrix)][::-1] 表示先将 matrix 进行对角线对称，然后将所有行逆序排列。相当于=逆时针旋转90°
"""