/*
合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

示例:

输入:
[
  1->4->5,
  1->3->4,
  2->6
]
输出: 1->1->2->3->4->4->5->6
*/

//Java
//Author:Joey
//Date：2020/07/21

//解法一：先整明白两个有序链表合并，建一空链表ans，每次链表集合中调一个链表与ans合并

//Java
//Author:Joey
//Date：2020/07/21

/*
执行结果：
执行用时：121 ms, 在所有 Java 提交中击败了22.52%的用户
内存消耗：42 MB, 在所有 Java 提交中击败了47.06%的用户
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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = null;
        if (lists.length == 0) return ans;
        if (lists.length == 1) return lists[0];
        for (int i = 0; i < lists.length; i++) {
            ans = mergeTwoLists(ans, lists[i]);
        }
        return ans;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) return list1 == null ? list2 : list1;
        
        ListNode temp = new ListNode();
        ListNode res = temp;
        while (list1 != null && list2 != null) { 
            if (list1.val <= list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;            
        }
        temp.next = list1 == null ? list2 : list1;
        return res.next;
    }
}

//解法二：改进解法一，分而治之，每次在链表集合中两两合并 ，，递归

/*
执行结果：
执行用时：2 ms, 在所有 Java 提交中击败了94.83%的用户
内存消耗：42 MB, 在所有 Java 提交中击败了45.59%的用户
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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        return mergeList(lists, 0, lists.length-1);
    }
    public ListNode mergeList(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];
        if (left > right) return null;  //递归出口
        int mid = (right + left) / 2;
        return mergeTwoLists(mergeList(lists, left, mid), mergeList(lists, mid+1, right));
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) return null;
        if (list1 == null || list2 == null) return list1 == null ? list2 : list1;
        
        ListNode temp = new ListNode();
        ListNode res = temp;
        while (list1 != null && list2 != null) { 
            if (list1.val <= list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;            
        }
        temp.next = list1 == null ? list2 : list1;
        return res.next;
    }
}