#reference:https://zhuanlan.zhihu.com/p/60938062
#归并排序：
"""
https://zh.wikipedia.org/wiki/%E5%BD%92%E5%B9%B6%E6%8E%92%E5%BA%8F#Python
python实现，链表与数组不同点在于，数组中间点直接整除即可，而链表中间点需要用到快慢指针
"""
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
class Solution:
    def sortList(self, head):
        if not head or not head.next:
            return head
        middle = self.find_middle(head)
        left = self.sortList(head)
        right = self.sortList(middle)
        return self.merge(left, right)
#找中间节点，采用快慢指针，慢指针走一步，快指针走两步，
#当快指针走到链表尾部，慢指针就指向中间节点，快慢指针的做法只需要扫描一遍链表即可。
    def find_middle(self, head):
        slow = fast = head
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
        mid = slow.next
        slow.next = None
        return mid

    def merge(self, left, right):
        tempNode = ListNode(0)
        res = tempNode
        while left and right:
            if left.val <= right.val:
                res.next = left
                left = left.next
            else:
                res.next = right
                right = right.next
            res = res.next
        while left:
            res.next = left
            left = left.next
            res = res.next
        while right:
            res.next = right
            right = right.next
            res = res.next
        return tempNode.next
