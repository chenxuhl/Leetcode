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
            #����ĳ������
            while(currentNode):
                nodeList.append(currentNode)
                currentNode = currentNode.next
                
        #����node��val�������������  
        nodeList = sorted(nodeList,key = lambda x:x.val)
        
        #������õ������Ԫ�أ�һ���������ӳ��µ����������tempHead��Ϊ�˷������õ�ͷ�ڵ㣩
        tempHead = ListNode(0)
        currentNode = tempHead
        for i in range(len(nodeList)):
            currentNode.next = nodeList[i]
            currentNode = currentNode.next
            
        return tempHead.next
                
        