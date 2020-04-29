//暴力解法    遍历数组找到最小值
import java.util.ArrayList;
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0){
            return 0;
        }
        int min = array[0];
        for (int i = 1;i < array.length;i++){
            
            if (array[i] < min){
                min = array[i];
            }
        }
        return min;
    }
}

//遍历数组   找到转折点
import java.util.ArrayList;
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0){
            return 0;
        }
        int result = 0;
        for (int i = 0;i < array.length;i++){
            if (array[i] > array[i + 1]){
                result = array[i + 1];
                break;
            }
        }
        return result;
    }
}

//调用函数min()直接返回最小值
import java.util.ArrayList;
import java.util.Arrays;                                //导入Arrays包才能使用Arrays.sort(array);
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0){
            return 0;
        }
        int[] a = int[]{1,3,5,7};                      //数组定义并且直接赋值方式
        int[] a = {1,3,5,7};
        Arrays.sort(array);                            //对输入数组做了改变
        return array[0];
    }
}


//二分查找  找到最小值
import java.util.ArrayList;
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0){
            return 0;
        }
        int left = 0;
        int right = array.length - 1;
        int mid = 0;
        int result = 0;
        while(left != right){
            mid = left + (right - left) / 2;
            if (array[mid] < array[right]){
                right = mid;
            }else if(array[mid] > array[right]){
                left = mid + 1;
            }else{
                result = array[mid];
                return result;
            }
        }
        return array[left];
    }
}
