# -*- coding:utf-8 -*-

class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None
    

class Solution:
    def LastRemaining_Solution(self, n, m):
        # write code here
        if n <= 0 or m < 0:
            return -1
        circle = ListNode(0)
        node = circle
        for i in range(1,n):
            node.next = ListNode(i)
            node = node.next
        node.next = circle
        count = 0
        while(node.next != node):
            if (count == (m - 1)):
                node.next = node.next.next
                count = 0
            else:
                count += 1
                node = node.next
        return  node.val



# -*- coding:utf-8 -*-
class Solution:
    def LastRemaining_Solution(self, n, m):
        # write code here
        if (n <= 0 or m < 0):
            return -1
        circle = list(range(n))
        alive = n
        index = 0
        count = 0
        while(alive > 1):
            if count == m - 1:
                circle[index] = -1
                count = 0
                index = (index + 1) % n
                while(circle[index] == -1):
                    index = (index + 1) % n
                alive -= 1
            else:
                count += 1
                index = (index + 1) % n
                while(circle[index] == -1):
                    index = (index + 1) % n
        return index


# -*- coding:utf-8 -*-
class Solution:
    def LastRemaining_Solution(self, n, m):
        # write code here
        if (n <= 0 or m < 0):
            return -1 
        res = 0
        for i in range(2,n):
            res = (res + m) % res
        return res


# -*- coding:utf-8 -*-
class Solution:
    def LastRemaining_Solution(self, n, m):
        # write code here
        if (n <= 0 or m < 0):
            return -1 
        if n == 1:
            return 0
        else :
            return (self.LastRemaining_Solution(n - 1,m) + m) % n
