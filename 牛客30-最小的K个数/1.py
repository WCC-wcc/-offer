#库函数
# -*- coding:utf-8 -*-
class Solution:
    def GetLeastNumbers_Solution(self, tinput, k):
        # write code here
        if (not tinput or k > len(tinput)):
            return []
        tinput.sort()
        return tinput[:k]

#归并排序   非原地排序    nlogn    稳定
# -*- coding:utf-8 -*-
class Solution:
    def GetLeastNumbers_Solution(self, tinput, k):
        # write code here
        def MergeSort(array,temp,left,right):
            if (left < right):
                mid = (left + right) >> 1
                MergeSort(array,temp,left,mid)
                MergeSort(array,temp,mid + 1,right)
                Merge(array,temp,left,mid,right)
        def Merge(array,temp,left,mid,right):
            i = left 
            j = mid + 1
            index = left
            while(i <= mid and j <= right):
                if (array[i] <= array[j]):
                    temp[index] = array[i]
                    i += 1
                else:
                    temp[index] = array[j]
                    j += 1
                index += 1
            if i <= mid:
                temp[index:right + 1] = array[i : mid + 1]
            if j <= right:
                temp[index:right + 1] = array[j : right + 1]
            array[left:right + 1] = temp[left:right + 1]

        temp = [0] * len(tinput)
        MergeSort(tinput,temp,0,len(tinput) - 1)
        if (not tinput or k > len(tinput)):
            return []
        return tinput[:k] 

#冒泡排序    原地排序    n^2  稳定           与选择排序不同在于，每次循环，两两比较，大数右移
# -*- coding:utf-8 -*-
class Solution:
    def GetLeastNumbers_Solution(self, tinput, k):
        # write code here
        def bubbleSort(array):
            for i in range(len(array) - 1):            #n个数据需要比较n-1轮   每轮都从array[0]开始，到len-i-1停止
                for j in range(0,len(array) - i - 1):  #可以递增排序   也可以递减排序
                    if (array[j] > array[j + 1]):
                        temp = array[j]
                        array[j] = array[j + 1]
                        array[j + 1] = temp
        bubbleSort(tinput)
        if (not tinput or k > len(tinput)):
            return []
        return tinput[:k] 


#选择排序   原地排序    n^2  不稳定        与冒泡排序不同之处在于，每次循环，依次比较，找到min只交换一次位置，
# -*- coding:utf-8 -*-
class Solution:
    def GetLeastNumbers_Solution(self, tinput, k):
        # write code here
        def selectSort(array):
            for i in range(len(array) - 1):   #n个元素 比较n-1轮
                index = i 
                for j in range(i + 1,len(array)):  #每一轮找到当前最小的元素下标
                    if array[j] < array[index]:
                        index = j
                temp = array[i]                    #元素互换位置
                array[i] = array[index]
                array[index] = temp
        selectSort(tinput)
        if (not tinput or k > len(tinput)):
            return []
        return tinput[:k] 


#插入排序   原地排序  n^2  稳定    n个元素遍历n-1轮，每一轮从i往前遍历，调整添加数字的位置
# -*- coding:utf-8 -*-
class Solution:
    def GetLeastNumbers_Solution(self, tinput, k):
        # write code here
        def insertSort(array):
            for i in range(1,len(array)):
                for j in range(i,0,-1):
                    if array[j] < array[j - 1]:
                        temp = array[j]
                        array[j] = array[j - 1]
                        array[j - 1] = temp
        insertSort(tinput)
        if (not tinput or k > len(tinput)):
            return []
        return tinput[:k] 


#希尔排序    原地排序   nlogn  不稳定   插入排序升级版   逻辑上划分小组进行插入排序
# -*- coding:utf-8 -*-
class Solution:
    def GetLeastNumbers_Solution(self, tinput, k):
        # write code here
        def shellSort(array):
            gap = len(array) >> 1
            while(gap > 0):                              #组内插入排序
                for i in range(gap,len(array)):          #组内下标从小往大增加
                    j = i - gap
                    temp = array[j + gap]                #为array[i]找到组内合适的位置
                    while(j >= 0 and temp < array[j]):
                        array[j + gap] = array[j]
                        j -= gap
                    array[j + gap] = temp
                gap >>= 1
        shellSort(tinput)
        if (not tinput or k > len(tinput)):
            return []
        return tinput[:k] 


#快速排序   原地排序    nlogn  不稳定     
# -*- coding:utf-8 -*-
class Solution:
    def GetLeastNumbers_Solution(self, tinput, k):
        # write code here
        def quickSort(array,left,right):
            if left < right:
                temp = array[left]
                low = left
                high = right
                while(low != high):
                    while(array[high] >= temp and low < high):
                        high -= 1
                    array[low] = array[high]
                    while(array[low] <= temp and low < high):
                        low += 1
                    array[high] = array[low]
                array[low] = temp
                quickSort(array,left,low - 1)
                quickSort(array,low + 1,right) 
        quickSort(tinput,0,len(tinput) - 1)
        if (not tinput or k > len(tinput)):
            return []
        return tinput[:k]


#堆排序    nlogn  原地排序   不稳定    先建立一个大(小)顶堆，交换首尾元素，调整大(小)顶堆，继续交换，最后数据有序
# -*- coding:utf-8 -*-
class Solution:
    def GetLeastNumbers_Solution(self, tinput, k):
        # write code here
        def swap(array,i,j):
            temp = array[i]
            array[i] = array[j]
            array[j] = temp

        def createHeap(array,length):
            lastParent = (length >> 1) - 1
            for i in range(lastParent,-1,-1):
                adjustHeap(array,i,length)

        def adjustHeap(array,adjustNode,length):
            child = (adjustNode << 1) + 1
            while(child < length):
                if (child + 1 < length and array[child + 1] > array[child]):
                    child += 1
                if (array[child] > array[adjustNode]):
                    swap(array,child,adjustNode)
                    adjustNode = child
                    child = (adjustNode << 1) + 1
                else:
                    break

        def heapSort(array):
            createHeap(array,len(array))
            for i in range(len(array) - 1,0,-1):
                swap(array,0,i)
                adjustHeap(array,0,i)

        heapSort(tinput)
        if (not tinput or k > len(tinput)):
            return []
        return tinput[:k]



# -*- coding:utf-8 -*-
class Solution:
    def GetLeastNumbers_Solution(self, tinput, k):
        # write code here
        def swap(array,i,j):
            temp = array[i]
            array[i] = array[j]
            array[j] = temp

        def createHeap(array,length):
            lastParent = (length >> 1) - 1
            for i in range(lastParent,-1,-1):
                adjustHeap(array,i,length)

        def adjustHeap(array,adjustNode,size):
            child = (adjustNode << 1) + 1
            while(child < size):
                if (child + 1 < size and array[child + 1] > array[child]):
                    child += 1
                if (array[child] > array[adjustNode]):
                    swap(array,child,adjustNode)
                    adjustNode = child
                    child = (adjustNode << 1) + 1
                else:
                    break

        if (not tinput or k > len(tinput) or k < 1):
            return []
        else:
            result = tinput[:k]
            createHeap(result,k)
            for i in range(k,len(tinput)):
                if (tinput[i] < result[0]):
                    result[0] = tinput[i]
                    adjustHeap(result,0,k)
            result.sort()
            return result