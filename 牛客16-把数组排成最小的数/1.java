import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

public class Solution {
    public String PrintMinNumber(int [] numbers) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        String result = "";
        for (int i = 0; i < numbers.length;i++){
            list.add(numbers[i]);
        }
        //实现了Comparator接口的compare方法，将集合元素按照compare方法的规则进行排序
        Collections.sort(list,new Comparator<Integer>(){
            @Override
            public int compare(Integer s1,Integer s2){ 	//重写Comparator接口的compare方法
                String str1 = s1 + "" + s2;
                String str2 = s2 + "" + s1;
                return str1.compareTo(str2);
            }
        });
        for (Integer num : list){
            result += num;
        }
        return result;
    }
}