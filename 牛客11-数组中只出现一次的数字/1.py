# -*- coding:utf-8 -*-                    #方法1-4都是老方法，不太适用这题，方法5的位运算独树一帜，技术流解题
class Solution1: 
    # 返回[a,b] 其中ab是出现一次的两个数字
    def FindNumsAppearOnce(self, array):       #方法1还是用字典存储键值对，最后遍历字典，得到出现次数为1的两个值返回
        # write code here
        count_num = {}
        for item in array:
            if item not in count_num.keys():
                count_num.update({item:1})
            else:
                count_num[item] += 1
        result = []
        for key in count_num.keys():
            if count_num[key] == 1:
                result.append(key)
        return result


# -*- coding:utf-8 -*-
class Solution2:                           #方法2时间复杂度o(n^2)，采用外循环和内循环，外循环遍历每个元素，
    # 返回[a,b] 其中ab是出现一次的两个数字   #内循环判断该元素是否重复出现，只要重复就退出内循环，外循环判断下个元素
    def FindNumsAppearOnce(self, array):
        # write code here
        result = []
        for i in range(len(array)):
            for j in range(len(array)):
                if array[i] == array[j] and i != j:
                    break;
                if (j == len(array) - 1):
                    result.append(array[i])
        return result

# -*- coding:utf-8 -*-
class Solution3:                          #方法3先对数组排序，完了比较一下数组第一个元素最后一个元素是不是只出现一次
    # 返回[a,b] 其中ab是出现一次的两个数字  #对数组第二个元素到倒数第2个元素依次遍历判断i元素和i-1元素i+1元素是否相同
    def FindNumsAppearOnce(self, array):
        # write code here
        result = []
        array.sort()
        if(array[0] != array[1]):
            result.append(array[0])
        
        if(array[-1] != array[-2]):
            result.append(array[-1])

        for i in range(1,len(array) - 1):
            if(array[i] != array[i - 1] and array[i] != array[i + 1]):
                result.append(array[i])
        return result


# -*- coding:utf-8 -*-
class Solution4:                          #方法4利用题意，对出现一次元素，放进列表中，出现两次，就从列表中删除
    # 返回[a,b] 其中ab是出现一次的两个数字
    def FindNumsAppearOnce(self, array):
        # write code here
        result = []
        for item in array:
            if item in result:
                result.remove(item)
            else:
                result.append(item)
        return result
        								#12 >> 2 = (1100) >> 2 = (11) = 3
        								#3 & 1 = (11) & (01) = (01) = 1  
        								#12 & 1 = (1100) & (0001) = (0000) = 0
        								#12 ^ 1 = (1100) ^ (0001) = (1101) = 13
# -*- coding:utf-8 -*-						#比较技术流做法，采用位运算，Python异或符号  a ^ b  位移 a >> b
class Solution5:                     		#相同数字异或=0，不同数字异或=1 ，a >> b 表示a右移b位
    def FindFirstIndexOfOne(self,num):      #找到数字二进制表示第一个为1的位置
        index = 0
        while (index < 32 and num & 1 == 0):  #循环体：二进制位数小于32，并且当前位不为1
            index += 1
            num >>= 1 
        return index
    
    def BitFind(self,index,num):		#判断当前数字的二进制表示的第index位是否为1
        num >>= index
        if(num & 1 == 1):
            return True
        else:
            return False
    # 返回[a,b] 其中ab是出现一次的两个数字
    def FindNumsAppearOnce(self, array):  #方法5的思路就是先把所有数字做异或运算，结果肯定是两个只出现一次的数字的异或
        # write code here                 #然后找到结果二进制表示第一个为1的位置index，将数组划分成两个小组
        sum = 0;                          #划分依据 是元素二进制表示第index位置是否为1
        for item in array:                #将两个子数组分别进行累计异或运算，最后结果就是只出现一次的元素
            sum ^= item
        first_index = self.FindFirstIndexOfOne(sum)
        a,b = 0,0
        for item in array:
            if self.BitFind(first_index,item):
                a ^= item
            else:
                b ^= item
        return [a,b];

print(12 ^ 1)
a = [2,4,3,6,3,2,5,5]
Solution5 = Solution5()
print(Solution5.FindNumsAppearOnce(a))