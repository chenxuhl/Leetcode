/**
22.括号生成
数字 n?代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且有效的括号组合。

示例：

输入：n = 3
输出：[
       "((()))",
       "(()())",
       "(())()",
       "()(())",
       "()()()"
     ]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/generate-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
**/

//Java
//-*- coding:utf-8 -*-
//JoeyChen
//2020/04/11

/**
解题思路：递归
1）左括号要先于右括号放置；
2）左括号数量要多于右括号数量；
**/

/**
执行结果：
执行用时 :1 ms, 在所有 Java 提交中击败了98.29%的用户
内存消耗 :40.3 MB, 在所有 Java 提交中击败了5.12%的用户
**/

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        if (n <1) return res;
        
        dfs("", 0, 0, n, res);
        return res;
    }
    public void dfs(String str, int open, int close, int max, List<String> res) {
        if (str.length() == 2*max) {  //递归终止条件
            res.add(str);
            return;
        }

        if (open < max) {
            dfs(str+'(', open+1, close, max, res);  

        }
        if (close<open) {
            dfs(str+')', open, close+1, max, res);
        }
    }
}