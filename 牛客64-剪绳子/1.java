public class Solution {
    public int cutRope(int target) {
        int[] dp = new int[target + 1];
        if (target < 2) return 0;
        if (target == 2) return 1;
        if (target == 3) return 2;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= target;i++){
            int max = 0;
            for (int j = 1; j <= i / 2;j++){
                max = Math.max(dp[j] * dp[i - j],max);
            }
            dp[i] = max;
        } 
        return dp[target];
    }
}


public class Solution {
    public int cutRope(int target) {
        if (target < 2) return 0;
        if (target == 2) return 1;
        if (target == 3) return 2;
        int power3 = target / 3;
        int remainder = target % 3;
        if (remainder == 0){
            return (int)Math.pow(3,power3);
        }
        else if (remainder == 1){
            return (int)Math.pow(3,power3 - 1) * 4;
        }
        else{
            return (int)Math.pow(3,power3) * 2;
        }
    }
}