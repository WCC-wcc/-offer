# -*- coding:utf-8 -*-          #双循环可以解决问题  但是耗时严重    牛客网会判定超时
class Solution1:
    def InversePairs(self, data):
        # write code here
        count = 0
        for i in range(len(data) - 1):
            for j in range(i + 1,len(data)):
                if(data[i] > data[j]):
                    count += 1  
        return count % 1000000007


# a = [364,637,341,406,747,995,234,971,571,219,993,407,416,366,315,301,601,650,418,355,460,505,360,965,516,648,727,667,465,849,455,181,486,149,588,233,144,174,557,67,746,550,474,162,268,142,463,221,882,576,604,739,288,569,256,936,275,401,497,82,935,983,583,523,697,478,147,795,380,973,958,115,773,870,259,655,446,863,735,784,3,671,433,630,425,930,64,266,235,187,284,665,874,80,45,848,38,811,267,575]
# Solution = Solution1()
# print(Solution.InversePairs(a))





# -*- coding:utf-8 -*-
count = 0                                   # 归并排序  这种写法  内存不太友好  不是原地排序
class Solution2:
    def MergeSort(self,array):
        if (len(array) == 1):
            return array
        else:
            left_array = array[:len(array) // 2]
            right_array = array[len(array) // 2:]
            
            left_array = self.MergeSort(left_array)
            right_array = self.MergeSort(right_array)
            
            merge_array = self.Merge(left_array,right_array)
            return merge_array
        
    def Merge(self,left_array,right_array):
        global count 
        result = []
        i = 0
        j = 0
        while (i < len(left_array) and j < len(right_array)):
            if(left_array[i] <= right_array[j]):
                result.append(left_array[i])
                i += 1
            else:
                result.append(right_array[j])
                j += 1
                count += len(left_array) - i
                count = count % 1000000007
        while (i < len(left_array)):
            result.append(left_array[i])
            i += 1
        while (j < len(right_array)):
            result.append(right_array[j])
            j += 1
        return result
        
    def InversePairs(self, data):
        # write code here
        self.MergeSort(data)
        return count % 1000000007


# -*- coding:utf-8 -*-
count = 0
class Solution3:                                                     #牛客网通过  原地排序
    def MergeSort(self,array,temp,left,right):
        if(left < right):
            mid = (left + right) // 2
            self.MergeSort(array,temp,left,mid)
            self.MergeSort(array,temp,mid + 1,right)
            self.Merge(array,temp,left,mid,right)

    def Merge(self,array,temp,left,mid,right):
        global count
        i = left
        j = mid + 1  
        k = left
        while(i <= mid and j <= right):
            if(array[i] <= array[j]):
                temp[k] = array[i]
                i += 1
            else:
                temp[k] = array[j]
                j += 1
                count += mid - i + 1                            #统计逆序对，并对数字大小做判断
                if (count > 1000000007):
                    count %= 1000000007
            k += 1
        while (i <= mid):
            temp[k] = array[i]
            i += 1
            k += 1
        while(j <= right):
            temp[k] = array[j]
            j += 1
            k += 1
        while(left <= right):
            array[left] = temp[left]
            left += 1
    def InversePairs(self, data):
        # write code here
        temp = [0] * len(data)
        self.MergeSort(data,temp,0,len(data) - 1)
        return count