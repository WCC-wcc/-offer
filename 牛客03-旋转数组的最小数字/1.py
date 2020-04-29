# -*- coding:utf-8 -*-
#暴力解法    遍历数组找到最小值
class Solution1:
    def minNumberInRotateArray(self, rotateArray):
        # write code here
        if len(rotateArray) == 0:
            return 0
        min = rotateArray[0]
        for item in rotateArray:
            if item < min:
                min = item
        return min


# -*- coding:utf-8 -*-
#遍历数组   找到转折点
class Solution2:
    def minNumberInRotateArray(self, rotateArray):
        # write code here
        if len(rotateArray) == 0:
            return 0
        i = 0
        while (i < len(rotateArray) - 1):
            if rotateArray[i] > rotateArray[i + 1]:
                return rotateArray[i + 1]
            i += 1


# -*- coding:utf-8 -*-
#调用函数min()直接返回最小值
class Solution3:
    def minNumberInRotateArray(self, rotateArray):
        # write code here
        if len(rotateArray) == 0:
            return 0
        i = 0
        return min(rotateArray)

# -*- coding:utf-8 -*-
#二分查找  找到最小值
class Solution4:
    def minNumberInRotateArray(self, rotateArray):
        # write code here
        if len(rotateArray) == 0:
            return 0
        left = 0
        right = len(rotateArray) - 1
        while (left != right):
            mid = (left + right) // 2
            if (rotateArray[mid] > rotateArray[right]):
                left = mid + 1
            elif (rotateArray[mid] < rotateArray[right]):
                right = mid
            else:
                return  rotateArray[mid]
        return rotateArray[left]
# print(9 // 2)
a = [4,5,1,2,3]
Solution = Solution4()
print(Solution.minNumberInRotateArray(a))
