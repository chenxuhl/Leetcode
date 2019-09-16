#61.旋转链表
"""
题目描述:

给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。

"""
#示例1：
"""
输入: 1->2->3->4->5->NULL, k = 2
输出: 4->5->1->2->3->NULL
解释:
向右旋转 1 步: 5->1->2->3->4->NULL
向右旋转 2 步: 4->5->1->2->3->NULL

"""
#示例2：
"""
输入: 0->1->2->NULL, k = 4
输出: 2->0->1->NULL
解释:
向右旋转 1 步: 2->0->1->NULL
向右旋转 2 步: 1->2->0->NULL
向右旋转 3 步: 0->1->2->NULL
向右旋转 4 步: 2->0->1->NULL

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/rotate-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
#解题思路：
"""
首先遍历链表，求出链表长度n；其次，将链表首尾相连；
然后，找到循环链表断点，即为m = (n - k)%n;
链表断点下一个指向为新链表链首；最后断开循环链表即可 
"""
#python3
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def rotateRight(self, head: ListNode, k: int) -> ListNode:
        if (head):  # 链表不为空
            num = 1   #链表长度初始值
            cur = head
            while cur.next:  #循环终止条件cur.next=None
                num += 1
                cur = cur.next
            cur.next = head  # 将链表首尾相连
            m = (num - k) % num  # m为循环链表的断点
            for i in range(m):
                cur = cur.next #将cur移动到断点
            newhead = cur.next  # 此时的cur.next即为新链表的链首
            cur.next = None  # 断开循环链表
            return newhead
        else:
            return None

