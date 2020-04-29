# -*- coding:utf-8 -*-
class Solution:

    def __init__(self):
        self.res = []

    def Insert(self, num):
        # write code here
        self.res.append(num)
    def GetMedian(self,s):
        # write code here
        length = len(self.res)
        self.res.sort()
        if (length % 2 == 0):
            return (self.res[length / 2 - 1] + self.res[length / 2]) / 2.0
        else:
            return (self.res[length / 2])


# -*- coding:utf-8 -*-
import heapq
class Solution:

    def __init__(self):
        self.count = 0
        self.left = []
        self.right = []

    def Insert(self, num):
        # write code here
        self.count += 1
        if self.count & 1:
            if (self.right and self.right[0] < num):
                heapq.heappush(self.right,num)
                num = heapq.heappop(self.right)
            heapq.heappush(self.left,-num)
        else:
            if (self.left and -self.left[0] > num):
                heapq.heappush(self.left,-num)
                num = -heapq.heappop(self.left)
            heapq.heappush(self.right,num)
        print(self.left,self.right)

    def GetMedian(self,num):
        # write code here
        if self.count & 1:
            return -self.left[0]
        else:
            return (-self.left[0] + self.right[0]) / 2.0

