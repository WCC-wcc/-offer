# -*- coding:utf-8 -*-
class Solution1: 									#变态跳楼梯  递归式 f(n)= f(n-1)+f(n-2)+...+f(1) 
    def jumpFloorII(self, number): 					
        # write code here
        Fibonacci_new = [1] * (number + 1)
        for i in range(2,number + 1):
            Fibonacci_new[i] = sum(Fibonacci_new[:i]) 
            #Fibonacci_new[i] = 2 * Fibonacci_new[i - 1]
        return Fibonacci_new[number]


# -*- coding:utf-8 -*-
class Solution2:								   #f(0) = 1 f(1) = 1 f(2) = 2 f(n) = 2f(n - 1)
    def jumpFloorII(self, number):
        # write code here
        return 2 ** (number - 1);

# -*- coding:utf-8 -*-
class Solution:
    def jumpFloorII(self, number):
        # write code here
        if number < 2:
            return number
        else:
            return 2 * Solution.jumpFloorII(self,number - 1)