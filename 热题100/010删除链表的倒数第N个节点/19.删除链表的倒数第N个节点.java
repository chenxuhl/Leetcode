/**
19.删除链表的倒数第N个节点
给定一个链表，删除链表的倒数第?n?个节点，并且返回链表的头结点。

示例：

给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.
说明：

给定的 n?保证是有效的。

进阶：

你能尝试使用一趟扫描实现吗？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
**/

//Java
//-*- coding:utf-8 -*-
//JoeyChen
//2020/04/09

//方法一：双指针

/**
解题思路:
	使用两个指针，间隔N个节点，使其同时后移，直到快指针到链表末尾，慢指针的下一位即为需要删除的节点；
**/

/**
执行结果：
执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗 :37.9 MB, 在所有 Java 提交中击败了5.15%的用户
**/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head;  //慢指针
        ListNode p2 = head;  //快指针
        for (int i = 0;i < n; i++) { //快指针后移N位
            p2 = p2.next;
        }

        if (p2 == null) {
            return head.next;
        }

        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p1.next = p1.next.next;

        return head;


    }
}