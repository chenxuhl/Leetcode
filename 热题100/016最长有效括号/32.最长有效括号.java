/**
 * 32.���Ч����
 * ����һ��ֻ���� '('?�� ')'?���ַ������ҳ���İ�����Ч���ŵ��Ӵ��ĳ��ȡ�
 * <p>
 * ʾ��?1:
 * <p>
 * ����: "(()"
 * ���: 2
 * ����: ���Ч�����Ӵ�Ϊ "()"
 * ʾ�� 2:
 * <p>
 * ����: ")()())"
 * ���: 4
 * ����: ���Ч�����Ӵ�Ϊ "()()"
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/longest-valid-parentheses
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * <p>
 * ����˼·������ջ�������ѹ��ջ�У�����Ų��ʾ���Ч�����Ӵ�����
 * �ο���https://blog.csdn.net/haut_ykc/article/details/95638066
 **/

//Java
//-*- coding:utf-8 -*-
//JoeyChen
//2020/04/13

//����һ��ջ

/**
 ����˼·������ջ�������ѹ��ջ�У�����Ų��ʾ���Ч�����Ӵ�����
 �ο���https://blog.csdn.net/haut_ykc/article/details/95638066
 **/


/**
 ִ�н����
 ִ����ʱ :5 ms, ������ Java �ύ�л�����34.94%���û�
 �ڴ����� :39.9 MB, ������ Java �ύ�л�����5.55%���û�
 **/

class Solution {
    public int longestValidParentheses(String s) {
        int ans = 0;
        Stack st = new Stack();
        st.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' && (int) st.peek() >= 0 && s.charAt((int) st.peek()) == '(') {
                st.pop();
                ans = Math.max(ans, i - (int) st.peek());  //peekֻȡֵ������ջ
            } else
                st.push(i);
        }
        return ans;
    }
}

//����������̬�滮

/**
 ����˼·��
 �ο���https://leetcode-cn.com/problems/longest-valid-parentheses/solution/zui-chang-you-xiao-gua-hao-by-leetcode/
 **/

/**
 ִ�н����
 ִ����ʱ :1 ms, ������ Java �ύ�л�����100.00%���û�
 �ڴ����� :39.5 MB, ������ Java �ύ�л�����5.55%���û�
 **/

class Solution {
    public int longestValidParentheses(String s) {
        int res = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {  //��Ҫ�����������
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i > 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                res = Math.max(res, dp[i]);
            }
        }
        return res;

    }
}
