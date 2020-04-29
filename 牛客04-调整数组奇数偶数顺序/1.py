# -*- coding:utf-8 -*-
class Solution1:                              #解决方法1是用内存换时间  用两个数组按照原数组顺序分别存储奇数和偶数
    def reOrderArray(self, array):
        # write code here
        odd_array = []
        eve_array = []
        for item in array:
            if item % 2 == 0:
                eve_array.append(item)
            else:
                odd_array.append(item)
        return odd_array + eve_array          #列表连接方法  list(a) + list(b)

# -*- coding:utf-8 -*-                          
class Solution2:                    #解决方法2是不用其他数组，在原数组上进行元素位置互换操作，时间复杂度为N^2
    def reOrderArray(self, array):
        # write code here
        for i in range(1,len(array),1):
            for j in range(i,0,-1):             #range(a,b,c)  从a->b，步长为c，最后不会遍历到array[b]
                if array[j] % 2 == 1 and array[j - 1] % 2 == 0:
                    temp = array[j]
                    array[j] = array[j - 1]
                    array[j - 1] = temp
        return array

Solution = Solution2()
a = [2,4,6,1,3,5,7]
print(Solution.reOrderArray(a))

a = [1,2,3]
b = [4,5,6]
a.append(b)                                    #必须在a.append(b)之后，在进行c = a
c = a                                          # c = a.append(b)是错误的
print(c)
