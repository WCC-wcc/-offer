# -*- coding:utf-8 -*-
class Solution1:
    def multiply(self, A):
        # write code here
        sum1 = 1
        B1 = []
        for i in range(len(A)): 						#从左到右计算b[0] * ... * b[i-1]
            B1.append(sum1)
            sum1 *= A[i]
        sum2 = 1
        B2 = []
        for i in range(len(A) - 1,-1,-1):				#从右到左计算b[n-1] * ... * b[i + 1]
            B2.append(sum2)
            sum2 *= A[i]
        B = []											#合起来就是B
        for i in range(len(A)):
            B.append(B1[i] * B2[len(A) - i - 1])
        return B

A = [1,2,3,4]
Solution1 = Solution1()
print(Solution1.multiply(A))



# -*- coding:utf-8 -*-
class Solution2: 								#只用一个数组就可以了
    def multiply(self, A):
        # write code here
        sum = 1
        B = []
        for i in range(len(A)):
        	B.append(sum)
        	sum *= A[i]
        temp = 1
        # print(B)
        for j in range(len(A) - 1,-1,-1):
        	B[j] *= temp
        	temp *= A[j]
        return B

A = [1,2,3,4]
Solution2 = Solution2()
print(Solution2.multiply(A))