/*
155. 最小栈
设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。

push(x) —— 将元素 x 推入栈中。
pop() —— 删除栈顶的元素。
top() —— 获取栈顶元素。
getMin() —— 检索栈中的最小元素。
 

示例:

输入：
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

输出：
[null,null,null,null,-3,null,0,-2]

解释：
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.getMin();   --> 返回 -2.
*/

//Java
//Author:Joey
//Date：2020/07/10

//方法一：多一个栈用来存当前栈内所有元素最小值，并且此栈只保存当前主站最小值

/*
执行结果：
执行用时：7 ms, 在所有 Java 提交中击败了78.13%的用户
内存消耗：41.9 MB, 在所有 Java 提交中击败了13.25%的用户
*/

class MinStack {

    private Stack<Integer> main_stack = new Stack<Integer>();
    private Stack<Integer> min_value_stack = new Stack<Integer>();  //存最小值栈

    /** initialize your data structure here. */
    public MinStack() {

    }
    
    public void push(int x) {
        main_stack.push(x);
        if (min_value_stack.isEmpty() || min_value_stack.peek() >= x) min_value_stack.push(x);

    }
    
    public void pop() {
        int temp = main_stack.pop();
        if (min_value_stack.peek() == temp) min_value_stack.pop();

    }
    
    public int top() {
        return main_stack.peek();

    }
    
    public int getMin() {
        return min_value_stack.peek();

    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
 
 //方法二：不同于方法一，辅栈和主站元素个数保持相同，辅栈当前位置值对应主栈当前位置值所有元素最小值
 
 /*
执行结果：
执行用时：7 ms, 在所有 Java 提交中击败了78.13%的用户
内存消耗：41.5 MB, 在所有 Java 提交中击败了14.46%的用户
*/

class MinStack {

    private Stack<Integer> main_stack = new Stack<Integer>();
    private Stack<Integer> min_value_stack = new Stack<Integer>();

    /** initialize your data structure here. */
    public MinStack() {

    }
    
    public void push(int x) {
        main_stack.push(x);
        if (min_value_stack.isEmpty()) min_value_stack.push(x);
        else if (min_value_stack.peek() >= x) min_value_stack.push(x);
        else {
            min_value_stack.push(min_value_stack.peek());  //和方法一不同，与辅栈与主栈一同压入元素
        }

    }
    
    public void pop() {
        main_stack.pop();
        min_value_stack.pop();  //一同弹出

    }
    
    public int top() {
        return main_stack.peek();

    }
    
    public int getMin() {
        return min_value_stack.peek();

    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
