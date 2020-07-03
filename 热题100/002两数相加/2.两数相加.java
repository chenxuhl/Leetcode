/**
 * 2.�������
 * ��������?�ǿ� ������������ʾ�����Ǹ������������У����Ǹ��Ե�λ���ǰ���?����?�ķ�ʽ�洢�ģ��������ǵ�ÿ���ڵ�ֻ�ܴ洢?һλ?���֡�
 * <p>
 * ��������ǽ��������������������᷵��һ���µ���������ʾ���ǵĺ͡�
 * <p>
 * �����Լ���������� 0 ֮�⣬���������������� 0?��ͷ��
 * <p>
 * ʾ����
 * <p>
 * ���룺(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * �����7 -> 0 -> 8
 * ԭ��342 + 465 = 807
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/add-two-numbers
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * <p>
 * ����˼·������������λ�����ý�λ��ʶ
 * <p>
 * ִ�н����
 * ִ����ʱ :2 ms, ������ Java �ύ�л�����99.97%���û�
 * �ڴ����� :39.9 MB, ������ Java �ύ�л�����95.86%���û�
 **/
/**
 ����˼·������������λ�����ý�λ��ʶ
 **/
//Java 
//- * - coding��utf-8 - * -
//Author:JoeyChen
//Data:2020/04/02
/**
 ִ�н����
 ִ����ʱ :2 ms, ������ Java �ύ�л�����99.97%���û�
 �ڴ����� :39.9 MB, ������ Java �ύ�л�����95.86%���û�
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int num = 0;
        ListNode proNode = new ListNode(0);
        ListNode currentNode = new ListNode(0);
        proNode.next = currentNode;
        do {
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + num;
            num = sum / 10;
            int result = sum % 10;
            currentNode.val = result;
            l1 = l1 != null ? l1.next : l1;
            l2 = l2 != null ? l2.next : l2;
            if (l1 != null || l2 != null || num != 0) {
                currentNode.next = new ListNode(0);
                currentNode = currentNode.next;

            }
        } while (l1 != null || l2 != null || num != 0);
        return proNode.next;

    }
}