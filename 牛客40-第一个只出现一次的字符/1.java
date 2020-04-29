public class Solution {                                 //思路就是遍历一次统计各个字符的出现次数
    public int FirstNotRepeatingChar(String str) {      //在遍历一次，找到第一个出现一次的字符
        if (str.length() < 1){
            return -1;
        }
        int [] res = new int[58];                      //A - Z: 65 - 90     a - z: 97 - 122   所以数组大小为58
        for(int i = 0;i < str.length();i++){
            res[str.charAt(i) - 'A']++;                //这里的str.charAt(i)取出str中的字符，不能用取下标的方式
        }                                              //res['a']++  是把a对应的ASCII码存进去
        for(int i = 0;i < str.length();i++){
            if (res[str.charAt(i) - 'A'] == 1){
                return i;
            }
        }
        return -1;
    }
}

import java.util.HashMap;
public class Solution {
    public int FirstNotRepeatingChar(String str) {
        if (str.length() < 1){
            return -1;
        }
        HashMap<Character,Integer> res = new HashMap<Character,Integer>();
        for(int i = 0;i < str.length();i++){
            if (res.containsKey(str.charAt(i))){
                res.put(str.charAt(i),res.get(str.charAt(i)) + 1);
            }else{
                res.put(str.charAt(i),1);
            }
        }
        for(int i = 0;i < str.length();i++){
            if (res.get(str.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }
}