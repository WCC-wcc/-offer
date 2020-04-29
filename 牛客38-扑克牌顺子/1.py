# -*- coding:utf-8 -*-
class Solution:
    def IsContinuous(self, numbers):
        # write code here
        if len(numbers) != 5:
            return False
        temp = []
        count0 = 0
        for item in numbers:
            if item == 0:
                count0 += 1
            elif item not in temp:
                temp.append(item)
        temp.sort()
        if (count0 + len(temp) == 5) and (temp[-1] - temp[0] < 5):
            return True
        else:
            return False