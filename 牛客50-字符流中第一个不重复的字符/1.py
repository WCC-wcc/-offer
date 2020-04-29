# -*- coding:utf-8 -*-   #根据ASCII码，0-127  总共1228个字符，可显示字符为32-126  共95  0-31，127为控制字符 
class Solution:
    # 返回对应char
    def __init__(self):
        self.s = ''
        self.count = {}

    def FirstAppearingOnce(self):
        # write code here
        for item in self.s:
            if self.count[item] == 1:
                return item
        return '#'

    def Insert(self, char):
        # write code here
        self.s += char
        if char in self.count:
            self.count[char] += 1
        else:
            self.count.update({char:1})




# -*- coding:utf-8 -*-
class Solution:

    def __init__(self):
        self.s = []
        self.count = [0] * 95

    # 返回对应char
    def FirstAppearingOnce(self):
        # write code here
        while(self.s):
            if self.count[ord(self.s[0]) - ord(' ')] == 1:  #ord(char)得到字符对应的ASCII码
                return self.s[0]
            else:
                self.s.pop(0)
        return '#'
    def Insert(self, char):
        # write code here
        index = ord(char) - ord(' ')
        if self.count[index] == 0:
            self.s.append(char)
        self.count[index] += 1