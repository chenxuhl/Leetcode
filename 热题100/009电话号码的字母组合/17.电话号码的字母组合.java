/**
 * 17.�绰�������ĸ���
 * ����һ������������?2-9?���ַ����������������ܱ�ʾ����ĸ��ϡ�
 * <p>
 * �������ֵ���ĸ��ӳ�����£���绰������ͬ����ע�� 1 ����Ӧ�κ���ĸ��
 * <p>
 * digitToLetter['2']="abc";
 * digitToLetter['3']="def";
 * digitToLetter['4']="ghi";
 * digitToLetter['5']="jkl";
 * digitToLetter['6']="mno";
 * digitToLetter['7']="pqrs";
 * digitToLetter['8']="tuv";
 * digitToLetter['9']="wxyz";
 * <p>
 * ʾ��:
 * <p>
 * ���룺"23"
 * �����["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * <p>
 * ����˼·��
 * ѭ��ÿ�����ֶ�Ӧ����ĸ������ÿ�������е���ĸ��Ϊһ�㣬��ĸ����ʾ�������������絥�����֡�2�������ֿ��ܡ�������������������ܽ��Ϊÿ��������ĳ˻�
 **/

//Java 
//- * - coding��utf-8 - * -
//Author:JoeyChen
//Data:2020/04/09

//����һ��ѭ��+����

/**
 ����˼·��
 ѭ��ÿ�����ֶ�Ӧ����ĸ������ÿ�������е���ĸ��Ϊһ�㣬��ĸ����ʾ�������������絥�����֡�2�������ֿ��ܡ�������������������ܽ��Ϊÿ��������ĳ˻�
 **/

/**
 ִ�н����
 ִ����ʱ :1 ms, ������ Java �ύ�л�����92.71%���û�
 �ڴ����� :39.8 MB, ������ Java �ύ�л�����5.18%���û�
 **/

class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return Collections.EMPTY_LIST;  //Ϊ�����

        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        char[] chars = digits.toCharArray();
        List<String> res = new ArrayList<>();  //��Ž��
        res.add("");

        for (char c : chars) {
            List<String> tmpList = new ArrayList<>();
            String mapval = map.get(c);
            for (String str : res) {
                for (Character tmpC : mapval.toCharArray()) {
                    String tmpstr = str + tmpC;  //��ĸ����
                    tmpList.add(tmpstr);
                }
            }
            res = tmpList;  //���½��
        }
        return res;


    }
}
