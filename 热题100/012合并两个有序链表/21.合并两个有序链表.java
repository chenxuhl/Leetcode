/**
 * 21.�ϲ�������������
 * ��������������ϲ�Ϊһ���µ������������ء���������ͨ��ƴ�Ӹ�����������������нڵ���ɵġ�?
 * <p>
 * ʾ����
 * <p>
 * ���룺1->2->4, 1->3->4
 * �����1->1->2->3->4->4
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/merge-two-sorted-lists
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * <p>
 * ����˼·������head��¼ͷ��㣬���ú�head��ͬ��pre���е�������󷵻�ͷ��㼴�ɡ�
 * <p>
 * ִ�н����
 * ִ����ʱ :1 ms, ������ Java �ύ�л�����74.31%���û�
 * �ڴ����� :39.3 MB, ������ Java �ύ�л�����62.29%���û�
 * <p>
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

//Java
//-*- coding:utf-8 -*-
//JoeyChen
//2020/04/10

//����һ������
/**
 ����˼·������head��¼ͷ��㣬���ú�head��ͬ��pre���е�������󷵻�ͷ��㼴�ɡ�
 **/

/**
 ִ�н����
 ִ����ʱ :1 ms, ������ Java �ύ�л�����74.31%���û�
 �ڴ����� :39.3 MB, ������ Java �ύ�л�����62.29%���û�
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

        pre.next = l1 == null ? l2 : l1;  //ĳһ����Ϊ�����
        return head.next; //����ͷ����¼��λ�ü�Ϊ���

    }
}

//���������ݹ� 

/**
 ����˼·:���Ǻõݹ���ڼ���
 **/

/**
 ִ�н����
 ִ����ʱ :1 ms, ������ Java �ύ�л�����74.31%���û�
 �ڴ����� :39.7 MB, ������ Java �ύ�л�����44.10%���û�
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

        //�ݹ����
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