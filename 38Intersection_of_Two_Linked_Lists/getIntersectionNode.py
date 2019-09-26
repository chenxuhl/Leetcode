# 160.相交链表
"""
题目描述：

编写一个程序，找到两个单链表相交的起始节点。
如：
    4 - 1
         \
          8 - 4 - 5
         /
5 - 0 - 1
返回：8
若无相交节点则返回NULL

"""
#解题思路：
"""
若两链表相等，则直接遍历即可找到相交节点
若不等，找到长度差a, 用较长链表减去a，两链表长度相等后直接遍历即可

"""
#python3
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
        if (not headA or not headB):
            return None
        len_A = self.getLength(headA)
        len_B = self.getLength(headB)
        if len_A > len_B:  #较长链表后移长度差
            diff = len_A - len_B
            while diff:
                headA = headA.next
                diff -= 1
        else:
            diff = len_B - len_A
            while diff:
                headB = headB.next
                diff -= 1
        while (headA and headB and headA != headB): #循环直至相交或其一为空
            headA = headA.next
            headB = headB.next
        if headA and headB:  #若为非空，则返回节点值
            return headA
        return None

    def getLength(self, l1): #求链表长度
        count = 0
        while l1:
            count += 1
            l1 = l1.next
        return count