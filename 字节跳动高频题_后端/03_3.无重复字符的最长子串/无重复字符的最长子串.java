/*
3. ���ظ��ַ�����Ӵ�
����һ���ַ����������ҳ����в������ظ��ַ��� ��Ӵ� �ĳ��ȡ�

ʾ�� 1:

����: "abcabcbb"
���: 3 
����: ��Ϊ���ظ��ַ�����Ӵ��� "abc"�������䳤��Ϊ 3��
ʾ�� 2:

����: "bbbbb"
���: 1
����: ��Ϊ���ظ��ַ�����Ӵ��� "b"�������䳤��Ϊ 1��
ʾ�� 3:

����: "pwwkew"
���: 3
����: ��Ϊ���ظ��ַ�����Ӵ��� "wke"�������䳤��Ϊ 3��
     ��ע�⣬��Ĵ𰸱����� �Ӵ� �ĳ��ȣ�"pwke" ��һ�������У������Ӵ���
*/

/*
����˼·�����û���ԭ����������ָ�룬�ֱ�ָ�򻬴��������ˣ�Լ���Ӵ����ȺͰ����ַ�
�ο���https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/wu-zhong-fu-zi-fu-de-zui-chang-zi-chuan-by-leetc-2/
*/

//Java
//Author:Joey
//Date��2020/07/05

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> occ = new HashSet<Character>();  //��ϣ���ϣ��ж��Ƿ����ظ��ַ�
        int n = s.length();
        int rk = -1, ans = 0;  //rk---��ָ�룬��ʼֵ-1������߽���࣬��û��ʼ�ƶ�
        for (int i = 0; i < n; ++i) {
            if (i != 0) {  //��ָ������һ��occ����Ƴ�һ���ַ�
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {  //����������ָ�룬���ж�occ���Ƿ�����Ҳ����ַ�
                occ.add(s.charAt(rk + 1));  //��occ�м����ַ�
                ++rk;
            }
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;

    }
}