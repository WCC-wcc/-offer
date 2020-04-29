# -*- coding:utf-8 -*-                     #左右指针，滑动窗口的思想，累加值不能超过 tsum / 2 + 1 停止
class Solution1:
    def FindContinuousSequence(self, tsum):
        # write code here
        res = []
        first = 1
        last = 2
        currSum = first
        tag = (tsum >> 1) + 1
        while (last <= tag):
            currSum += last
            if(currSum == tsum):
                temp = []
                for i in range(first,last + 1):
                    temp.append(i)
                res.append(temp)
                last += 1
            elif(currSum < tsum):
                last += 1
            else:
                currSum -= first
                currSum -= last
                first += 1
        return res


# Solution = Solution1()
# result = Solution.FindContinuousSequence(9)
# print(result)



# -*- coding:utf-8 -*-                                #暴力解法   遍历每一个起始点，到 tsum / 2 + 1 停止
class Solution2:
    def FindContinuousSequence(self, tsum):
        # write code here
        result = []
        val = 1
        mid = (tsum >> 1) + 1
        for i in range(val,mid + 1):
            currSum = i
            for j in range(i + 1,mid + 1):
                currSum += j
                print(currSum)
                if (currSum == tsum):
                    temp = []
                    for k in range(i,j + 1):
                        temp.append(k)
                    result.append(temp)
                if (currSum > tsum):
                    break
        return result


# Solution = Solution2()
# result = Solution.FindContinuousSequence(9)
# print(result)


# -*- coding:utf-8 -*-
class Solution3:                             #数学知识，等差数列求和  反推得到等差数列初始值和序列长度
    def FindContinuousSequence(self, tsum):  #an = a1 + (n - 1)d    Sn = (a1 + an) / 2 = na1 + n(n - 1)d/2 
        # write code here                    #a1 = Sn / n -(n - 1)d / 2
        result = []                          #2Sn = 2na1 + n^2 - n  -> 2Sn > n^2
        length = (int)((2 * tsum)**0.5)
        for n in range(length,1,-1):                #S % n 的结果是中间两项左边的那项，乘2刚好是项数
            if ((n & 1) == 1 and tsum % n == 0) or (tsum % n * 2 == n):#序列长度为奇数，tsum/n就是中间值
                first = (int)(tsum / n - (n - 1) / 2)                  #序列长度为偶数，tsum/n*2 = n
                temp = []                          
                for i in range(first,first + n):
                    temp.append(i)
                result.append(temp)
        return result

# Solution = Solution3()
# result = Solution.FindContinuousSequence(9)
# print(result)