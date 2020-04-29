# -*- coding:utf-8 -*-
class Solution:
    def Add(self, num1, num2):
        # write code here
        tsum = num1 ^ num2
        carry = (num1 & num2) << 1
        while (carry != 0):
            num1 = tsum & 0xFFFFFFFF             #(防止出现负数)
            num2 = carry
            tsum = num1 ^ num2
            carry = (num1 & num2) << 1
        tsum &= 0xFFFFFFFF
        return tsum if (tsum >> 31) == 0 else tsum - 4294967296