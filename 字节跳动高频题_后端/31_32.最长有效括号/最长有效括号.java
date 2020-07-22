/*
32. 最长有效括号
给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。

示例 1:

输入: "(()"
输出: 2
解释: 最长有效括号子串为 "()"
示例 2:

输入: ")()())"
输出: 4
解释: 最长有效括号子串为 "()()"
*/


//Java
//Author:Joey
//Date：2020/07/22

//解题思路：注意是子串，，用栈存放括号，没解出来，参考答案，用栈存放下标

/*
执行结果：
执行用时：3 ms, 在所有 Java 提交中击败了51.60%的用户
内存消耗：40.1 MB, 在所有 Java 提交中击败了9.52%的用户
*/

public class Solution {
    public int longestValidParentheses(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();  //栈，存放下标，而不是括号
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } 
            else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } 
                else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }
}
