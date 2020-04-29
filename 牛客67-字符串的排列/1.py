# -*- coding:utf-8 -*-
class Solution:
    def Permutation(self, ss):
        # write code here
        if not ss:
            return []
        if len(ss) == 1:
            return [ss]
        res = []
        for i in range(len(ss)):
            if i == 0 or ss[i] != ss[0]:
                for item in self.Permutation(ss[:i] + ss[i + 1:]):
                    res.append(ss[i] + item)
        return res



# -*- coding:utf-8 -*-
class Solution:
    def swap(self,s,i,j):
        temp = s[i]
        s[i] = s[j]
        s[j] = temp

    def Permutation(self, ss):
        # write code here
        if not ss:
            return []
        res = []

        charArray = list(ss)
        charArray.sort()

        charArrayTemp = charArray
        charArray = charArray[::-1]
        
        while True:
            res.append(''.join(charArrayTemp))
            if charArrayTemp == charArray:
                break
            indexI = 0
            indexJ = 0
            for i in range(len(charArrayTemp) - 1,0,-1):
                if (charArrayTemp[i] > charArrayTemp[i - 1]):
                    indexI = i - 1
                    break
            for i in range(len(charArrayTemp) - 1,indexI,-1):
                if charArrayTemp[i] > charArrayTemp[indexI]:
                    indexJ = i 
                    break
            self.swap(charArrayTemp,indexI,indexJ)
            temp1 = charArrayTemp[:indexI + 1]
            temp2 = charArrayTemp[indexI + 1:]
            charArrayTemp = temp1 + temp2[::-1]
        return res

