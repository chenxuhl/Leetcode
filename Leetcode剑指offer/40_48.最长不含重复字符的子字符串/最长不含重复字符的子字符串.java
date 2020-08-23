/*
剑指 Offer 48. 最长不含重复字符的子字符串
请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。

 

示例 1:

输入: "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 

提示：

s.length <= 40000
注意：本题与主站 3 题相同：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
*/

//Java
//Author:Joey
//Date：2020/08/20

//解题思路：暴力解法

//时间复杂度：O(n^2), 空间复杂度：O(n)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int left = 0;
        int res = 0;
        while (left < s.length()) {
            HashSet<Character> set = new HashSet();
            int tmp = left;
            while (tmp < s.length()) {
                if (set.add(s.charAt(tmp))) {
                    tmp++;
                } else break;
            }
            if (set.size() > res) res = set.size();
            left++;
        }
        return res;
    }
}


//解法二：动态规划

//时间复杂度：O(n), 空间复杂度：O(n)

class Solution {
    public int lengthOfLongestSubstring(String s) { //动态规划
        if (s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap();
        int res = 0, tmp = 0;
        for (int j = 0; j < s.length(); j++) {
            int i = map.getOrDefault(s.charAt(j), -1);
            //更新map
            map.put(s.charAt(j), j);
            tmp = tmp < j - i ? tmp+1 : j - i;
            res = Math.max(res, tmp);
        }
        return res;

    }
}