/**
 * 49.��ĸ��λ�ʷ���
 * ����һ���ַ������飬����ĸ��λ�������һ����ĸ��λ��ָ��ĸ��ͬ�������в�ͬ���ַ�����
 * <p>
 * ʾ��:
 * <p>
 * ����: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * ���:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * ˵����
 * <p>
 * ���������ΪСд��ĸ��
 * �����Ǵ������˳��
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/group-anagrams
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 **/

//Java 
//- * - coding��utf-8 - * -
//Author:JoeyChen
//Data:2020/04/18

//����һ��ʹ��HashMap������+����

/**
 ִ�н����
 ִ����ʱ :28 ms, ������ Java �ύ�л�����20.62%���û�
 �ڴ����� :43.5 MB, ������ Java �ύ�л�����26.47%���û�
 **/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ret = new ArrayList<List<String>>();  //��Ž��
        Map<String, List<String>> map = new HashMap<>();  //��ż���ֵ
        for (String s : strs) {
            char[] c = s.toCharArray();  //�ַ���ת�����ַ�����
            Arrays.sort(c);  //�ַ���������ĸ��������
            String sorted = "";
            for (char tmp : c)
                sorted += tmp;  //����������Cת�����ַ���

            if (map.get(sorted) == null) {
                List<String> list = new ArrayList<String>();
                list.add(s);
                map.put(sorted, list);  //put key��value
            } else {
                map.get(sorted).add(s);  //HashMap�м������ַ���
            }
        }
        for (List<String> tmp : map.values()) {  //��map������value���뵽ret�У���Ϊ�������
            ret.add(tmp);
        }
        return ret;
    }
}