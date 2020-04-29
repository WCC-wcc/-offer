# -*- coding:utf-8 -*-
class Solution:

    def __init__(self):
        self.count = 0
        self.matrix = []

    def move(self,threshold, rows, cols,i,j):
        if i < 0 or i >= cols or j < 0 or j >= rows:
            return 
        if self.matrix[i][j] == 1:
            return
        if sum(map(int, str(i) + str(j))) > threshold:
            self.matrix[i][j] = 1
            return 
        self.count += 1
        self.matrix[i][j] = 1
        self.move(threshold, rows, cols,i - 1,j)
        self.move(threshold, rows, cols,i + 1,j)
        self.move(threshold, rows, cols,i,j - 1)
        self.move(threshold, rows, cols,i,j + 1)

    def movingCount(self, threshold, rows, cols):
        # write code here
        if threshold < 0 or rows < 0 or cols < 0:
            return 0
        self.matrix = [[0] * rows for _ in range(cols)] #这样写，可以对单个元素进行赋值
        # self.matrix = [[0] * rows] * cols  这种写法 self.matrix[0][0] = 1 会让第一列值全部变成1
        self.move(threshold, rows, cols,0,0)
        return self.count


