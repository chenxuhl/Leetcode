/*
剑指 Offer 38. 字符串的排列
输入一个字符串，打印出该字符串中字符的所有排列。

 

你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。

 

示例:

输入：s = "abc"
输出：["abc","acb","bac","bca","cab","cba"]
 

限制：

1 <= s 的长度 <= 8
*/

//Java
//Author:Joey
//Date：2020/08/16

//解题思路：回溯

//时间复杂度：O(n!), 空间复杂度：O(n^2)

class Solution {


    List<String> res = new LinkedList();
    char[] c;

    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);   
    }

    void dfs(int x) {
        if (x == c.length -1) {
            res.add(String.valueOf(c));
        }
        HashSet<Character> set = new HashSet();  //剪枝

        for (int i = x; i < c.length; i++) {
            if (set.contains(c[i])) continue;
            set.add(c[i]);
            swap(i, x);
            dfs(x + 1);
            swap(i, x);
        }
    }
    void swap (int a, int b) {
        char temp = c[a];
        c[a] = c[b];
        c[b] = temp;
    }
}