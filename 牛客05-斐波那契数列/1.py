# -- codingutf-8 --
class Solution1:								#不设定数组大小，只能用append()方法添加元素，不能指定下标赋值
	def Fibonacci(self, n):
        # write code here
		Fibonacci = []
		Fibonacci.append(0)
		Fibonacci.append(1)
		for i in range(2,n + 1):
			Fibonacci.append(Fibonacci[i - 1] + Fibonacci[i - 2])
		return Fibonacci[n]


Solution = Solution1()
print(Solution.Fibonacci(20))

# -- codingutf-8 --
class Solution2: 							   #设定数组大小以后，可以用指定下标进行赋值
	def Fibonacci(self, n):
        # write code here
		Fibonacci = [0] * 40
		Fibonacci[0] = 0
		Fibonacci[1] = 1
		for i in range(2,n + 1):
			Fibonacci[i] = Fibonacci[i - 1] + Fibonacci[i - 2]
		return Fibonacci[n]

Solution = Solution2()
print(Solution.Fibonacci(20))


# -*- coding:utf-8 -*-
class Solution3: 							#优化内存，不使用数组，使用三个变量进行迭代
    def Fibonacci(self, n):					#时间，内存双优化
        # write code here
        if n < 2:
            return n
        else:
            first = 0
            second = 1
            i = 2
            sum = 0
            while(i <= n):
                sum = first + second
                first = second
                second = sum
                i += 1
            return sum

class Solution4:                            #优化内存，不使用数组，使用三个变量进行迭代
    def Fibonacci(self, n):                 #时间，内存双优化
        # write code here
        if n < 2:
            return n
        else:
            first = 0
            second = 1
            i = 2
            while(i <= n):
                second = first + second
                first = second - first
                i += 1
            return second

Solution = Solution4()
print(Solution.Fibonacci(20))

# -*- coding:utf-8 -*-			#最简单做法，直接进行迭代，但是执行时间太长，判定出错
class Solution5:
    def Fibonacci(self, n):
        # write code here
        if (n < 2):
            return n
        else :
            return Solution4.Fibonacci(self,n-1) + Solution4.Fibonacci(self,n-2)

Solution = Solution4()
print(Solution.Fibonacci(20))