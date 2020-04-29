# -*- coding:utf-8 -*-
class Solution1:                                    #解题思路是   设置一个当前最大和max_sum,和一个累加和sum
    def FindGreatestSumOfSubArray(self, array):     #遍历数组，sum进行累加，每累加一个元素，做两个判断
        # write code here                           #第一个判断是和max_sum进行比较，更新最大和
                                                    #第二个判断是看sum是否小于等于0，
                                                    #若是，则说明最大和要么已经出现，
                                                    #要么，最大和出现在下面的连续子串中
        max_sum = -float('inf')                         #python中无穷的表示方法  +-float('inf')
        sum = 0
        for item in array:
            sum += item
            if (sum > max_sum):
                max_sum = sum
            if (sum <= 0):
                sum = 0
        return max_sum

a = [-3,-2,-1,-5,-6,-9]
Solution = Solution1()
print(Solution.FindGreatestSumOfSubArray(a))


# -*- coding:utf-8 -*-
class Solution2:                                #解题思路是设立累加和sum和当前最大和max_sum
                                                #每次累加一个元素，判断sum和当前元素大小，更新sum
                                                #再判断sum和mxa_sum大小，更新max_sum (这里的判断顺序不可以变)
    def FindGreatestSumOfSubArray(self, array):
        # write code here
        max_sum = -float('inf')                         #python中无穷的表示方法  +-float('inf')
        sum = 0
        for item in array:
            sum += item
            if (sum <= item):
                sum = item
            if (sum > max_sum):
                max_sum = sum
        return max_sum

