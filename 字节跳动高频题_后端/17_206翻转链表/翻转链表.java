/*
206. 反转链表
反转一个单链表。

示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
进阶:
你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
*/

//解题思路:逐个反转 迭代

//Java
//Author:Joey
//Date：2020/07/15

/*
执行结果：
执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：39.9 MB, 在所有 Java 提交中击败了5.06%的用户
*/

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
        ListNode prev = null;

        while(head != null) {
            ListNode NextTemp = head.next;
            head.next = prev;
            prev = head;
            head = NextTemp;
        }
        return prev;

    }
}

//解题：迭代，，官方答案
/*
执行结果：
执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：39.8 MB, 在所有 Java 提交中击败了5.06%的用户
*/

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
        if (head == null || head.next == null) return head;  //递归出口
        ListNode p = reverseList(head.next);
        head.next.next = head;  //翻转相邻节点
        head.next = null;
        return p;
    }
}
