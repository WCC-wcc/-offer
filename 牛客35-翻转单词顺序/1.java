public class Solution {
    public String ReverseSentence(String str) {
        if (str.trim().equals("")){                       //trim()函数删除头尾空白字符
            return str;
        }                                        
        StringBuffer res = new StringBuffer();            //StringBuffer().append(item)
        String[] temp = str.split(" ");
        for (int i = temp.length - 1;i >= 0;i--){
            res.append(temp[i]);
            if (i > 0){
                res.append(' ');
            }
        }
        return res.toString();
    }
}


public class Solution {
    public void ReverseStr(StringBuffer str,int begin,int end) {
        while(begin < end){
            char c = str.charAt(begin);
            str.setCharAt(begin,str.charAt(end));
            str.setCharAt(end,c);
            begin++;
            end--;
        }
    }
    public String ReverseSentence(String str) {
        StringBuffer res = new StringBuffer(str);
        ReverseStr(res,0,res.length() - 1);
        int begin = 0;
        for (int i = 0;i < res.length();i++){
            if (res.charAt(i) == ' '){
                int end = i - 1;
                ReverseStr(res,begin,end);
                begin = i + 1;
            }
        }
        ReverseStr(res,begin,res.length() - 1);
        return res.toString();
    }
}