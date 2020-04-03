/**
3.无重复字符的最长子串
给定一个字符串，请你找出其中不含有重复字符的?最长子串?的长度。

示例?1:

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
解释: 因为无重复字符的最长子串是?"wke"，所以其长度为 3。
?    请注意，你的答案必须是 子串 的长度，"pwke"?是一个子序列，不是子串。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
**/
/**
利用集合
**/
//Java 
//- * - coding：utf-8 - * -
//Author:JoeyChen
//Data:2020/04/03
/**
执行结果：
执行用时 :9 ms, 在所有 Java 提交中击败了69.18%的用户
内存消耗 :39.9 MB, 在所有 Java 提交中击败了5.58%的用户
**/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int start = 0;
        int end = 0;
        int res = 0;
        Set<Character> set = new HashSet();

        while(start < length && end < length) {
            if(set.contains(s.charAt(end))) {
                set.remove(s.charAt(start++));
            } else {
                set.add(s.charAt(end++));
                res = Math.max(res, end-start);
            }
        }
        return res;
    }

}