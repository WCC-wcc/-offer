//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
import java.util.Arrays;
import java.util.ArrayList;
public class Solution1 {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        Arrays.sort(array);                                  //Arraylist 和 Array区别
        ArrayList<Integer> temp = new ArrayList<Integer>();  //前者是动态的，初始化不用指定大小，元素类型，后者相反
        if (array[0] != array[1]){      //Arraylist.add(element) Arraylist.add(index,element) 
            temp.add(array[0]);         //Arraylist.remove(index) 
        }                               //arrayList.set(index,element);arrayList.indexOf(element); 
        if(array[array.length -1] != array[array.length -2]){  //ArrayList.contains()ArrayList.subList(1, 3);
            temp.add(array[array.length -1]); //ArrayList.size()
        }
        
        for(int i = 1; i < array.length - 1;i++){
            if(array[i] != array[i - 1] && array[i] != array[i + 1]){
                temp.add(array[i]);
            }
        }
        num1[0] = temp.get(0);
        num2[0] = temp.get(1);
    }
}


//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
import java.util.ArrayList;
public class Solution2 {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0;i < array.length;i++){
            for (int j = 0;j < array.length;j++){
                if(array[i] == array[j] && i != j){
                    break;
                }
                if(j == array.length - 1){
                    result.add(array[i]);
                }
            }
        }
        num1[0] = result.get(0);
        num2[0] = result.get(1);
    }
}

//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
public class Solution3 {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        Map<Integer,Integer> result = new HashMap<Integer,Integer>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for (int i = 0;i < array.length;i++){
            if (result.containsKey(array[i])){
                int count = result.get(array[i]) + 1;
                result.put(array[i],count);
            }else{
                result.put(array[i],1);
            }
        }
        for (Integer key : result.keySet()){
            if (result.get(key) == 1){
                temp.add(key);
            }
        }
        num1[0] = temp.get(0);
        num2[0] = temp.get(1);
    }
}


//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
import java.util.ArrayList;
public class Solution4 {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i = 0;i < array.length;i++){
            if (result.contains(array[i])){
                int index = result.indexOf(array[i]);
                result.remove(index);
            }else{
                result.add(array[i]);
            }
        }
        num1[0] = result.get(0);
        num2[0] = result.get(1);
    }
}


//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class Solution5 {
    public int FindFirstIndexOfOne(int num){
        int index = 0;
        while(index < 32 && (num & 1) == 0){
            index++;
            num >>= 1;
        }
        return index;
    }
     public boolean BitFind(int index,int num){
        num >>= index;
        if((num & 1) == 1){
            return true;
        }else{
            return false;
        }
    }
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int sum = 0;
        for (int i = 0;i < array.length;i++){
            sum ^= array[i];
        }
        int first_index = FindFirstIndexOfOne(sum);
        for (int i = 0;i < array.length;i++){
            if (BitFind(first_index,array[i])){
                num1[0] ^= array[i];
            }else{
                num2[0] ^= array[i];
            }
        }
    }
}