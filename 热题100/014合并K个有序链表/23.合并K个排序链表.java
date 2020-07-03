/**
 * 23.�ϲ�K����������
 * �ϲ�?k?�������������غϲ������������������������㷨�ĸ��Ӷȡ�
 * <p>
 * ʾ��:
 * <p>
 * ����:
 * [
 * ? 1->4->5,
 * ? 1->3->4,
 * ? 2->6
 * ]
 * ���: 1->1->2->3->4->4->5->6
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/merge-k-sorted-lists
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * <p>
 * ִ�н����
 * ִ����ʱ :4 ms, ������ Java �ύ�л�����69.28%���û�
 * �ڴ����� :41.2 MB, ������ Java �ύ�л�����73.84%���û�
 **/

//Java
//-*- coding:utf-8 -*-
//JoeyChen
//2020/04/11

//����һ�������ݶ�ȡ��ArrayList����ת�������У���������¹�������

/**
 ִ�н����
 ִ����ʱ :4 ms, ������ Java �ύ�л�����69.28%���û�
 �ڴ����� :41.2 MB, ������ Java �ύ�л�����73.84%���û�
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
    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < lists.length; i++) {
            ListNode list = lists[i];
            while (list != null) {
                int val = list.val;
                arr.add(val);
                list = list.next;
            }

        }
        int size = arr.size();
        int[] data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = arr.get(i);
        }
        Arrays.sort(data);
        ListNode list1 = new ListNode(0);
        ListNode list2 = list1;
        for (int i = 0; i < size; i++) {
            int m = data[i];
            ListNode k = new ListNode(1);
            k.val = m;
            list1.next = k;
            list1 = list1.next;
        }
        return list2.next;
    }
}

//����������֣����õ�������������ϲ�

/**
 ִ�н����
 ִ����ʱ :267 ms, ������ Java �ύ�л�����15.13%���û�
 �ڴ����� :42.1 MB, ������ Java �ύ�л�����56.14%���û�
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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = new ListNode(0);
        if (lists == null || lists.length < 1) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        if (lists.length == 2) {
            res = mergeTwoLists(lists[0], lists[1]);
        } else {
            res = mergeTwoLists(lists[0], lists[1]);
            for (int i = 2; i < lists.length; i++) {
                res = mergeTwoLists(res, lists[i]);
            }
        }
        return res;


    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //�ݹ����
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }


    }
}

//�����������ȶ��У�����ڷ���һ������������

/**
 ִ�н����
 ִ����ʱ :7 ms, ������ Java �ύ�л�����49.66%���û�
 �ڴ����� :41.4 MB, ������ Java �ύ�л�����72.37%���û�
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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length < 0) {
            return null;
        }
        PriorityQueue<Integer> queue = new PriorityQueue();
        for (ListNode node : lists) {
            while (node != null) {
                queue.add(node.val);
                node = node.next;
            }
        }
        ListNode res = new ListNode(0);
        ListNode tmp = res;
        while (!queue.isEmpty()) {
            ListNode temp = new ListNode(queue.poll());
            tmp.next = temp;
            tmp = tmp.next;
        }
        return res.next;
    }
}