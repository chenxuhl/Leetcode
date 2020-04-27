/**
 * 76.最小覆盖子串
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 *
 * 示例：
 *
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 *
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

//Java
//- * - coding：utf-8 - * -
//Author:JoeyChen
//Data:2020/04/27

/**
 * 解题思路：
 * 利用两个指针left和right，right在右，left在左，right添加元素，left精简元素，直至找出满足要求子串
 */


/**
 * 执行结果：
 * 执行用时 :18 ms, 在所有 Java 提交中击败了56.71%的用户
 * 内存消耗 :40.6 MB, 在所有 Java 提交中击败了6.67%的用户
 */

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String minWindow(String s, String t) {
        if (s.length()==0 || t.length()==0) return "";  //先检验字符串

        Map<Character, Integer> dictT = new HashMap<Character, Integer>();  //键和值
        //初始化字典保存t中字母出现的次数 如：t = "AAB"则 dictT = {A:2, B:1}
        for (int i = 0; i < t.length(); i++) {
            int count = dictT.getOrDefault(t.charAt(i), 0);
            dictT.put(t.charAt(i), count+1);
        }

        //记录子串中多少个不同的字符满足要求
        int formed = 0;
        //初始化左右指针
        int left = 0, right = 0;
        //初始化结果标识
        int[] ans = {-1, left, right};

        //初始化取出子串
        Map<Character, Integer> WindowRes = new HashMap<Character, Integer>();

        while (right<s.length()) {
            char c = s.charAt(right);
            int count = WindowRes.getOrDefault(c, 0);
            WindowRes.put(c, count+1);

            if (dictT.containsKey(c) && WindowRes.get(c).intValue() == dictT.get(c).intValue()) {
                formed ++;
            }

            //左边开始向右边收缩
            while (left <= right && formed == dictT.size()) {  //一旦满足子串满足要求，就开始精简子串
                c = s.charAt(left);
                if (ans[0] == -1 || right-left < ans[0]) {  //更新ans存储的结果
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }
                WindowRes.put(c, WindowRes.get(c) - 1);  //字母个数计数减一
                if (dictT.containsKey(c) && WindowRes.get(c).intValue() < dictT.get(c).intValue()) {
                    formed --;
                }
                left++;
            }
            right++;
        }
        return ans[0] == -1 ? "":s.substring(ans[1], ans[2]+1);
    }
}