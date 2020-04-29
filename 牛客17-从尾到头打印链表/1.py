# -*- coding:utf-8 -*-
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution1:                                       #调用列表插入元素方法  list.insert(index,element)
    # 返回从尾部到头部的列表值序列，例如[1,2,3]
    def printListFromTailToHead(self, listNode):
        # write code here
        list = []
        while(listNode != None):
            list.insert(0,listNode.val)
            listNode = listNode.next
        return list

class Solution2:
    # 返回从尾部到头部的列表值序列，例如[1,2,3]
    def printListFromTailToHead(self, listNode):
        # write code here
        list = []
        while(listNode != None):
            list.append(listNode.val)
            listNode = listNode.next
        list.reverse()                               #调用列表翻转方法
        return list


class Solution3:                                        #递归解决问题
    # 返回从尾部到头部的列表值序列，例如[1,2,3]
    def recursive(self,list,listNode):
        if(listNode.next != None):
            self.recursive(list,listNode.next)
            list.append(listNode.val)
        else:
            list.append(listNode.val)
    def printListFromTailToHead(self, listNode):
        # write code here
        resultList = []
        if listNode == None:
            return resultList
        self.recursive(resultList,listNode);
        return resultList

