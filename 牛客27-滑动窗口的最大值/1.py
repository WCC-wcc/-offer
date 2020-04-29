# -*- coding:utf-8 -*-
class Solution:
    def maxInWindows(self, num, size):         #这个做法是拿窗口第一个元素做判断，从 0 到数组的length-size+1处停止
        # write code here
        maxInWindow = []
        if size == 0:
            return maxInWindow
        for i in range(len(num) - size + 1):
            maxInWindow.append(max(num[i:i + size]))
        return maxInWindow


# -*- coding:utf-8 -*-
class Solution:                                #这个做法是拿窗口最后一个元素做判断，从size - 1 开始，到length停止
    def maxInWindows(self, num, size):
        # write code here
        temp = []
        result = []
        for i in range(len(num)):
            print(temp)
            flag = i - size + 1
            while(temp and num[i] >= num[temp[-1]]):
                del(temp[-1])
            while(temp and temp[0] < flag):
                del(temp[0])
            temp.append(i)
            if (flag >= 0 and size > 0):
                result.append(num[temp[0]])
        return result

