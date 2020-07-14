/*
64. 最小路径和
给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

说明：每次只能向下或者向右移动一步。

示例:

输入:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 7
解释: 因为路径 1→3→1→1→1 的总和最小。
*/

//解题思路:动态规划思想，一步步向前推

//Java
//Author:Joey
//Date：2020/07/14

/*
执行结果：
执行用时：3 ms, 在所有 Java 提交中击败了89.24%的用户
内存消耗：42.4 MB, 在所有 Java 提交中击败了30.30%的用户
*/

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] res = new int[m][n];  //res存放结果

        for (int i =0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i ==0 && j == 0) res[i][j] = grid[i][j]; //res初始值
                else if (i == 0 && j != 0) {  
                    res[i][j] = res[i][j-1] + grid[i][j];
                }
                else if (i != 0 && j == 0) {
                    res[i][j] = res[i-1][j] + grid[i][j];
                }
                else {
                    res[i][j] = Math.min(res[i-1][j], res[i][j-1]) + grid[i][j];
                }
            }
        }
        return res[m-1][n-1];

    }
}