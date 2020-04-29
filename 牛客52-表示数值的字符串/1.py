# "+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
# "12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是数值。
# -*- coding:utf-8 -*-
import re
class Solution:
    # s字符串
    def isNumeric(self, s):
        # write code here
        str_pattern = '^[+-]?\\d*[.]?\\d+([eE][+|-]?\\d+)?$'
        return re.match(str_pattern,s)


# -*- coding:utf-8 -*-
class Solution:
    # s字符串
    def isNumeric(self, s):
        # write code here
        if not s :
            return False
        point = False
        exp = False
        for i in range(len(s)):
            if s[i] == '+' or s[i] == '-' or s[i] == '.' or s[i] == 'e' or s[i] == 'E':
                if i + 1 == len(s):
                    return False
            if s[i] == '+' or s[i] == '-':
                if i != 0 and s[i - 1] != 'e' and s[i - 1] != 'E':
                        return False
            elif s[i] == '.':
                if point:
                    return False
                elif s[i + 1] == 'e' or s[i + 1] == 'E':
                    return False
                else:
                    point = True
                    if exp:
                        return False
            elif s[i] == 'e' or s[i] == 'E':
                if exp:
                    return False
                else:
                    exp = True
            elif s[i] < '0' or s[i] > '9':
                return False
        return True
