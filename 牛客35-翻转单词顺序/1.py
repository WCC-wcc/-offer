# -*- coding:utf-8 -*-
class Solution1:
    def ReverseSentence(self, s):
        # write code here
        temp = s.split(' ')
        res = ""
        for i in range(len(temp) - 1,-1,-1):
            if i > 0:
                res += temp[i] + ' '
            else:
                res += temp[i]
        return res


# -*- coding:utf-8 -*-
class Solution2:
    def reverseStr(self,str,begin,end):      #辅助函数，先整体翻转句子，再翻转单词，记得对最后一个单词做一遍翻转
        while (begin < end):
            temp = str[begin]
            str[begin] = str[end]
            str[end] = temp
            begin += 1
            end -= 1

    def ReverseSentence(self, s):
        # write code here
        s = list(s)                         #string是定值，不能变，先转换成列表，再用''.join()函数转换成string
        self.reverseStr(s,0,len(s) - 1)
        begin = 0
        for i in range(0,len(s) - 1):
            if (s[i] == ' '):
                end = i - 1
                self.reverseStr(s,begin,end)
                begin = i + 1
        self.reverseStr(s,begin,len(s) - 1)
        return ''.join(s)



