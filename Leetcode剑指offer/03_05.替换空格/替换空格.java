/*
剑指 Offer 05. 替换空格
请实现一个函数，把字符串 s 中的每个空格替换成"%20"。

 

示例 1：

输入：s = "We are happy."
输出："We%20are%20happy."
 

限制：

0 <= s 的长度 <= 10000
*/

//Java
//Author:Joey
//Date：2020/07/23

//解题思路：使用StringBuilder


//时间复杂度: O(n), 空间复杂度：O(n)

class Solution {
    public String replaceSpace(String s) {
        StringBuilder res = new StringBuilder("");
        int n = s.length();  //字符串长度
        if (n == 0) return s;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == ' ') {
                res.append("%20");
            } 
            else {
                res.append(s.charAt(i));            
			}
        }
        return res.toString();
    }
}