# -*- coding:utf-8 -*-
class Solution:
    def NumberOf1Between1AndN_Solution(self, n):
        # write code here
        count = 0
        i = 1
        while(i <= n):
            j = i
            while(j != 0):
                if (j % 10) == 1:
                    count += 1
                j /= 10
            i += 1
        return count



# -*- coding:utf-8 -*-
class Solution:
    def NumberOf1Between1AndN_Solution(self, n):
        # write code here
        count = 0
        m = 1
        while(m <= n):
            a = n / m
            b = n % m
            count += (a + 8) / 10 * m + ((b + 1) if a % 10 == 1 else 0)
            m *= 10
        return count 
        