#2.两数相加
"""
题目描述：

给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

"""
#示例：
"""
输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/add-two-numbers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
#解题思路：
"""
相加，进位表示carry，依次相加，若两链表都为空了，carry仍然非零，则仍需要向前进一位
"""
#python3

class Solution:
    def addTwoNumbers(self, l1,l2):
        head = ListNode(0)
        r = head
        carry = 0
        while(l1 or l2):
            x = l1.val if l1 else 0  #链表为空，则赋值0，否则为val
            y = l2.val if l2 else 0
            sum = carry + x + y
            carry = sum // 10
            r.next = ListNode(sum % 10)
            r = r.next
            if (l1): #链表不为空，则指向下一个位置
                l1 = l1.next
            if (l2):
                l2 = l2.next
        if carry > 0 :  #若进位不为零，则仍需向前进一位
            r.next = ListNode(carry)
        return head.next