# -*- coding:utf-8 -*-
class Solution:
    def __init__(self):
        self.stack1 = []
        self.stack2 = []
    def push(self, node):
        # write code here
        self.stack1.append(node)
    def pop(self):
        # return xx
        while(len(self.stack1) > 0):
            self.stack2.append(self.stack1.pop())
        node = self.stack2.pop()
        while(len(self.stack2) > 0):
            self.stack1.append(self.stack2.pop())
        return node



        