/**
20.有效的括号
给定一个只包括 '('，')'，'{'，'}'，'['，']'?的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

示例 1:

输入: "()"
输出: true
示例?2:

输入: "()[]{}"
输出: true
示例?3:

输入: "(]"
输出: false
示例?4:

输入: "([)]"
输出: false
示例?5:

输入: "{[]}"
输出: true

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
**/

//Java
//-*- coding:utf-8 -*-
//JoeyChen
//2020/04/10

/**
解题思路：
	利用栈的性质“先进后出”将左括号依次入栈，若为右括号，判断栈顶是否为匹配的左括号，若都依次匹配，则返回true，不然false
**/

/**
执行结果：
执行用时 :2 ms, 在所有 Java 提交中击败了89.13%的用户
内存消耗 :37.8 MB, 在所有 Java 提交中击败了5.08%的用户
**/

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0;i < s.length(); i++) {
            char elemt = s.charAt(i);
            if (elemt == '(' || elemt == '[' || elemt == '{') {
                stack.push(elemt);
            } 
            //
            else {
                if (stack.isEmpty()) return false;
                else {
                    char topelemt = stack.pop(); //离右括号最近的左括号 判断是否匹配
                    if (elemt == ')' && topelemt != '(') return false;
                    else if (elemt == ']' && topelemt != '[') return false;
                    else if (elemt == '}' && topelemt != '{') return false; 
                }
            }

        }
        return stack.isEmpty();  //若括号全都匹配，最后应为空栈

    }
}