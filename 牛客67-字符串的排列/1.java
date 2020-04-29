import java.util.ArrayList;
public class Solution {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<String>();
        if (str.length() == 0) return res;
        if (str.length() == 1){
            res.add(str);
            return res;
        }
        for (int i = 0;i < str.length();i++){
            if (i == 0 || str.charAt(i) != str.charAt(0)){
                for (String temp : Permutation(str.substring(0,i) + str.substring(i + 1))){
                    res.add(str.charAt(i) + temp);
                }
            }
        }
        return res;
    }
}





import java.util.ArrayList;
import java.util.Arrays;
public class Solution {

    public void swap(char[] array,int i,int j){
        char c = array[i];
        array[i] = array[j];
        array[j] = c;
    }

    public void reverse(char[] charArrayTemp,int begin,int end){
        for (int i = begin,j = end;i < j;i++,j--){
                char c = charArrayTemp[i];
                charArrayTemp[i] = charArrayTemp[j];
                charArrayTemp[j] = c;
            }
    }


    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<String>();
        if (str.length() == 0) return res;

        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        reverse(charArray,0,charArray.length - 1);

        char[] charArrayTemp = str.toCharArray();
       
        int indexI = 0;
        int indexJ = 0;

        while(true){
            res.add(String.valueOf(charArrayTemp));
            if (Arrays.equals(charArray,charArrayTemp)) break;
            for (int i = charArrayTemp.length - 1;i > 0;i--){
                if (charArrayTemp[i] > charArrayTemp[i - 1]){
                    indexI = i - 1;
                    break;
                }
            }
            for (int i = charArrayTemp.length - 1;i > indexI;i--){
                if (charArrayTemp[i] > charArrayTemp[indexI]){
                    indexJ = i;
                    break;
                }
            }
            swap(charArrayTemp,indexI,indexJ);
            reverse(charArrayTemp,indexI + 1,charArrayTemp.length - 1);
        }
        return res;
    }
}