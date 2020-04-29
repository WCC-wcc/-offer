# -*- coding:utf-8 -*-			#解题思路是怎么制定排序规则，对原数组进行排序即可，这里排序方法依然使用归并排序
class Solution1: 				#a,b  ab <= ba, a <= b,否则 a > b  
    def NewMergeSort(self,numbers,temp,left,right):
        if left < right:
            mid = (left + right) // 2
            self.NewMergeSort(numbers,temp,left,mid)
            self.NewMergeSort(numbers,temp,mid + 1,right)
            self.NewMerge(numbers,temp,left,mid,right)
    
    def NewMerge(self,numbers,temp,left,mid,right):
        i = left
        j = mid + 1
        k = left 
        while(i <= mid and j <= right):
            s1 = str(numbers[i]) + str(numbers[j])
            s2 = str(numbers[j]) + str(numbers[i])
            if (s1 < s2):
                temp[k] = numbers[i]
                i += 1
            else:
                temp[k] = numbers[j]
                j += 1
            k += 1
        if (i <= mid):
            temp[k:right + 1] = numbers[i:mid + 1]
        if (j <= right):
            temp[k:right + 1] = numbers[j:right + 1]
        numbers[left:right + 1] = temp[left:right + 1]
            
    def PrintMinNumber(self, numbers):
        # write code here
        temp = [0] * len(numbers)
        s = '' 
        self.NewMergeSort(numbers,temp,0,len(numbers) - 1)
        for item in numbers:
            s += str(item)
        return s


#lambda表达式返回可调用的函数对象，并且在运行时返回它们，通常是在需要一个函数，但是又不想去命名一个函数的场合下使用。

# -*- coding:utf-8 -*- 		
class Solution2: 			 	
    def PrintMinNumber(self, numbers):
        # write code here
        lmb = lambda n1, n2:int(str(n1) + str(n2)) - int(str(n2) + str(n1))
        array = sorted(numbers, cmp = lmb)
        return "".join([str(i) for i in array])


lmb = lambda n1, n2:int(str(n1) + str(n2)) - int(str(n2) + str(n1))
print(lmb(1,2))