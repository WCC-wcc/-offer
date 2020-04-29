public class Solution {
    public String LeftRotateString(String str,int n) {
        if (n > str.length()){
            return "";
        }
        char[] temp = str.toCharArray();
        String s = "";
        for (int i = n; i < str.length();i++){
            s += temp[i];
        }
        for (int i = 0;i < n;i++){
            s += temp[i]; 
        }
        return s;
    }
}

public class Solution {
    public String LeftRotateString(String str,int n) {
        if (n > str.length()){
            return "";
        }
        return str.substring(n,str.length()) + str.substring(0,n);
    }
}



public class Solution {          //           AB->BA  (A^T * B^T)^T = BA  所以一共转置字符串三次即可
    public void reverseStr(char[] c,int begin,int end){
        while(begin < end){
            char temp = c[begin];
            c[begin] = c[end];
            c[end] = temp;
            begin++;
            end--;
        }
    }
    public String LeftRotateString(String str,int n) {
        if (n > str.length()){
            return "";
        }
        char[] c = str.toCharArray();
        reverseStr(c,0,n - 1);
        reverseStr(c,n,str.length() - 1);
        reverseStr(c,0,str.length() - 1);
        return String.valueOf(c);
    }
}








public class Solution {
    public String LeftRotateString(String str,int n) {
        if (n > str.length()){
            return "";
        }
        String s = "";
        for (int i = n; i < str.length();i++){
            s += str.charAt(i);
        }
        for (int i = 0;i < n;i++){
            s += str.charAt(i); 
        }
        return s;
    }
}