# -*- coding:utf-8 -*-
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None
class Solution:
    def FindFirstCommonNode(self, pHead1, pHead2):
        # write code here
        shortNode = pHead1
        longNode = pHead2
        while(shortNode != longNode):
            if shortNode != None:
                shortNode = shortNode.next
            else:
                shortNode = pHead2

            if longNode != None:
                longNode = longNode.next
            else:
                longNode = pHead1
        return shortNode

# -*- coding:utf-8 -*-
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
class Solution:
    def FindFirstCommonNode(self, pHead1, pHead2):
        # write code here
        nodeTemp1 = []
        nodeTemp2 = []
        while(pHead1 != None):
            nodeTemp1.append(pHead1)
            pHead1 = pHead1.next
        while(pHead2 != None):
            nodeTemp2.append(pHead2)
            pHead2 = pHead2.next
        for item1 in nodeTemp1:
            for item2 in nodeTemp2:
                if item1 == item2:
                    return item1