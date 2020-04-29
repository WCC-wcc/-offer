# -*- coding:utf-8 -*-
class Solution:                                #利用逻辑与的短路运算进行递归求和
    def Sum_Solution(self, n):
        # write code here
        res = n and n + self.Sum_Solution(n-1)
        return res

