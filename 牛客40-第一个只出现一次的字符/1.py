# -*- coding:utf-8 -*-
class Solution:
    def FirstNotRepeatingChar(self, s):
        # write code here
        if len(s) < 0:
            return -1
        for i in range(len(s)):
            if s.count(s[i]) == 1:
                return i
        return -1

# -*- coding:utf-8 -*-
class Solution:
    def FirstNotRepeatingChar(self, s):
        # write code here
        res = {}
        for item in s:
            if item not in res:
                res.update({item:1})
            else:
                res[item] += 1

        for i in range(len(s)):
            if res[s[i]] == 1:
                return i

        return -1
