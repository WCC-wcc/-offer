# -*- coding:utf-8 -*-
class Solution:                                #栈的输入输出顺序 可以用一个新的栈，按照入栈顺序依次存储元素
    def IsPopOrder(self, pushV, popV):         #每保存一个元素，要按照出栈顺序，和元素进行比较，相同就pop()
        # write code here                      #最后看新栈是否为空
        stackTemp = []
        j = 0
        for i in range(len(pushV)):
            stackTemp.append(pushV[i])
            while(stackTemp and stackTemp[-1] == popV[j]):
                del(stackTemp[-1])
                j += 1
        if (not stackTemp):
            return True
        else:
            return False

# Solution = Solution()
# print(Solution.IsPopOrder([1,2,3,4,5],[4,3,5,1,2]))