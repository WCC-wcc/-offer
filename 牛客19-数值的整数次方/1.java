public class Solution {                                 //快速幂简单求法
    public double Power(double base, int exponent) {
        int exp = Math.abs(exponent);
        double result = 1.0;
        if (exponent == 0){
            return 1;
        }else{
            for (int i = 0;i < exp;i++){
                result *= base;
            }
            if(exponent > 0){
                return result;
            }else{
                return 1 / result;
            }
        }
  }
}

public class Solution {                                     //快速幂递归求法
    public double recursivePower(double base,int exp){
        if (exp == 1){
            return base;
        }else if(exp % 2 == 1){
            return base * recursivePower(base,exp - 1);
        }else{
            return recursivePower(base,exp / 2) * recursivePower(base,exp / 2);
        }
    } 
    public double Power(double base, int exponent) {
        int exp = Math.abs(exponent);
        if (exp == 0){
            return 1;
        }else{
            double result;
            result = recursivePower(base,exp);
            if (exponent > 0){
                return result;
            }else{
                return 1 / result;
            }
        }
  }
}

public class Solution {
    public double Power(double base, int exponent) {
        int exp = Math.abs(exponent);
        if (exp == 0){
            return 1;
        }else{
            double result = 1.0;
            double temp = base;
            while (exp != 0){
                if ((exp & 1) == 1){
                    result *= temp;
                }
                temp *= temp;       //这里牛客网检测有误     temp *= base 居然也是对的  
                exp >>= 1;
            }
            if (exponent > 0){
                return result;
            }else{
                return 1 / result;
            }
        }
  }
}