# -*- coding:utf-8 -*-
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
class Solution:
    def deleteDuplication(self, pHead):         #同时跳两个位置   边界判断麻烦一点 
        # write code here
        if (pHead == None or pHead.next == None):
            return pHead
        p = ListNode(0)
        result = p
        pre = pHead
        curr = pHead.next
        while(curr != None):
            if (pre.val == curr.val):
                # print(pre.val,curr.val,'----------')
                if (curr.next == None):
                    p.next = None
                    return result.next
                pre = curr.next
                curr = pre.next
            else:
                # print(pre.val,curr.val,'**********')
                p.next = pre
                p = p.next
                pre = curr
                curr = curr.next 
        if (pHead.val == pre.val):
            return None
        else:
            p.next = pre
            return result.next




# -*- coding:utf-8 -*-
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
class Solution:
    def deleteDuplication(self, pHead):
        # write code here
        if pHead == None or pHead.next == None:
            return pHead
        temp = ListNode(0) 							#只跳一个位置，边界判断简单点
        result = temp
        while(pHead != None and pHead.next != None):
            if pHead.val == pHead.next.val:
                val = pHead.val
                pHead = pHead.next
                while(pHead != None and pHead.val == val):
                    pHead = pHead.next
            else:
                temp.next = pHead
                temp = temp.next
                pHead = pHead.next
        if pHead != None:
            temp.next = pHead
            temp = temp.next
        temp.next = None                           #记得收尾处理
        return result.next


# -*- coding:utf-8 -*-
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
class Solution:                             #采用递归  需要判断返回值  以及  定义递归体
    def deleteDuplication(self, pHead):
        # write code here
        if pHead == None or pHead.next == None:
            return pHead
        result = ListNode(0)
        if pHead.val != pHead.next.val:
            result.next = pHead
            result.next.next = self.deleteDuplication(pHead.next)
        else:
            val = pHead.val
            while(pHead != None and pHead.val == val):
                pHead = pHead.next
            result.next = self.deleteDuplication(pHead)
        return result.next

list1 = ListNode(1)
list1.next = ListNode(1)
list1.next.next = ListNode(2)
list1.next.next.next = ListNode(3)
list1.next.next.next.next = ListNode(3)
list1.next.next.next.next.next = ListNode(4)
list1.next.next.next.next.next.next = ListNode(5)
list1.next.next.next.next.next.next.next = ListNode(5)
# while(list1 != None):
#     print(list1.val)
#     list1 = list1.next

Solution = Solution()
s = Solution.deleteDuplication(list1)
while(s != None):
    print(s.val)
    s = s.next
