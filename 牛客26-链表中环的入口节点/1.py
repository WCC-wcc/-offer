# -*- coding:utf-8 -*-
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
class Solution:                                  #用集合存储节点（节点非空），保证集合里没有重复节点。
    def EntryNodeOfLoop(self, pHead):
        # write code here
        ListNodeSet = []
        while (pHead != None and pHead not in ListNodeSet):#循环条件是节点非空  且节点没有在集合中出现过  
            ListNodeSet.append(pHead)
            pHead = pHead.next
        return pHead



# -*- coding:utf-8 -*-
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
class Solution:                       #使用快慢指针   快指针每次两步  慢指针每次一步  若有环  必相遇
    def EntryNodeOfLoop(self, pHead): #快指针指向头节点，慢指针指向相遇点，则快慢指针同时移动一步，最终交于点（入口节点）。
        # write code here
        fastNode = pHead
        slowNode = pHead
        while(fastNode != None and fastNode.next != None):
            fastNode = fastNode.next.next
            slowNode = slowNode.next
            if(fastNode == slowNode):
                fastNode = pHead
                while(fastNode != slowNode):
                    fastNode = fastNode.next
                    slowNode = slowNode.next
                return fastNode
        return None
