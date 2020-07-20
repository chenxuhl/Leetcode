/*
20. 有效的括号
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

示例 1:

输入: "()"
输出: true
示例 2:

输入: "()[]{}"
输出: true
示例 3:

输入: "(]"
输出: false
示例 4:

输入: "([)]"
输出: false
示例 5:

输入: "{[]}"
输出: true
*/

/*
解题过程：使用栈
1)"s":双引号表示字符串(String)，'s'：单引号表示字符(char)
2)字符可以直接使用"=="比较，字符串使用.equals("s")
3)Stack会将入栈的char转为Character对象
*/


//Java
//Author:Joey
//Date：2020/07/20

/*
执行结果：
执行用时：1 ms, 在所有 Java 提交中击败了98.60%的用户
内存消耗：37.9 MB, 在所有 Java 提交中击败了5.48%的用户
*/

class Solution {
    public boolean isValid(String s) {  //栈
        Stack temp = new Stack();
        int n = s.length();
        if (n == 0) return true;
        if (n < 2) return false;
        for (int i = 0; i < n; i++) {
            char v = s.charAt(i);  //取字符
            if (v == '(' || v == '[' || v == '{') {
                temp.push(v);
                continue;
            }
            if (!temp.empty()) {  //针对只输入左括号情况
                if (v == ')' && (Character)temp.pop() != '(') {  //Stack会将入栈的char转为Character对象
                    return false;
                }
                else if (v == ']' && (Character)temp.pop() != '[') {
                    return false;
                }
                else if (v == '}' && (Character)temp.pop() != '{') {
                    return false;
                }
                else continue;
            }
            temp.push(v);  //针对输入："()]"等情况         
        }
        return temp.empty() ? true : false;

    }
}

//官方：https://leetcode-cn.com/problems/valid-parentheses/solution/you-xiao-de-gua-hao-by-leetcode/

/*
执行结果：
执行用时：2 ms, 在所有 Java 提交中击败了80.18%的用户
内存消耗：37.9 MB, 在所有 Java 提交中击败了5.48%的用户
*/

class Solution {

  // Hash table that takes care of the mappings.
  private HashMap<Character, Character> mappings;

  // Initialize hash map with mappings. This simply makes the code easier to read.
  public Solution() {
    this.mappings = new HashMap<Character, Character>();
    this.mappings.put(')', '(');
    this.mappings.put('}', '{');
    this.mappings.put(']', '[');
  }

  public boolean isValid(String s) {

    // Initialize a stack to be used in the algorithm.
    Stack<Character> stack = new Stack<Character>();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);

      // If the current character is a closing bracket.
      if (this.mappings.containsKey(c)) {

        // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
        char topElement = stack.empty() ? '#' : stack.pop();

        // If the mapping for this bracket doesn't match the stack's top element, return false.
        if (topElement != this.mappings.get(c)) {
          return false;
        }
      } else {
        // If it was an opening bracket, push to the stack.
        stack.push(c);
      }
    }

    // If the stack still contains elements, then it is an invalid expression.
    return stack.isEmpty();
  }
}
