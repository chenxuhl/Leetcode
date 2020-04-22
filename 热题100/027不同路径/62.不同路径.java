/**
62.不同路径
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

问总共有多少条不同的路径？

示例?1:

输入: m = 3, n = 2
输出: 3
解释:
从左上角开始，总共有 3 条路径可以到达右下角。
1. 向右 -> 向右 -> 向下
2. 向右 -> 向下 -> 向右
3. 向下 -> 向右 -> 向右
示例?2:

输入: m = 7, n = 3
输出: 28

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/unique-paths
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
**/

//Java 
//- * - coding：utf-8 - * -
//Author:JoeyChen
//Data:2020/04/22

//方法一：动态规划

/**
解题思路：根据题目观察到状态转移矩阵为：res[i][j] = res[i-1][j] + res[i][j-1]从而可以快速解题
**/

/**
执行结果：
执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗 :36.7 MB, 在所有 Java 提交中击败了6.35%的用户
**/

class Solution {
    public int uniquePaths(int m, int n) {
        //动态规划
        if (m == 0 || n == 0) return 0;
        if (m == 1 && n == 1) return 1;
		//二维数组存放结果
        int[][] res = new int[m][n];
		//对二维数组的边进行赋值
        for (int i = 0; i < m; i++) {
            res[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            res[0][j] = 1;
        }
		//依次对表中其他位置进行赋值
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                res[i][j] = res[i-1][j] + res[i][j-1];
            }
        }
        return res[m-1][n-1]; //返回后下角位置值即为相应的结果值

    }
}