#148.排序链表
"""
题目描述：

在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。

"""
#示例：
"""
1.
输入: 4->2->1->3
输出: 1->2->3->4

2.
输入: -1->5->3->4->0
输出: -1->0->3->4->5
"""
#解题思路：
"""
排序方法有很多种，如：快速排序，堆排序，冒泡排序，归并排序等，由于题目中给出的时间复杂度限制，选择
使用归并排序法进行排序。
操作流程：定义一个拆分，一个合并函数，递归操作
拆分函数：将链表拆成有序的链表
合并函数：将有序的链表进行合并
1）由于题目中所给的链表元素顺序随机性很高，故只有拆分函数将链表拆分到子链表中只有两个元素
或一个元素才能保证链表必定有序，这里用到快慢指针进行二分操作
2）合并函数参考21题(合并两个有序链表)
"""

#python3
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
class Solution:
    def sortList(self, head):
        if (not head or not head.next):  #当链表中元素个数为1 or 2时，直接返回
            return head
        pre = head
        slow = head
        fast = head
        while (fast and fast.next):   #通过快慢指针，找到链表的额中间位置
            pre = slow
            slow = slow.next
            fast = fast.next.next
        pre.next = None
        return self.merge(self.sortList(head), self.sortList(slow))  #运用递归方法

    def merge(self, l1, l2):
        res = ListNode(0)
        cur = res
        while (l1 and l2):
            if l1.val > l2.val:
                cur.next = l2   #这里试过cur.next = ListNode(l2.val),执行时间竟然会翻倍
                l2 = l2.next
            else:
                cur.next = l1
                l1 = l1.next
            cur = cur.next
        if l1:
            cur.next = l1
        if l2:
            cur.next = l2
        return res.next
