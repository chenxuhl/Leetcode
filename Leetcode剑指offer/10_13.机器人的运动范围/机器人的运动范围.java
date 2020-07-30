/*
剑指 Offer 13. 机器人的运动范围
地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？


示例 1：

输入：m = 2, n = 3, k = 1
输出：3
示例 2：

输入：m = 3, n = 1, k = 0
输出：1
提示：

1 <= n,m <= 100
0 <= k <= 20
*/

//Java
//Author:Joey
//Date：2020/07/30

//解题思路: 类似于剑指offer12题，递归


//时间复杂度: O(mn), 空间复杂度：O(mn)

class Solution {
    public int movingCount(int m, int n, int k) {
        if (k < 0) return 0;

        int[][] flag = new int[m][n];  //初始值全为零 ,用来标记机器人走过的位置
        return dfs(m, n, flag, 0, 0, k);
    }
    public int dfs(int rows, int cols, int[][] flag, int i, int j, int k) {
        if (i < 0 || j < 0 || i >= rows || j >= cols || BitSum(i) + BitSum(j) > k || flag[i][j] == 1) return 0;
        flag[i][j] = 1;  //机器人走过值设置为1
        return 1 + dfs(rows, cols, flag, i + 1, j, k) + dfs(rows, cols, flag, i - 1, j, k) +
                   dfs(rows, cols, flag, i, j + 1, k) + dfs(rows, cols, flag, i, j - 1, k);
    }
    public int BitSum(int target) {  //计算位和
        int res = 0;
        while (target > 0) {
            res = res + target % 10;
            target = target / 10;
        }
        return res;
    }
}