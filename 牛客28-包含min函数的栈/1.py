# -*- coding:utf-8 -*-
class Solution:
    def __init__(self):
        self.stack = []
        self.minStack = []
    def push(self, node):
        # write code here
        self.stack.append(node)
        if self.minStack and self.minStack[-1] <= node:
            self.minStack.append(self.minStack[-1])
        else:
            self.minStack.append(node)
    def pop(self):
        # write code here
        if self.stack:
            node = self.stack[-1]
            del(self.stack[-1])
            del(self.minStack[-1])
        return node
    def top(self):
        # write code here
        if self.stack:
            return self.stack[-1]
            
    def min(self):
        # write code here
        if self.minStack:
            return self.minStack[-1]

# a = ["PSH3","MIN","PSH4","MIN","PSH2","MIN","PSH3","MIN","POP","MIN","POP","MIN","POP","MIN","PSH0","MIN"]
# Solution = Solution()
# Solution.push(3)
# print(Solution.min())
# Solution.push(4)
# print(Solution.min())
# Solution.push(2)
# print(Solution.min())