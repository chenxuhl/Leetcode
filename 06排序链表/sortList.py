#�ο����ӣ�https://zhuanlan.zhihu.com/p/60938062
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
#�鲢����ο�ά���ٿƣ�https://zh.wikipedia.org/wiki/%E5%BD%92%E5%B9%B6%E6%8E%92%E5%BA%8F#Python
#pythonʵ�֣����������鲻ͬ�����ڣ������м��ֱ���������ɣ��������м����Ҫ�õ�����ָ��
class Solution:
    def sortList(self, head):
        if not head or not head.next:
            return head
        mid = self.__findMidNode(head)
        left = self.sortList(head)  #ʹ�õݹ����
        right = self.sortList(mid)
        return self.__merge(left, right)
#���м�ڵ㣬���ÿ���ָ�룬��ָ����һ������ָ��������������ָ���ߵ�����β������ָ���ָ���м�ڵ㣬����ָ�������ֻ��Ҫɨ��һ�������ɡ�
    def __findMidNode(self, head):
        # �ҵ��м�ڵ㣬�Ͽ�����֮����__merge�кϲ���������
        slow = fast = head
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
        p = slow.next   #��ָ��ָ���м�ڵ�
        slow.next = None
        return p

    def __merge(self, left, right):
        dummy = ListNode(0)
        res = dummy
        while left and right:
            if left.val <= right.val:
                res.next = left   #��res��һ����Ԫָ��left
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
        return dummy.next