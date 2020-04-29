# -- codingutf-8 --                             #本质上也是斐波那契数列
class Solution1:								#不设定数组大小，只能用append()方法添加元素，不能指定下标赋值
	def rectCover(self, number):
        # write code here
		Fibonacci = []
        Fibonacci.append(0)
		Fibonacci.append(1)
		Fibonacci.append(2)
		for i in range(3,number + 1):
			Fibonacci.append(Fibonacci[i - 1] + Fibonacci[i - 2])
		return Fibonacci[n]

# -- codingutf-8 --
class Solution2: 							   #设定数组大小以后，可以用指定下标进行赋值
	def rectCover(self, number):
        # write code here
		if (number < 3):
            return number
        Fibonacci = [0] * (number + 1)
        Fibonacci[1] = 1
        Fibonacci[2] = 2
        for i in range(3,number + 1):
            Fibonacci[i] = Fibonacci[i - 1] + Fibonacci[i - 2]
        return Fibonacci[number]



# -*- coding:utf-8 -*-
class Solution3: 							#优化内存，不使用数组，使用三个变量进行迭代
     def rectCover(self, number):
        # write code here
        if number < 3:
            return number
        else:
            first = 1
            second = 2
            i = 3
            sum = 0
            while(i <= number):
                sum = first + second
                first = second
                second = sum
                i += 1
            return sum

class Solution4:                            #优化内存，不使用数组，使用三个变量进行迭代
    def rectCover(self, number):                 #时间，内存双优化
        # write code here
        if number < 3:
            return number
        else:
            first = 1
            second = 2
            i = 3
            while(i <= number):
                second = first + second
                first = second - first
                i += 1
            return second


# -*- coding:utf-8 -*-			#最简单做法，直接进行迭代，但是执行时间太长，判定出错
class Solution5:
    def rectCover(self, n):
        # write code here
        if (n < 3):
            return n
        else :
            return Solution5.rectCover(self,n-1) + Solution5.rectCover(self,n-2)
