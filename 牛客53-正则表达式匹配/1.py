# -*- coding:utf-8 -*-
class Solution1:
    # s, pattern都是字符串
    def match(self, s, pattern):
        # write code here
        if not s and not pattern:
            return True
        if s and not pattern:
            return False
        if s and len(pattern) > 1 and pattern[1] == '*':
            if s[0] == pattern[0] or pattern[0] == '.':
                return self.match(s[1:],pattern) or self.match(s[1:],pattern[2:]) or self.match(s,pattern[2:]) 
            else: 
                return self.match(s,pattern[2:]) 
        elif s and len(pattern) > 1 and pattern[1] != '*':
            if (s[0] == pattern[0] or pattern[0] == '.'):
                return self.match(s[1:],pattern[1:])
            else:
                return False
        elif s and pattern:
            if s[0] == pattern[0] or pattern[0] == '.':
                return self.match(s[1:],pattern[1:])
        elif not s and len(pattern) > 1 and pattern[1] == '*':
            return self.match(s,pattern[2:])
        else:
            return False





# -*- coding:utf-8 -*-
class Solution:
    # s, pattern都是字符串
    def match(self, s, pattern):
        # write code here
        if not s and not pattern:
            return True
        if s and not pattern:
            return False
        lens = len(s)
        lenp = len(pattern)
        dp = [[False for j in range(lenp + 1)] for i in range(lens + 1)]
        dp[0][0] = True

        for i in range(1,lenp + 1):
            if pattern[i - 1] == '*':
                dp[0][i] = dp[0][i - 2]

        for i in range(1,lens + 1):
            for j in range(1,lenp + 1):
                if (s[i - 1] == pattern[j - 1] or pattern[j - 1] == '.'):
                    dp[i][j] = dp[i - 1][j - 1]
                elif pattern[j - 1] == '*':
                    if s[i - 1] == pattern[j - 2] or pattern[j - 2] == '.':
                        dp[i][j] = dp[i][j - 2] or dp[i][j - 1] or dp[i - 1][j] 
                    else:
                        dp[i][j] = dp[i][j - 2]
        return dp[-1][-1]

