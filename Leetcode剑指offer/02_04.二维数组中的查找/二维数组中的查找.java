/*
剑指 Offer 04. 二维数组中的查找
在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

 

示例:

现有矩阵 matrix 如下：

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
给定 target = 5，返回 true。

给定 target = 20，返回 false。

 

限制：

0 <= n <= 1000

0 <= m <= 1000

 

注意：本题与主站 240 题相同：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
*/

//解法一：暴力搜索法

//时间复杂度：O(nm),空间复杂度：O(1)

class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        //n行,m列
        int n = matrix.length;
        if (n == 0) return false;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == target) return true;
            }
        }
        return false;
    }
}

//解法二：参考官网线性搜索法，从矩阵右上角开始查找

//时间复杂度：O(n + m), 空间复杂度：O(1)


class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int row = matrix.length, col = matrix[0].length;
        int row_p = 0, col_p = col -1;  //从矩阵右上角开始
        while (row_p < row && col_p >= 0) {
            if (matrix[row_p][col_p] == target) return true;
            else if (matrix[row_p][col_p] < target) {
                row_p++;
            }
            else {
                col_p--;
            }
        }
        return false;
    }
}
