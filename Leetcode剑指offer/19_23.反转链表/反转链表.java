/*
剑指 Offer 24. 反转链表
定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。

 

示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
 

限制：

0 <= 节点个数 <= 5000

 

注意：本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/
*/

//Java
//Author:Joey
//Date：2020/08/01

/*
解题思路: 遍历
*/


//时间复杂度: O(n), 空间复杂度：O(1)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode Temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = Temp;            
        }
        return pre;
    }
}

//递归

//时间复杂度: O(n), 空间复杂度：O(1)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        return helper(cur, pre);
    }
    public ListNode helper(ListNode cur, ListNode pre) {
        //递归出口
        if (cur == null) return pre;
        ListNode Temp = cur.next;
        cur.next = pre;
        return helper(Temp, cur);     
    }
}