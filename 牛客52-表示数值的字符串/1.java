import java.util.regex.*;
public class Solution {
    public boolean isNumeric(char[] str) {
        String str_pattern = "^[+-]?\\d*[.]?\\d+(?:[eE][+|-]?\\d+)?$";
        return Pattern.matches(str_pattern,String.valueOf(str));
    }
}


public class Solution {
    public boolean isNumeric(char[] str) {
        boolean point = false;
        boolean exp = false;
        for (int i = 0;i < str.length;i++){
            if (str[i] == '+' || str[i] == '-' || str[i] == '.' || str[i] == 'e' || str[i] == 'E'){
                if (i + 1 == str.length) return false;
            }
            if (str[i] == '+' || str[i] == '-'){
                if (i != 0 && str[i - 1] != 'e' && str[i - 1] != 'E') return false;
            }else if (str[i] == '.'){
                if (point) return false;
                else if (str[i + 1] == 'e' || str[i + 1] == 'e') return false;
                else{
                    point = true;
                    if (exp) return false;
                }
            }else if (str[i] == 'e' || str[i] == 'E'){
                if (exp) return false;
                else{
                    exp = true;
                }
            }else if (str[i] < '0' || str[i] > '9'){
                return false;
            }
        }
        return true;
    }
}

