# -*- coding:utf-8 -*-
class Solution:
    def cutRope(self, number):
        # write code here
        if number < 2:
            return 0
        if number == 2:
            return 1
        if number == 3:
            return 2
        dp = [0] * (number + 1)
        dp[1] = 1
        dp[2] = 2
        dp[3] = 3
        i = 4
        while (i <= number):
            maxItem = 0
            for j in range(1,i / 2 + 1):
                maxItem = max(maxItem,dp[j] * dp[i - j])
            dp[i] = maxItem
            i += 1
        return dp[number]



# -*- coding:utf-8 -*-
class Solution:
    def cutRope(self, number):
        # write code here
        if number < 2:
            return 0
        if number == 2:
            return 1
        if number == 3:
            return 2
        power3 = number // 3
        remainder = number % 3
        if remainder == 0:
            return 3 ** power3
        if remainder == 1:
            return 3 ** (power3 - 1) * 4
        if remainder == 2:
            return 3 ** power3 * 2