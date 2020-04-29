import java.util.HashMap;

public class Solution {
    //Insert one char from stringstream

    private HashMap<Character,Integer> res = new HashMap<Character,Integer>();
    private StringBuffer s = new StringBuffer();

    public void Insert(char ch)
    {
        s.append(ch);
        if (res.containsKey(ch)){
            res.put(ch,res.get(ch) + 1);
        }else{
            res.put(ch,1);
        }
    }
  //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        for (int i = 0;i < s.length();i++){
            if (res.get(s.charAt(i)) == 1) return s.charAt(i);
        }
        return '#';
    }
}



public class Solution {
    //Insert one char from stringstream

    private int[] count = new int [95];
    private StringBuffer s = new StringBuffer();

    public void Insert(char ch)
    {
        if (count[ch - ' '] == 0){
            s.append(ch);
        }
        count[ch - ' ']++;
    }
  //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        while(s.length() > 0){
            if (count[s.charAt(0) - ' '] > 1){
                s.deleteCharAt(0);
            }else{
                return s.charAt(0);
            }
        }
        return '#';
    }
}