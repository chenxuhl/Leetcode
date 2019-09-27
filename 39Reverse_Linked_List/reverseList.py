#206.反转链表
"""
题目描述：

反转一个链表
如：
输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL

1）迭代法
2）递归法
"""
#解题思路
"""
1)迭代法：在原链表之前建一个空的newhead，因为首节点会改变，
然后从head开始，将之后的一个节点移动到newhead之后，重复此操作直到head成为末节点为止。

2）递归法；不断进入递归函数，直到head指向倒数第二个节点，newhead指向最后一个节点
因为是回溯，所以head的下一个节点总是在上一轮移动到末尾，但head之后的next还没有断开，
所以顺势将head移动到末尾，再把next断开，最后返回newhead即可。
参考：https://blog.csdn.net/FX677588/article/details/72357389
"""
#python --迭代法
"""
执行时间：20ms， 内存损耗：13.6MB
"""
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        newhead = None
        while head:
            t = head.next   #t 暂时保存head.next的值，因为后面会发生变化
            head.next = newhead  #第一次循环时候，将head指向None，newhead跟在head后面，这一步将链表反向
            newhead = head #newhead向后移动一位，移动到head的位置上
            head = t  #同时head也向后移动一位，始终保持在newhead的前面一位
        return newhead

#python--递归法
"""
执行时间：32ms，内存损耗：17.3MB
"""
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if (not head or not head.next): #找到终点，为反转后链表的起点，然后回溯
            return head
        newhead = self.reverseList(head.next)  # 直到最后一个节点
        head.next.next = head #回溯，head的下一个节点指向head，达到反向的效果
        head.next = None  #在回溯的过程中避免混乱，暂时将节点指向None
        return newhead
