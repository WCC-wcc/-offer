# -*- coding:utf-8 -*-           #直接想法是将数字一直除以2,3,5，看最后是否为1，依次判断每一个数，直到index停止
class Solution:                                  #第二种解法是空间换时间，缓存每一个丑数。
    def GetUglyNumber_Solution(self, index):     #思路是用三个指针标识2,3,5对应乘的位置
        # write code here                        #用一个数组缓存已存在的有序的丑数
        if index < 1:                            #每次都是将数乘以2,3,5中的一个，取最小值存入缓存数组
            return 0                             #更新2,3,5对应的指针
        res = [1]
        nodeTwo = 0                              #一个丑数一定由另一个丑数乘以2或者乘以3或者乘以5得到
        nodeThree = 0
        nodeFive = 0
        for i in range(1,index):
            minOfThree = min(res[nodeTwo] * 2,res[nodeThree] * 3,res[nodeFive] * 5)
            res.append(minOfThree)
            if res[i] == res[nodeTwo] * 2:
                nodeTwo += 1
            if res[i] == res[nodeThree] * 3:
                nodeThree += 1
            if res[i] == res[nodeFive] * 5:
                nodeFive += 1
        return res[index - 1]
                       