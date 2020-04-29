public class Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        for (int i = 1;i <= n;i++){
            for(int j = i; j > 0;j /= 10){
                if (j % 10 == 1) count++;
            }
        }
        return count;
    }
}



public class Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        for (int m = 1;m <= n; m *= 10){
            int a = n / m;
            int b = n % m;
            count += (a + 8) / 10 * m + (a % 10 == 1 ? (b + 1) : 0);
        }
        return count;
    }   
}