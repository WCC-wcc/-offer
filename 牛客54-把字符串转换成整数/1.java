public class Solution {
    public int StrToInt(String str) {
        if (str.length() == 0) return 0;
        int sign = 1;
        int index = 0;
        double sum = 0.0;
        if (str.charAt(0) == '-') sign = -1;
        if (str.charAt(0) == '-' || str.charAt(0) == '+') index++;
        while (index < str.length()){
            sum *= 10;
            if (str.charAt(index) >= '0' && str.charAt(index) <= '9'){
                sum += (str.charAt(index) - '0');
                index++;
            }else return 0;
        }
        sum = sum * sign;
        if (sum >= Math.pow(-2,31) && sum < Math.pow(2,31)) return (int)(sum);
        else return 0;
    }
}