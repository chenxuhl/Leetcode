/**
23.合并K个排序链表
合并?k?个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

示例:

输入:
[
? 1->4->5,
? 1->3->4,
? 2->6
]
输出: 1->1->2->3->4->4->5->6

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
**/

//Java
//-*- coding:utf-8 -*-
//JoeyChen
//2020/04/11

//方法一：把数据读取到ArrayList，再转到数组中，排序后重新构建链表

/**
执行结果：
执行用时 :4 ms, 在所有 Java 提交中击败了69.28%的用户
内存消耗 :41.2 MB, 在所有 Java 提交中击败了73.84%的用户
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

//方法二：拆分，利用到两个有序链表合并

/**
执行结果：
执行用时 :267 ms, 在所有 Java 提交中击败了15.13%的用户
内存消耗 :42.1 MB, 在所有 Java 提交中击败了56.14%的用户
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
            for (int i =2; i < lists.length; i++) {
                res = mergeTwoLists(res, lists[i]);
            }
        }
        return res;


    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //递归出口
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

//方法三：优先队列，相比于方法一，少了排序步骤

/**
执行结果；
执行用时 :7 ms, 在所有 Java 提交中击败了49.66%的用户
内存消耗 :41.4 MB, 在所有 Java 提交中击败了72.37%的用户
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
       if(lists == null || lists.length < 0){
           return null;
       }
        PriorityQueue<Integer> queue = new PriorityQueue();
        for(ListNode node:lists){
            while(node != null){
                queue.add(node.val);
                node = node.next;
            }
        }
        ListNode res = new ListNode(0);
        ListNode tmp= res;
        while(!queue.isEmpty()){
            ListNode temp = new ListNode(queue.poll());
            tmp.next = temp;
            tmp = tmp.next;
        }
        return res.next;
    }
}