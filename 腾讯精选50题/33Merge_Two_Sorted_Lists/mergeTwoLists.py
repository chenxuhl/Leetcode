#21.合并两个有序链表
"""
题目描述：

将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

"""
#示例：
"""
输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
"""

#解题思路:
"""
每次比较两链表的值，小的存入新的链表中，一直到其中一个链表为空，另一个链表接到新的链表后面即可

"""
#python3
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        head = ListNode(0)
        res = head
        while(l1 and l2): #谁值小先存谁
            if l1.val >= l2.val:
                res.next = ListNode(l2.val)
                l2 = l2.next
            else:
                res.next = ListNode(l1.val)
                l1 = l1.next
            res = res.next
        if l1:  #剩下一个不为空的链表接到新链表的后面
            res.next = l1
        else:
            res.next = l2
        return head.next