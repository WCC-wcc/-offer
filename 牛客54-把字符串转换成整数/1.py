# -*- coding:utf-8 -*-
class Solution:
    def StrToInt(self, s):
        # write code here
        if not s :
            return 0
        sign = 1
        index = 0
        if s[0] == '-':
            sign = -1
        if s[0] == '-' or s[0] == '+':
            index += 1
        Sum = 0
        while(index < len(s)):
            Sum *= 10
            if s[index] >= '0' and s[index] <= '9':
                Sum += (int)(s[index])
                index += 1
            else:
                return 0
        Sum = sign * Sum
        if (Sum >= (-(2 ** 31))) and (Sum < (2 ** 31)):
            return Sum 
        else:
            return 0
