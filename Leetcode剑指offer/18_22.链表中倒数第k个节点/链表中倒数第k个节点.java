/*
剑指 Offer 22. 链表中倒数第k个节点
输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。

 

示例：

给定一个链表: 1->2->3->4->5, 和 k = 2.

返回链表 4->5.
*/

//Java
//Author:Joey
//Date：2020/08/01

/*
解题思路: 先求出链表长度
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
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) return head;
        ListNode cur = head;
        int n = 0;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        if (n < k) return null;
        ListNode temp = head;
        int pre = n - k + 1;
        while (pre > 1 && temp.next != null) {
            temp = temp.next;
            pre--;
        }
        return temp;
    }
}

//解法二：利用快慢指针

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
    public ListNode getKthFromEnd(ListNode head, int k) {
        //快慢指针
        if (head == null) return head;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && k > 1) {
            fast = fast.next;
            k--;
        }
        if (k > 1) return null;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
