# -*- coding:utf-8 -*-
class Solution1:                          #借助python字典进行处理，统计键值对，最后看出现次数是否满足要求即可
    def MoreThanHalfNum_Solution(self, numbers):
        # write code here
        count_num = {}
        for item in numbers:
            if item not in count_num.keys():
                count_num.update({item:1})          #字典添加新的键值对方法
            else:
                count_num[item] += 1
        for item in count_num.keys():
            if count_num[item] > (len(numbers) / 2):   #Python中 9 / 2 = 4.5  9 // 2 = 4
                return item
        return 0

# -*- coding:utf-8 -*-
class Solution2:                                     #出现次数超过一半，对原始数组排序后，要找的结果必然在数组中间
    def MoreThanHalfNum_Solution(self, numbers):     #统计该值出现次数做判断即可
        # write code here
        numbers.sort()
        target = numbers[len(numbers) // 2]
        count = 0
        for item in numbers:
            if item == target:
                count += 1
        if (count > len(numbers) / 2):
            return target
        else:
            return 0


# -*- coding:utf-8 -*-
class Solution3:                                 #哨兵法，遍历数组，target出现次数必然超过一半
    def MoreThanHalfNum_Solution(self, numbers): #采用元素消减，遇到不同元素，次数-1，否则+1
        # write code here                        #次数为0时，更新target为新的元素，同时出现次数置为1
        target = numbers[0]                      #最后得到target就是可能值，最后循环一次数组判断即可
        count = 1
        for i in range(1,len(numbers)):
            if (numbers[i] == target):
                count += 1
            else:
                count -= 1
                if (count == 0):
                    target = numbers[i]
                    count = 1
        count = 0
        for item in numbers:
            if item == target:
                count += 1
        if count > len(numbers) / 2:
            return target
        else:
            return 0
