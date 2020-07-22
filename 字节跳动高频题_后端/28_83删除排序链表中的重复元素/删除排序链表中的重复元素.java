/*
83. 删除排序链表中的重复元素
给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。

示例 1:

输入: 1->1->2
输出: 1->2
示例 2:

输入: 1->1->2->3->3
输出: 1->2->3
*/

//Java
//Author:Joey
//Date：2020/07/22

//解题思路：循环遍历即可

/*
执行结果：
执行用时：1 ms, 在所有 Java 提交中击败了72.14%的用户
内存消耗：39.4 MB, 在所有 Java 提交中击败了5.97%的用户
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }            
        }
        return head;
    }
}