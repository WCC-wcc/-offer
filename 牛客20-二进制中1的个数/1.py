# -*- coding:utf-8 -*-                      #正数的源码，反码，补码都一样，最高位是符号位0，
                                            #负数的源码是绝对值的源码，符号位是1，反码是源码各位取反，符号位不变，
                                            #补码是反码末尾加1    

                                            #源码，反码表示范围（-2^n + 1 ~ 2^n - 1） 补码（-2^n  ~ 2^n - 1）
                                            
                                            #源码直接表示数字，计算减法数值出错，并且有+-0
                                            #反码可以进行减法计算，但还是有两个0问题
                                            #补码既可以正确进行减法，而且没有-0
class Solution1:
    def NumberOf1(self, n):
        # write code here
        count = 0
        if (n >= 0):                        #对正整数，用源码表示
            while(n != 0):                  #做与运算，遍历数字二进制表示的每一位
                if (n & 1) == 1:            #是1直接计数即可
                    count += 1
                n >>= 1
        else:
            n = abs(n)                      #得到数字绝对值(python  int  数字不溢出)
            temp = [0] * 32                 #初始化二进制数组，32位
            # print(temp)
            i = 31
            while (n != 0):
                temp[i] = n & 1
                n >>= 1
                i -= 1
            temp[0] = 1
            print(temp)                     #计算得到源码

            for i in range(1,32):
                temp[i] ^= 1
            print(temp)                     #计算得到反码

            temp[-1] += 1
            print(temp)
            for i in range(31,0,-1):
                if temp[i] == 2:
                    temp[i] = 0
                    temp[i - 1] += 1
            temp[0] = 1
            print(temp)                    #计算得到补码

            for item in temp:              #遍历补码中1的个数
                if item == 1:
                    count += 1
        return count



# -*- coding:utf-8 -*-
class Solution2:
    def NumberOf1(self, n):
        # write code here
        count = 0
        flag = 1
        if n < 0:
            n &= 0xfffffff              #为了得到负数的补码
        while(flag <= 2** 32):
            if (n & flag) != 0:
                count += 1
            flag <<= 1
        return count
# Solution2 = Solution2()
# print(Solution2.NumberOf1(-2147483647))

# -*- coding:utf-8 -*-
class Solution3:
    def NumberOf1(self, n):
        # write code here
        count = 0
        n = n & 0xffffffff
        while ( n != 0):
            count += 1
            n &= n -1
        return count

# -*- coding:utf-8 -*-
class Solution:
    def NumberOf1(self, n):
        # write code here
        count = 0
        n &= 0xffffffff
        n = str(bin(n))
        for item in n :
            if item == '1':
                count += 1
        return count
        


















# Solution = Solution()
# print(Solution.NumberOf1(-2147483648))


# Python中的整型是补码形式存储的
# Python中bin一个负数（十进制表示），输出的是它的原码的二进制表示加上个负号，方便查看（方便个鬼啊）
# Python中bin一个负数（十六进制表示），输出的是对应的二进制表示。


# 所以你为了获得负数（十进制表示）的补码，需要手动将其和十六进制数0xfffffffd进行按位与操作，
# 得到结果也是个十六进制数，再交给bin()进行输出，得到的才是你想要的补码表示。

# print(bin(8))        #0b1000
# print(bin(-8))       #-0b1000
# print(-8 & 0xffffffff) #4294967288
# print(bin(-8 & 0xffffffff)) #0b11111111111111111111111111111000
