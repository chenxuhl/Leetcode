/**
5.最长回文子串
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设?s 的最大长度为 1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：

输入: "cbbd"
输出: "bb"

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-palindromic-substring
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
**/
/**
解题思路：
中心扩散法，，分奇偶
**/
//Java 
//- * - coding：utf-8 - * -
//Author:JoeyChen
//Data:2020/04/05
/**
执行结果：
执行用时 :38 ms, 在所有 Java 提交中击败了63.91%的用户
内存消耗 :38.1 MB, 在所有 Java 提交中击败了21.53%的用户
**/

class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 0) return s;
        int res = 1;
        int ll = 0;
        int rr = 0;

        for (int i = 0; i < s.length(); i++) {
			//奇数情况
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
			//偶数情况
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

//改进版 ：提高代码复用
/**
执行结果：
执行用时 :32 ms, 在所有 Java 提交中击败了74.39%的用户
内存消耗 :38.1 MB, 在所有 Java 提交中击败了22.13%的用户
**/
