/**
19.ɾ������ĵ�����N���ڵ�
����һ������ɾ������ĵ�����?n?���ڵ㣬���ҷ��������ͷ��㡣

ʾ����

����һ������: 1->2->3->4->5, �� n = 2.

��ɾ���˵����ڶ����ڵ�������Ϊ 1->2->3->5.
˵����

������ n?��֤����Ч�ġ�

���ף�

���ܳ���ʹ��һ��ɨ��ʵ����

��Դ�����ۣ�LeetCode��
���ӣ�https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
**/

//Java
//-*- coding:utf-8 -*-
//JoeyChen
//2020/04/09

//����һ��˫ָ��

/**
����˼·:
	ʹ������ָ�룬���N���ڵ㣬ʹ��ͬʱ���ƣ�ֱ����ָ�뵽����ĩβ����ָ�����һλ��Ϊ��Ҫɾ���Ľڵ㣻
**/

/**
ִ�н����
ִ����ʱ :0 ms, ������ Java �ύ�л�����100.00%���û�
�ڴ����� :37.9 MB, ������ Java �ύ�л�����5.15%���û�
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
        ListNode p1 = head;  //��ָ��
        ListNode p2 = head;  //��ָ��
        for (int i = 0;i < n; i++) { //��ָ�����Nλ
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