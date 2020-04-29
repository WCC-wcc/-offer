# -*- coding:utf-8 -*-
class Solution:
    def LeftRotateString(self, s, n):
        # write code here
        if n > len(s):
            return ""
        temp = list(s)
        res =  temp[n:len(s)] + temp[0:n]
        return "".join(res)


# -*- coding:utf-8 -*-
class Solution:
    def LeftRotateString(self, s, n):
        # write code here
        length = len(s)
        if  n > length:
            return ""
        s += s
        return s[n:n + length]