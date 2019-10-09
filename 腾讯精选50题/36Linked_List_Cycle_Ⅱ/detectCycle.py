#142.环形链表Ⅱ
"""
题目描述：

给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。

为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。

说明：不允许修改给定的链表。

"""
#示例1：
"""
输入：head = [3,2,0,-4], pos = 1
输出：tail connects to node index 1
解释：链表中有一个环，其尾部连接到第二个节点。

"""
#示例2：
"""
输入：head = [1,2], pos = 0
输出：tail connects to node index 0
解释：链表中有一个环，其尾部连接到第一个节点。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
#解题思路：
"""
本题是在141题基础上的提升，首先利用快fast，慢slow指针判断链表是否有环，若无返回None
若有，则将快慢指针其中一个移动到head，同时进行快慢指针每次走一步，当快慢指针再次相遇点
即为环起始点
解释如下：
fast每次走两步，slow每次一步，在首次fast==slow时，
head到环起始点距离 + 环起始点到快慢指针首次相遇点距离==环长
当把slow移到head时，相当于对fast和slow同时减去环起始点到快慢指针首次相遇点距离
故再次相遇点即为环起始点

"""
#python
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def detectCycle(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        fast = head
        slow = head
        while fast and fast.next:  #找到快慢指针首次相遇点
            fast = fast.next.next
            slow = slow.next
            if fast == slow:
                break #链表有环，则退出循环
        slow = head  #将slow移到head
        if fast and fast.next: #若有环，继续执行
            while fast != slow:#寻找再次相遇点
                fast = fast.next #fast和slow每次移动一步
                slow = slow.next
            return fast  #返回环起点
        return None
