# -*- coding:utf-8 -*-
# class RandomListNode:
#     def __init__(self, x):
#         self.label = x
#         self.next = None
#         self.random = None
class Solution:
    # 返回 RandomListNode
    def Clone(self, pHead):
        # write code here
        if not pHead:
            return None
        cur = pHead

        target = RandomListNode(pHead.label)
        node = target
        
        while(cur):
            if cur.next == None :
                node.next = None 
            else : 
                node.next = RandomListNode(cur.next.label)

            if cur.random == None :
                node.random = None 
            else : 
                node.random = RandomListNode(cur.random.label)

            cur = cur.next
            node = node.next
        return target