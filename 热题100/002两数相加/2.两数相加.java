/**
2.两数相加
给出两个?非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照?逆序?的方式存储的，并且它们的每个节点只能存储?一位?数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0?开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/add-two-numbers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
**/
/**
解题思路：操作链表移位并设置进位标识
**/
//Java 
//- * - coding：utf-8 - * -
//Author:JoeyChen
//Data:2020/04/02
/**
执行结果：
执行用时 :2 ms, 在所有 Java 提交中击败了99.97%的用户
内存消耗 :39.9 MB, 在所有 Java 提交中击败了95.86%的用户
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
            int sum = (l1 != null?l1.val:0) + (l2 != null?l2.val:0) + num;
            num = sum / 10;
            int  result = sum % 10;
            currentNode.val = result;
            l1 = l1!=null?l1.next:l1;
            l2 = l2!=null?l2.next:l2;
            if(l1!=null || l2!=null || num!=0) {
                currentNode.next = new ListNode(0);
                currentNode = currentNode.next;
                
            }
        } while (l1!=null || l2!=null || num!=0);
        return proNode.next;

    }
}