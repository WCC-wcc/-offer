# -*- coding:utf-8 -*-
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
class Solution:
    # 返回ListNode
    def ReverseList(self, pHead):
        # write code here
        if pHead == None or pHead.next == None:
            return pHead
        pre = pHead
        curr = pHead.next
        after = pHead.next.next
        pre.next = None                                           #注意处理首节点  指向None
        while (after != None):
            curr.next = pre
            pre = curr
            curr = after
            after = after.next
        curr.next = pre
        return curr
