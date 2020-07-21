/*
54. 螺旋矩阵
给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。

示例 1:

输入:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
输出: [1,2,3,6,9,8,7,4,5]
示例 2:

输入:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
输出: [1,2,3,4,8,12,11,10,9,5,6,7]
*/

//解题思路：逐层遍历，上下左右，边界，依次缩减范围

//Java
//Author:Joey
//Date：2020/07/21

/*
执行结果：
执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：37.5 MB, 在所有 Java 提交中击败了5.72%的用户
*/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;

        int m = matrix.length;   //行
        int n = matrix[0].length;  //列

        //定义四个指针，分别指向行上下，列左右边界
        int row_top = 0, row_down = m -1, col_left = 0, col_right = n -1;

        while (row_top <= row_down && col_left <= col_right) {  //循环停止条件
            for (int col = col_left; col <= col_right; col++) {  //矩阵顶，从左至右
                res.add(matrix[row_top][col]);
            }
            row_top++;
            for (int row = row_top; row <= row_down; row++) {  //矩阵右，从上至下
                res.add(matrix[row][col_right]);
            }
            col_right--;
            if (col_left <= col_right && row_top <= row_down) {
                for (int col = col_right; col >= col_left; col--) {  //矩阵下，从右至左
                    res.add(matrix[row_down][col]);
                }
                row_down--;
                for (int row = row_down; row >= row_top; row--) {  //矩阵左，从下至上
                    res.add(matrix[row][col_left]);
                }
                col_left++;
            }
        }
        return res;
    }
}