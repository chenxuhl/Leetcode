/*
剑指 Offer 50. 第一个只出现一次的字符
在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。

示例:

s = "abaccdeff"
返回 "b"

s = "" 
返回 " "
 

限制：

0 <= s 的长度 <= 50000
*/

//Java
//Author:Joey
//Date：2020/08/20

//解题思路：map 

//时间复杂度：O(n), 空间复杂度：O(n)

class Solution {
    public char firstUniqChar(String s) {  //map
        char res = ' ';
        if (s.length() == 0) return res;
        Map<Character, Boolean> map = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), !map.containsKey(s.charAt(i)));
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i))) return s.charAt(i);
        }
        return res;
    }
}

//暴力解法：set

//时间复杂度：O(n^2), 空间复杂度：O(n)
//上一种解法39ms,本解法：12ms

class Solution {
    public char firstUniqChar(String s) {
        char res = ' ';
        if (s.length() == 0) return res;
        if (s.length() == 1) return s.charAt(0);
        int n = s.length();
        Set<Character> set = new HashSet();  //HashSet存储不重复元素
        for (int i = 0; i < n-1; i++) {
            int tmp = i + 1;
            if (set.contains(s.charAt(i))) continue;
            set.add(s.charAt(i));
            while (tmp < n) {
                if (s.charAt(i) != s.charAt(tmp)) tmp++;
                else break;
            }
            if (tmp == n) return s.charAt(i);
        }
        if (!set.contains(s.charAt(n-1))) return s.charAt(n-1);
        return res;
    }
}