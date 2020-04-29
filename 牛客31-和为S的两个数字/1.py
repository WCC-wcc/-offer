# -*- coding:utf-8 -*-
class Solution:
    def FindNumbersWithSum(self, array, tsum):
        # write code here
        i = 0
        j = len(array) - 1
        while(i <= j):
            if (array[i] + array[j] == tsum):
                return [array[i],array[j]]
            elif (array[i] + array[j] < tsum):
                i += 1
            else: 
                j -= 1
        return []

#因为数组有序，所以可以采用   夹逼方法     从首尾向中间逼近遇到第一对数字即为符合要求的
#假设数组中四个数字[a,b,c,d]  a + d = b + c    那么可以得到 a + m = b   d - m = c  
#b*c = (a + m) * (d - m) = ad - am + dm - mm = ad + (dm - am - mn)
#dm - am - mm = (d - a - m)m   a + m < d -->   (d - a - m)m > 0     ad + (dm - am - mn) > ad  也就是bc > ad
#a + d < tsum  a++
#a + d > tsum  d--