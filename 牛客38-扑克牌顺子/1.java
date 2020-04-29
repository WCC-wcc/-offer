import java.util.Arrays;          //整体思路就是先排序，统计0个数，统计其他元素重复情况  计算max-min
public class Solution {
    public boolean isContinuous(int [] numbers) {
        if (numbers.length < 5){
            return false;
        }
        Arrays.sort(numbers);
        int count0 = 0;
        for (int i = 0; i < 5;i++){
            if (numbers[i] == 0){
                count0++;
            }
        }
        if (count0 == 4) return true;
        if (count0 == 3){
            int temp = numbers[4] - numbers[3];
            if (temp > 0 && temp < 5) return true;
        }
        if (count0 == 2){
            if (numbers[3] != numbers[2] && numbers[3] != numbers[4]){
                int temp = numbers[4] - numbers[2];
                if (temp > 1 && temp < 5) return true;
            }
        }
        if (count0 == 1){
            if (numbers[1] != numbers[2] && numbers[2] != numbers[3] &&numbers[3] != numbers[4]){
                int temp = numbers[4] - numbers[1];
                if (temp > 2 && temp < 5) return true;
            }
        }
        if (count0 == 0){
            if (numbers[0] != numbers[1] && numbers[1] != numbers[2] && numbers[2] != numbers[3]&& numbers[3] != numbers[4]){
                int temp = numbers[4] - numbers[0];
                if (temp == 4) return true;
            }
        }
        return false;
    }
}



import java.util.Set;            //HashSet无序集合
import java.util.TreeSet;        //TreeSet有序集合   无重复元素
public class Solution {                             //统计0的个数，和除0外的非重复元素     二者总数等于5   
    public boolean isContinuous(int [] numbers) {   //并且对后者排序后,max-min < 5
        if (numbers.length != 5){
            return false;
        }
        TreeSet<Integer> temp = new TreeSet<Integer>();
        int count0 = 0;
        for (int i = 0;i < 5;i++){
            if (numbers[i] == 0){
                count0++;
            }else{
                temp.add(numbers[i]);
            }
        }
        if (count0 + temp.size() == 5){
            if (temp.last() - temp.first() < 5){
                return true;
            }
        }
        return false;
    }
}