/**
64.最小路径和
给定一个包含非负整数的 m?x?n?网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

说明：每次只能向下或者向右移动一步。

示例:

输入:
[
? [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 7
解释: 因为路径 1→3→1→1→1 的总和最小。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-path-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
**/

//Java 
//- * - coding：utf-8 - * -
//Author:JoeyChen
//Data:2020/04/23

//方法一：动态规划

/**
解题思路：类似62题不同路径，使用动态规划将结果存储到二维数组中。根据右下角方格
只能由其左侧或上测方格到达，故只需其中较小值和当前方格中值相加，即为当前路径上数字和最小
**/

/**
执行结果：
执行用时 :3 ms, 在所有 Java 提交中击败了89.37%的用户
内存消耗 :42.3 MB, 在所有 Java 提交中击败了31.82%的用户
**/

class Solution {
    public int minPathSum(int[][] grid) {
        //判断是否为空
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        if (n == 0) return 0;
        //初始化res存放结果
        int[][] res = new int[m][n];
		//初始化res
        res[0][0] = grid[0][0];
		//res第一列赋值
        for (int i = 1; i < m; i++) {
            res[i][0] = res[i-1][0] + grid[i][0];
        }
		//res第一行赋值
        for (int j = 1; j < n; j++) {
            res[0][j] = res[0][j-1] + grid[0][j];
        }
		//res整体赋值
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                res[i][j] = Math.min(res[i-1][j], res[i][j-1]) + grid[i][j];
            }
        }
        return res[m-1][n-1];  //返回结果

    }
}