/*
剑指 Offer 06. 从尾到头打印链表
输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

 

示例 1：

输入：head = [1,3,2]
输出：[2,3,1]
 

限制：

0 <= 链表长度 <= 10000
*/

//Java
//Author:Joey
//Date：2020/07/27

//解题思路:先将链表值顺序存入数组，然后将数值值倒置


//时间复杂度: O(n), 空间复杂度：O(n)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] reversePrint(ListNode head) {
        int n = 0;
        ListNode temp = head;
        while (temp != null) {  //链表长度
            n++;
            temp = temp.next;
        }
        if (n == 0) return new int[0];
        int[] res = new int[n];
        ListNode cur = head;
        int i = 0;
        while (cur != null) {  //val顺序存入数组
            res[i] = cur.val;
            i++;
            cur = cur.next;
        }
        //左右指针
        int left = 0, right = n -1;
        while (left < right) {  //倒置数组
            swap(res, left, right);
            left++;
            right--;
        }
        return res;        
    }
    public void swap (int[] res, int a, int b) {  //元素互换
        int temp = res[a];
        res[a] = res[b];
        res[b] = temp;
    }
}

//解法二：可以用栈

//时间复杂度: O(n), 空间复杂度：O(n)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        int[] print = new int[size];
        for (int i = 0; i < size; i++) {
            print[i] = stack.pop().val;
        }
        return print;
    }
}

