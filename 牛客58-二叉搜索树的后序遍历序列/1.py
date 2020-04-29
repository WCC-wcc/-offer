# -*- coding:utf-8 -*-
class Solution:
    def VerifyBST(self,sequence):
        length = len(sequence)
        if length <= 1:
            return True
        firstNode = sequence[-1]
        splitIndex = 0
        for i in range(length):
            if sequence[i] >= firstNode:
                splitIndex = i
                break
        for i in range(splitIndex,length):
            if sequence[i] < firstNode:
                return False
        return self.VerifyBST(sequence[:splitIndex]) and self.VerifyBST(sequence[splitIndex:length - 1])


    def VerifySquenceOfBST(self, sequence):
        # write code here
        if not sequence:
            return None
        else:
            return self.VerifyBST(sequence)

# -*- coding:utf-8 -*-
class Solution:
    def VerifySquenceOfBST(self, sequence):
        # write code here
        if not sequence:
            return False
        if len(sequence) == 1:
            return True
        firstNode = sequence[-1]
        splitIndex = 0
        for i in range(len(sequence)):
            if sequence[i] >= firstNode:
                splitIndex = i
                break
        for i in range(splitIndex,len(sequence) - 1):
            if sequence[i] < firstNode:
                return False
        left = True
        right = True
        if splitIndex > 0:
            left = self.VerifySquenceOfBST(sequence[:splitIndex])
        if len(sequence) - 1 - splitIndex > 0:
            right = self.VerifySquenceOfBST(sequence[splitIndex:len(sequence) - 1])
        return left and right
