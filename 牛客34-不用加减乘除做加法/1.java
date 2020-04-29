public class Solution {
    public int Add(int num1,int num2) {
        int sum = num1 ^ num2;                    //异或门做不带进位的加法
        int carry = (num1 & num2) << 1;           //逻辑与左移做进位计算
        while(carry != 0){
            num1 = sum;
            num2 = carry;
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;
        }
        return sum;
    }
}