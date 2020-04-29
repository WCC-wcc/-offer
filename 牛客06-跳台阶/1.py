# -*- coding:utf-8 -*-
class Solution1:								#同斐波那契数列
    def jumpFloor(self, number):
        # write code here
        if (number < 4):
            return number
        else:
            jumpFloor1 = 1
            jumpFloor2 = 2
            i = 2
            while (i < number):
                jumpNextFloor = jumpFloor1 + jumpFloor2
                jumpFloor1 = jumpFloor2
                jumpFloor2 = jumpNextFloor
                i += 1
            return jumpNextFloor


# -*- coding:utf-8 -*-
class Solution2:
    def jumpFloor(self, number):
        # write code here
        if (number < 4):
            return number
        else:
            jumpFloor1 = 1
            jumpFloor2 = 2
            i = 2
            while (i < number):
                jumpFloor2 = jumpFloor1 + jumpFloor2
                jumpFloor1 = jumpFloor2 - jumpFloor1
                i += 1
            return jumpFloor2


# -*- coding:utf-8 -*-
class Solution3:
    def jumpFloor(self, number):
        # write code here
        Fibonacci = []
        Fibonacci.append(0)
        Fibonacci.append(1)
        Fibonacci.append(2)
        i = 3
        while (i <= number):
            Fibonacci.append(Fibonacci[i - 1] + Fibonacci[i - 2])
            i += 1
        return Fibonacci[number]

# -*- coding:utf-8 -*-
class Solution5:
    def jumpFloor(self, number):
        # write code here
        Fibonacci = [0] * (number + 1)
        if(number < 4):
            return number
        Fibonacci[0] = 0
        Fibonacci[1] = 1
        Fibonacci[2] = 2
        i = 3
        while (i <= number):
            Fibonacci[i] = Fibonacci[i - 1] + Fibonacci[i - 2]
            i += 1
        return Fibonacci[number]

# -*- coding:utf-8 -*-
class Solution4:
    def jumpFloor(self, number):
        # write code here
        if (number < 4):
            return number
        else:
            return Solution.jumpFloor(self,number - 1) + Solution.jumpFloor(self,number - 2)