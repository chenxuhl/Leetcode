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

//方法一
/**
解题思路：
先把数据读取到ArrayList，再转到数组中，排序后重新构建链表
**/

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