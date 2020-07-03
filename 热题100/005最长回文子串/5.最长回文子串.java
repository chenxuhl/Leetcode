/**
 * 5.������Ӵ�
 * ����һ���ַ��� s���ҵ� s ����Ļ����Ӵ�������Լ���?s ����󳤶�Ϊ 1000��
 * <p>
 * ʾ�� 1��
 * <p>
 * ����: "babad"
 * ���: "bab"
 * ע��: "aba" Ҳ��һ����Ч�𰸡�
 * ʾ�� 2��
 * <p>
 * ����: "cbbd"
 * ���: "bb"
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/longest-palindromic-substring
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * <p>
 * ����˼·��
 * ������ɢ����������ż
 **/
/**
 ����˼·��
 ������ɢ����������ż
 **/
//Java 
//- * - coding��utf-8 - * -
//Author:JoeyChen
//Data:2020/04/05

/**
 ִ�н����
 ִ����ʱ :38 ms, ������ Java �ύ�л�����63.91%���û�
 �ڴ����� :38.1 MB, ������ Java �ύ�л�����21.53%���û�
 **/

class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 0) return s;
        int res = 1;
        int ll = 0;
        int rr = 0;

        for (int i = 0; i < s.length(); i++) {
            //�������
            int l = i - 1;
            int r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                int len = (r - l + 1);
                if (len > res) {
                    res = len;
                    ll = l;
                    rr = r;

                }
                l--;
                r++;
            }
            //ż�����
            l = i;
            r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                int len = (r - l + 1);
                if (len > res) {
                    res = len;
                    ll = l;
                    rr = r;

                }
                l--;
                r++;
            }
        }
        return s.substring(ll, rr + 1);

    }
}

//�Ľ��� ����ߴ��븴��

/**
 ִ�н����
 ִ����ʱ :32 ms, ������ Java �ύ�л�����74.39%���û�
 �ڴ����� :38.1 MB, ������ Java �ύ�л�����22.13%���û�
 **/

class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
        int len = 0;
        for (int i = 0; i < s.length(); ++i) {
            int cur = Math.max(getLen(s, i, i), getLen(s, i, i + 1));
            if (cur > len) {
                len = cur;
                start = i - (len - 1) / 2; //i��ʾ�����Ӵ����ĵ㣬len-1:��Ӧ����Ϊż�����
            }
        }
        return s.substring(start, start + len);
    }

    private int getLen(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            --l;
            ++r;
        }
        return r - l - 1;
    }
}