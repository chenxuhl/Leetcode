/**
32.最长有效括号
给定一个只包含 '('?和 ')'?的字符串，找出最长的包含有效括号的子串的长度。

示例?1:

输入: "(()"
输出: 2
解释: 最长有效括号子串为 "()"
示例 2:

输入: ")()())"
输出: 4
解释: 最长有效括号子串为 "()()"

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-valid-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
**/

//Java
//-*- coding:utf-8 -*-
//JoeyChen
//2020/04/13

//方法一：栈

/**
解题思路：利用栈，将序号压入栈中，求序号差表示最长有效括号子串长度
参考：https://blog.csdn.net/haut_ykc/article/details/95638066
**/


/**
执行结果：
执行用时 :5 ms, 在所有 Java 提交中击败了34.94%的用户
内存消耗 :39.9 MB, 在所有 Java 提交中击败了5.55%的用户
**/

class Solution {
    public int longestValidParentheses(String s) {
        int ans=0;
        Stack st=new Stack();
        st.push(-1);
        for(int i=0;i<s.length();i++)
        {
        	if(s.charAt(i)==')' && (int)st.peek()>=0 && s.charAt((int)st.peek())=='(')
        	{
        		st.pop();
        		ans=Math.max(ans,i-(int)st.peek());  //peek只取值，不出栈
        	}
        	else
        		st.push(i);
        }
        return ans;
    }
}

//方法二：动态规划

/**
解题思路：
参考：https://leetcode-cn.com/problems/longest-valid-parentheses/solution/zui-chang-you-xiao-gua-hao-by-leetcode/
**/

/**
执行结果：
执行用时 :1 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗 :39.5 MB, 在所有 Java 提交中击败了5.55%的用户
**/

class Solution {
    public int longestValidParentheses(String s) {
        int res = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {  //主要看右括号情况
                if (s.charAt(i-1) == '(') {
                    dp[i] = (i>2? dp[i-2]:0) + 2;
                }
                else if (i - dp[i-1] > 0 && s.charAt(i - dp[i-1] -1) == '(') {
                    dp[i] = dp[i-1] + (i - dp[i-1] >=2?dp[i - dp[i-1] - 2]: 0) + 2;                       
                }
                res = Math.max(res, dp[i]);
            }
        }
        return res;

    }
}
