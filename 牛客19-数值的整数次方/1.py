# -*- coding:utf-8 -*-                           #快速幂简单求法
class Solution:
    def Power(self, base, exponent):
        # write code here
        exp = abs(exponent)
        result = 1
        for i in range(exp):
            result *= base
        return (result if exponent > 0 else 1 / result)


# -*- coding:utf-8 -*- 							 #快速幂递归求法
class Solution:
    def recrusivePower(self,base,exp):
        if (exp == 1):
            return base
        elif (exp % 2 == 1):
            return base * self.recrusivePower(base,exp - 1)
        else:
            return self.recrusivePower(base,exp / 2) * self.recrusivePower(base,exp / 2)
    def Power(self, base, exponent):
        # write code here
        if exponent == 0:
            return 1
        exp = abs(exponent)
        result = self.recrusivePower(base,exp)
        return result if exponent > 0 else 1 / result 
        

        										#
# -*- coding:utf-8 -*- 							#10^12 = 10^(1100) = 10^8 * 10^4 = 10^(1000) * 10^(0100)
class Solution: 								#快速幂高级求法   位运算
    def Power(self, base, exponent): 			#位运算   时钟周期是 1个 
        # write code here 						#+-运算  时钟周期是2个
        item = base 							#*运算   时钟中期是4个
        exp = abs(exponent) 					#/运算   时钟周期是40个
        if (exponent == 0):
            return 1
        else:
            result = 1
            while(exp != 0):
                if (exp & 1 == 1):            #二进制当前位为1时，累成当前的
                    result *= item
                item *= item 				  #二进制最低位，base，倒数第二位，base^2,倒数第三位，base^4......
                exp >>= 1 					  #位移exponent
            return result if exponent > 0 else 1 / result
Solution = Solution()
print(Solution.Power(2,12))