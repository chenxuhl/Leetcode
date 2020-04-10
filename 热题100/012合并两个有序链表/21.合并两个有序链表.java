/**
21.合并两个有序链表
将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。?

示例：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
**/

//Java
//-*- coding:utf-8 -*-
//JoeyChen
//2020/04/10

//方法一：迭代
/**
解题思路：先用head记录头结点，利用和head相同的pre进行迭代，最后返回头结点即可。
**/

/**
执行结果：
执行用时 :1 ms, 在所有 Java 提交中击败了74.31%的用户
内存消耗 :39.3 MB, 在所有 Java 提交中击败了62.29%的用户
**/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        ListNode pre = head;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }

        pre.next = l1 == null? l2 : l1;  //某一链表为空情况
        return head.next; //返回头结点记录的位置即为结果

    }
}

//方法二：递归 

/**
解题思路:考虑好递归出口即可
**/

/**
执行结果：
执行用时 :1 ms, 在所有 Java 提交中击败了74.31%的用户
内存消耗 :39.7 MB, 在所有 Java 提交中击败了44.10%的用户
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        //递归出口
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }
}