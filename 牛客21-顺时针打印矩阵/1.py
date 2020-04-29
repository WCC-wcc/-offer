# -*- coding:utf-8 -*-
class Solution:
    def recursive(self,i_top,i_bottom,j_left,j_right,matrix,temp,i,j):
        # print(temp,i_top,i_bottom,j_left,j_right,i,j)
        if (len(temp) == (len(matrix) * len(matrix[0]))):
            return 
        elif (i == i_top):
            # print(temp,1)
            for j in range(j_left,j_right):
                temp.append(matrix[i][j])
            self.recursive(i_top + 1,i_bottom,j_left,j_right,matrix,temp,i,j_right)
        elif (j == j_right):
            # print(temp,2)
            for i in range(i_top,i_bottom):
                temp.append(matrix[i][j - 1])
            self.recursive(i_top,i_bottom,j_left,j_right - 1,matrix,temp,i_bottom,j)
        elif (i == i_bottom):
            for j in range(j_right - 1,j_left - 1,-1):
                temp.append(matrix[i - 1][j])
            self.recursive(i_top,i_bottom - 1,j_left,j_right,matrix,temp,i,j_left)
        elif (j == j_left):
            # print(temp,4)
            # print(temp,i_top,i_bottom,j_left,j_right,i,j)
            for i in range(i_bottom - 1,i_top - 1,-1):
                temp.append(matrix[i][j])
            self.recursive(i_top,i_bottom,j_left + 1,j_right,matrix,temp,i_top,j)

    # matrix类型为二维列表，需要返回列表
    def printMatrix(self, matrix):
        # write code here
        temp = []
        m = len(matrix)
        n = len(matrix[0])
        self.recursive(0,m,0,n,matrix,temp,0,0)
        return temp

# a = [[1],[2],[3],[4],[5]]
# Solution = Solution()
# print(Solution.printMatrix(a))


# print('**********')

# a = [[1,2],[3,4]]
# print(Solution.printMatrix(a))
