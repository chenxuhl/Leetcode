/**
 * 3.���ظ��ַ�����Ӵ�
 * ����һ���ַ����������ҳ����в������ظ��ַ���?��Ӵ�?�ĳ��ȡ�
 * <p>
 * ʾ��?1:
 * <p>
 * ����: "abcabcbb"
 * ���: 3
 * ����: ��Ϊ���ظ��ַ�����Ӵ��� "abc"�������䳤��Ϊ 3��
 * ʾ�� 2:
 * <p>
 * ����: "bbbbb"
 * ���: 1
 * ����: ��Ϊ���ظ��ַ�����Ӵ��� "b"�������䳤��Ϊ 1��
 * ʾ�� 3:
 * <p>
 * ����: "pwwkew"
 * ���: 3
 * ����: ��Ϊ���ظ��ַ�����Ӵ���?"wke"�������䳤��Ϊ 3��
 * ?    ��ע�⣬��Ĵ𰸱����� �Ӵ� �ĳ��ȣ�"pwke"?��һ�������У������Ӵ���
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * <p>
 * ���ü���
 **/
/**
 ���ü���
 **/
//Java 
//- * - coding��utf-8 - * -
//Author:JoeyChen
//Data:2020/04/03

/**
 ִ�н����
 ִ����ʱ :9 ms, ������ Java �ύ�л�����69.18%���û�
 �ڴ����� :39.9 MB, ������ Java �ύ�л�����5.58%���û�
 **/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int start = 0;
        int end = 0;
        int res = 0;
        Set<Character> set = new HashSet();

        while (start < length && end < length) {
            if (set.contains(s.charAt(end))) {
                set.remove(s.charAt(start++));
            } else {
                set.add(s.charAt(end++));
                res = Math.max(res, end - start);
            }
        }
        return res;
    }

}