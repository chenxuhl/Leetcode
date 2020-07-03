/**
 * 22.��������
 * ���� n?�����������ŵĶ������������һ�������������ܹ��������п��ܵĲ�����Ч��������ϡ�
 * <p>
 * ʾ����
 * <p>
 * ���룺n = 3
 * �����[
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/generate-parentheses
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * <p>
 * ����˼·���ݹ�
 * 1��������Ҫ���������ŷ��ã�
 * 2������������Ҫ����������������
 **/

//Java
//-*- coding:utf-8 -*-
//JoeyChen
//2020/04/11

/**
 ����˼·���ݹ�
 1��������Ҫ���������ŷ��ã�
 2������������Ҫ����������������
 **/

/**
 ִ�н����
 ִ����ʱ :1 ms, ������ Java �ύ�л�����98.29%���û�
 �ڴ����� :40.3 MB, ������ Java �ύ�л�����5.12%���û�
 **/

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        if (n < 1) return res;

        dfs("", 0, 0, n, res);
        return res;
    }

    public void dfs(String str, int open, int close, int max, List<String> res) {
        if (str.length() == 2 * max) {  //�ݹ���ֹ����
            res.add(str);
            return;
        }

        if (open < max) {
            dfs(str + '(', open + 1, close, max, res);

        }
        if (close < open) {
            dfs(str + ')', open, close + 1, max, res);
        }
    }
}