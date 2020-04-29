# -*- coding:utf-8 -*-
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
class Solution:                #非递归解法
    # 返回合并后列表
    def Merge(self, pHead1, pHead2):
        # write code here
        pHead = ListNode(0)             #需要两个链表变量，一个标识开头，一个实时更新链表值
        p = pHead 
        while(pHead1 != None and pHead2 != None):
            if(pHead1.val <= pHead2.val):
                p.next = pHead1
                pHead1 = pHead1.next
            else:
                p.next = pHead2
                pHead2 = pHead2.next
            p = p.next
        p.next = pHead1 or pHead2
        return pHead.next




class Solution:
    # 返回合并后列表
    def Merge(self, pHead1, pHead2):   #单变量  采用递归方式
        # write code here
        pHead = ListNode(0)
        if pHead1 == None:
            return pHead2
        elif pHead2 == None:
            return pHead1
        else:
            if (pHead1.val <= pHead2.val):
                pHead = pHead1
                pHead.next = self.Merge(pHead1.next,pHead2)
            else:
                pHead = pHead2
                pHead.next =self.Merge(pHead1,pHead2.next)
        return pHead                               