# -*- coding:utf-8 -*-
class Solution:

    def findPath(self,matrix,rows,cols,path,i,j,flag):
        if not path:
            return True
        if i < 0 or i >= rows or j < 0 or j >= cols:
            return False
        if flag[i][j] == 1:
            return False
        if matrix[i * cols + j] != path[0]:
            return False
        flag[i][j] = 1
        return self.findPath(matrix, rows, cols, path[1:],i - 1,j,flag) or \
                self.findPath(matrix, rows, cols, path[1:],i + 1,j,flag) or \
                self.findPath(matrix, rows, cols, path[1:],i,j - 1,flag) or \
                self.findPath(matrix, rows, cols, path[1:],i,j + 1,flag)

    def hasPath(self, matrix, rows, cols, path):
        # write code here
        for i in range(0,rows):
            for j in range(0,cols):
                flag = [ [0] * cols for _ in range(rows)]
                if self.findPath(matrix, rows, cols, path,i,j,flag):
                    return True
        return False


matrix = "ABCESFCSADEE"
rows = 3
cols = 4
path = "ABCCED"
Solution = Solution()
print(Solution.hasPath(matrix,rows,cols,path))