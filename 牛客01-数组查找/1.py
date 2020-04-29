from numpy import shape
a = [[1,2,3],
	 [4,5,6],
	 [7,8,9]]
print(shape(a))        	#shape(a)方法是numpy里面的
						#a.shape[0]方法也是numpy的

print(len(a))			#不用numpy，就只能用len()方法


class Solution:
    # array 二维列表
    def Find(self, target, array):
        row = len(array)
        col = len(array[0])
        i = 0
        j = col - 1
        while i <= row-1 and j >= 0:   # python中   与是and  不是&&
            if target == array[i][j]:
                return True
            elif target < array[i][j]:
                j = j - 1
            else:
                i = i + 1
        return False

Solution = Solution()
print(Solution.Find(5,a))
print(Solution.Find(50,a))
