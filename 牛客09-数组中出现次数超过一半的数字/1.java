import java.util.Arrays;                   //调用排序函数sort()，需要引入包  java.util.Arrays;
public class Solution1 {
    public int MoreThanHalfNum_Solution(int [] array) {
        Arrays.sort(array);
        int count = 0;
        for (int i = 0;i < array.length;i++){
            if(array[i] == array[array.length / 2]){
                count++;
            }
        }
        if (count > array.length / 2){              //java中  9 / 2 = 4, 9.0 / 2 = 4.5
            return array[array.length / 2];
        }else{
            return 0;
        }
    }
}


public class Solution2 {
    public int MoreThanHalfNum_Solution(int [] array) {
        int target = array[0];
        int count = 1;
        for (int i = 1; i < array.length;i++){
            if (array[i] == target){
                count++;
            }else{
                count--;
                if(count == 0){
                    target = array[i];
                    count = 1;
                }
            }
        }
        count = 0;
        for (int i = 0;i < array.length;i++){
            if (array[i] == target){
                count++;
            }
        }
        if (count > array.length / 2){
            return target;
        }else{
            return 0;
        }
    }
}



import java.util.HashMap;  //用字典存储键值对，Java里字典过时了，用的是hashMap这个结构处理
import java.util.Map;
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        Map<Integer, Integer> count_num = new HashMap<Integer, Integer>(); //初始化Map,设定键值对均是整形
        for (int i  = 0;i < array.length;i++){
            if (count_num.containsKey(array[i])){                //Map.containsKey(key) 方法  判断是否包含key值
                int count = count_num.get(array[i]) + 1;         //Map.get(key) 方法  获取key对应的value
                count_num.put(array[i],count);                   //Map.put(key,value)向Map插入键值对
            }else{
                count_num.put(array[i],1);
            }
        }
        for (Integer key : count_num.keySet()) {                //遍历Map中的key值
            if(count_num.get(key) > array.length / 2){
                return key;
            }
        }
        return 0;
    }
}