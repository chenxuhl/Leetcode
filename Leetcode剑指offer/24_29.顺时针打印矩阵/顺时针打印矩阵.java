/*
剑指 Offer 29. 顺时针打印矩阵
输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。

 

示例 1：

输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]
示例 2：

输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 

限制：

0 <= matrix.length <= 100
0 <= matrix[i].length <= 100
注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/
*/

//Java
//Author:Joey
//Date：2020/08/02

/*
解题思路: 层级遍历
*/

//时间复杂度: O(mn), 空间复杂度：O(1)

class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return new int[0]; 
        int row = matrix.length;
        int col = matrix[0].length;

        int[] res = new int[row*col]; 
        int index = 0;

        int row_up = 0, row_bottom = row -1, col_left = 0, col_right = col -1;

        while (row_up <= row_bottom && col_left <= col_right) {
            for (int j = col_left; j <= col_right; j++) {
                res[index++] = matrix[row_up][j];                
            }
            row_up++;
            for (int i = row_up; i <= row_bottom; i++) {
                res[index++] = matrix[i][col_right];
            }
            col_right--;

            if (row_up <= row_bottom && col_left <= col_right) {
                for (int j = col_right; j >= col_left; j--) {
                    res[index++] = matrix[row_bottom][j];
                }
                row_bottom--;
                for (int i = row_bottom; i >= row_up; i--) {
                    res[index++] = matrix[i][col_left];
                }
                col_left++;
            }         
        }
        
        return res;
    }
}