# -*- coding:utf-8 -*-
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def FindKthToTail(self, head, k):
        # write code here
        temp1 = head
        result = temp1
        count = 0
        while(temp1 != None and count != k):
            temp1 = temp1.next
            count += 1
        if(temp1 == None and count < k):
            return None
        print(temp1.val,k,result.val)
        while(temp1 != None):
            temp1 = temp1.next
            result = result.next
       	return result

list = ListNode(1)
TEMP = list
for i in range(2,6):
	list.next = ListNode(i)
	list = list.next

Solution = Solution()
print(Solution.FindKthToTail(TEMP,1).val)