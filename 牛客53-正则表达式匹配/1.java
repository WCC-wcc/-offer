public class Solution {
    public boolean match(char[] str, char[] pattern)
    {
        if (str.length == 0 && pattern.length == 0) return true;
        else if (str.length != 0 && pattern.length == 0) return false;
        else return isMatch(str,0,pattern,0);
    }
    public boolean isMatch(char[] str,int indexOfstr,char[] pattern,int indexOfpattern){
        if (indexOfstr == str.length && indexOfpattern == pattern.length) return true;
        else if (indexOfstr < str.length && indexOfpattern >= pattern.length) return false;
        else if (indexOfstr < str.length && indexOfpattern + 1 < pattern.length && pattern[indexOfpattern + 1] == '*'){
            if (str[indexOfstr] == pattern[indexOfpattern] || pattern[indexOfpattern] == '.'){
                boolean f1 = isMatch(str,indexOfstr + 1,pattern,indexOfpattern);
                boolean f2 = isMatch(str,indexOfstr + 1,pattern,indexOfpattern + 2);
                boolean f3 = isMatch(str,indexOfstr,pattern,indexOfpattern + 2);
                return f1 || f2 || f3;
            }else{
                return isMatch(str,indexOfstr,pattern,indexOfpattern + 2);
            }
        }
        else if(indexOfstr < str.length && indexOfpattern + 1 < pattern.length && pattern[indexOfpattern + 1] != '*'){
            if (str[indexOfstr] == pattern[indexOfpattern] || pattern[indexOfpattern] == '.'){
                return isMatch(str,indexOfstr + 1,pattern,indexOfpattern + 1);
            }else{
                return false;
            }
        }
        else if(indexOfstr < str.length && indexOfpattern + 1 == pattern.length){
            if (str[indexOfstr] == pattern[indexOfpattern] || pattern[indexOfpattern] == '.'){
                return isMatch(str,indexOfstr + 1,pattern,indexOfpattern + 1);
            }else{
                return false;
            }
        }
        else if(indexOfstr >= str.length && indexOfpattern + 1 < pattern.length && pattern[indexOfpattern + 1] == '*'){
            return isMatch(str,indexOfstr,pattern,indexOfpattern + 2);
        }
        else{
            return false;
        }
    }
}


public class Solution {
    public boolean match(char[] str, char[] pattern)
    {
        if (str.length == 0 && pattern.length == 0) return true;
        else if (str.length != 0 && pattern.length == 0) return false;
        boolean[][] dp = new boolean[str.length + 1][pattern.length + 1];
        dp[0][0] = true;
        for (int j = 1;j <= pattern.length;j++){
            if (pattern[j - 1] == '*'){
                dp[0][j] = dp[0][j - 2];
            }
        }
        for (int i = 1;i <= str.length;i++){
            for(int j = 1;j <= pattern.length;j++){
                if (str[i - 1] == pattern[j - 1] || pattern[j - 1] == '.'){
                    dp[i][j] = dp[i - 1][j - 1];
                }else if (pattern[j - 1] == '*'){
                    if (str[i - 1] == pattern[j - 2] || pattern[j - 2] == '.'){
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j] || dp[i][j - 1];
                    }else{
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }
        return dp[str.length][pattern.length];
    }
}



// dp[i][j] = dp[i-1][j]  多个字符匹配的情况     pattern不变  str可以一直向后移动长度
//or dp[i][j] = dp[i][j-1]  单个字符匹配的情况   *可以被舍去
//or dp[i][j] = dp[i][j-2]  没有匹配的情况       .*可以被舍去