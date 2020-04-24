/**
72.编辑距离
给你两个单词?word1 和?word2，请你计算出将?word1?转换成?word2 所使用的最少操作数?。

你可以对一个单词进行如下三种操作：

插入一个字符
删除一个字符
替换一个字符
?

示例?1：

输入：word1 = "horse", word2 = "ros"
输出：3
解释：
horse -> rorse (将 'h' 替换为 'r')
rorse -> rose (删除 'r')
rose -> ros (删除 'e')
示例?2：

输入：word1 = "intention", word2 = "execution"
输出：5
解释：
intention -> inention (删除 't')
inention -> enention (将 'i' 替换为 'e')
enention -> exention (将 'n' 替换为 'x')
exention -> exection (将 'n' 替换为 'c')
exection -> execution (插入 'u')

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/edit-distance
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
**/

//Java 
//- * - coding：utf-8 - * -
//Author:JoeyChen
//Data:2020/04/24

//方法一：动态规划

/**
解题思路：参考https://www.youtube.com/watch?v=We3YDTzNXEk
代码：https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/EditDistance.java
**/

/**
执行结果：
执行用时 :7 ms, 在所有 Java 提交中击败了62.44%的用户
内存消耗 :40.2 MB, 在所有 Java 提交中击败了5.00%的用户
**/

class Solution {
    public int minDistance(String word1, String word2) {
		//二维数组存放结果
        int[][] res = new int[word2.length()+1][word1.length()+1];
		
		//初始化首行
        for (int i = 0; i <= word1.length(); i++) {
            res[0][i] = i;
        }
		//初始化首列
        for (int j = 0; j <= word2.length(); j++) {
            res[j][0] = j;
        }

        for (int i = 1; i <= word2.length(); i++) {
            for (int j = 1; j <= word1.length(); j++) {
				//两种赋值情况
                if (word2.charAt(i-1) == word1.charAt(j-1)) {
                    res[i][j] = res[i-1][j-1];
                } else {
                    res[i][j] = 1 + Math.min(Math.min(res[i-1][j], res[i-1][j-1]),res[i][j-1]);
                }
            }
        }
        return res[word2.length()][word1.length()];

    }
}