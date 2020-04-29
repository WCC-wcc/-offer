public class Solution {
    public int Sum_Solution(int n) {
        int res = 0;
        boolean tag = (n > 0) && ((res = n + Sum_Solution(n - 1)) > 0);
        return res;
    }
}