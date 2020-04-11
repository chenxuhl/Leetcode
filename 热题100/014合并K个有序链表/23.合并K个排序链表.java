/**
23.�ϲ�K����������
�ϲ�?k?�������������غϲ������������������������㷨�ĸ��Ӷȡ�

ʾ��:

����:
[
? 1->4->5,
? 1->3->4,
? 2->6
]
���: 1->1->2->3->4->4->5->6

��Դ�����ۣ�LeetCode��
���ӣ�https://leetcode-cn.com/problems/merge-k-sorted-lists
����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
**/

//Java
//-*- coding:utf-8 -*-
//JoeyChen
//2020/04/11

//����һ
/**
����˼·��
�Ȱ����ݶ�ȡ��ArrayList����ת�������У���������¹�������
**/

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
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=0;i<lists.length;i++) {
        	ListNode list=lists[i];
        	while(list!=null) {
        		int val=list.val;
        		arr.add(val);
        		list=list.next;
        	}
        	
        }
        int size=arr.size();
        int[] data=new int[size];
        for(int i=0;i<size;i++) {
        	data[i]=arr.get(i);
        }
        Arrays.sort(data);
        ListNode list1=new ListNode(0);
        ListNode list2=list1;
        for(int i=0;i<size;i++) {
        	int m=data[i];
        	ListNode k=new ListNode(1);
        	k.val=m;
        	list1.next=k;
        	list1=list1.next;
        }
        return list2.next;
    }
}