# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def mergeKLists(self, lists):
        nodeList = []
        for i in range(len(lists)):
            currentNode = lists[i]
            #遍历某个链表
            while(currentNode):
                nodeList.append(currentNode)
                currentNode = currentNode.next
                
        #根据node的val对数组进行排序  
        nodeList = sorted(nodeList,key = lambda x:x.val)
        
        #对排序好的数组的元素，一个个地连接成新的链表（这里的tempHead是为了方便设置的头节点）
        tempHead = ListNode(0)
        currentNode = tempHead
        for i in range(len(nodeList)):
            currentNode.next = nodeList[i]
            currentNode = currentNode.next
            
        return tempHead.next
                
        