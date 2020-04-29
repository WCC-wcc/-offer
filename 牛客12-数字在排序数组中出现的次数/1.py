# -*- coding:utf-8 -*-
class Solution1:
    def GetNumberOfK(self, data, k):
        # write code here
        count = 0
        for item in data:
            if item == k:
                count += 1
        return count


        						  #二分查找
# -*- coding:utf-8 -*-            #找到比k小的最邻近的一个数坐标，和比K大的最邻近一个数坐标，前者 - 后者 + 1即可
class Solution2:
    def FirstLess(self,data,k):
        begin = 0
        end = len(data)
        mid = (begin + end) // 2
        while(begin != end):
            if (data[mid] > k):
                end = mid
                mid = (begin + end) // 2
            else:
                begin = mid + 1
                mid = (begin + end) // 2
        return mid - 1
    def FirstMore(self,data,k):
            begin = 0
            end = len(data)
            mid = (begin + end) // 2
            while(begin != end):
                if (data[mid] > k):
                    end = mid
                    mid = (begin + end) // 2
                else:
                    begin = mid + 1
                    mid = (begin + end) // 2
            return mid 
    def GetNumberOfK(self, data, k):
        # write code here
        return self.FirstMore(data,k + 0.5) - self.FirstLess(data,k - 0.5) - 1
