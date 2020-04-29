# -*- coding:utf-8 -*-
class Solution:
    # 这里要特别注意~找到任意重复的一个值并赋值到duplication[0]
    # 函数返回True/False
    def duplicate(self, numbers, duplication):
        # write code here
        count = [0] * len(numbers)
        for item in numbers:
            count[item] += 1
            if(count[item] == 2):
                duplication[0] = item
                return True
        return False
          