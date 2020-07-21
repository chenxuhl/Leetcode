/*
221. 最大正方形
在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。

示例:

输入: 

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

输出: 4
*/

//官方解答：动态规划：状态方程：dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1

//Java
//Author:Joey
//Date：2020/07/21

/*
执行结果：
执行用时：7 ms, 在所有 Java 提交中击败了40.65%的用户
内存消耗：42.9 MB, 在所有 Java 提交中击败了43.75%的用户
*/

class Solution {
    public int maximalSquare(char[][] matrix) {  //动态规划
        int max_size = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return max_size;
        }
        int row = matrix.length, col = matrix[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {  //初始化矩阵
                        dp[i][j] = 1;
                    } 
                    else {
                        dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;  //状态方程
                    }                                      
                }   
                max_size = Math.max(max_size, dp[i][j]);               
            }
        }
        return max_size * max_size;
    }
}