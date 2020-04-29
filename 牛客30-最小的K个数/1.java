import java.util.ArrayList;
import java.util.Arrays;
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (input.length == 0 || k > input.length){
            return result;
        }else{
            Arrays.sort(input);
            for (int i = 0;i < k;i++){
                result.add(input[i]);
            }
            return result;
        }
    }
}




import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (input.length == 0 || k > input.length){
            return result;
        }else{
            bubbleSort(input);
            for (int i = 0;i < k;i++){
                result.add(input[i]);
            }
            return result;
        }
    }
    public void bubbleSort(int[] array){
        for (int i = 0;i < array.length - 1;i++){
            for (int j = 0;j < array.length - i - 1;j++){
                if (array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}



import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (input.length == 0 || k > input.length){
            return result;
        }else{
            selectSort(input);
            for (int i = 0;i < k;i++){
                result.add(input[i]);
            }
            return result;
        }
    }
    public void selectSort(int[] array){
        for (int i = 0;i < array.length - 1;i++){
            int min = i; 
            for (int j = i;j < array.length;j++){
                if (array[j] < array[min]){
                    min = j;
                }
            }
            if (min != i){
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
    }
}




import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (input.length == 0 || k > input.length){
            return result;
        }else{
            insertSort(input);
            for (int i = 0;i < k;i++){
                result.add(input[i]);
            }
            return result;
        }
    }
    public void insertSort(int[] array){
        for (int i = 0;i < array.length;i++){
            for (int j = i;j > 0;j--){
                if (array[j] < array[j - 1]){
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }
}



import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (input.length == 0 || k > input.length){
            return result;
        }else{
            shellSort(input);
            for (int i = 0;i < k;i++){
                result.add(input[i]);
            }
            return result;
        }
    }
    public void shellSort(int[] array){
        int gap = array.length >> 1;
        while(gap > 0){
            for (int i = gap;i < array.length;i++){
                int temp = array[i];
                int j = i - gap;
                while(j >= 0 && array[j] > temp){
                    array[j + gap] = array[j];
                    j -= gap;
                }
                array[j + gap] = temp;
            }
            gap >>= 1;
        }
    }
}




import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (input.length == 0 || k > input.length){
            return result;
        }else{
            quickSort(input,0,input.length - 1);
            for (int i = 0;i < k;i++){
                result.add(input[i]);
            }
            return result;
        }
    }
    public void quickSort(int[] array,int left,int right){
        if (left < right){
            int low = left;
            int high = right;
            int temp = array[left];
            while(low != high){
                while(high != low && array[high] >= temp){
                    high--;
                }
                array[low] = array[high];
                while(low != high && array[low] <= temp){
                    low++;
                }
                array[high] = array[low];
            }
            array[low] = temp;
            quickSort(array,0,low - 1);
            quickSort(array,low + 1,right);
        }
    }
}





import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (input.length == 0 || k > input.length){
            return result;
        }else{
            heapSort(input,input.length);
            for (int i = 0;i < k;i++){
                result.add(input[i]);
            }
            return result;
        }
    }
    public void swap(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public void createHeap(int[] array,int length){
        int lastParent = (array.length >> 1) - 1;
        for (int i = lastParent;i >= 0;i--){
            adjustHeap(array,i,array.length);
        }
    }
    public void adjustHeap(int[] array,int adjustNode,int size){
        int child = (adjustNode << 1) + 1;
        while(child < size){
            if (child + 1 < size && array[child + 1] > array[child]){
                child++;
            }
            if (array[child] > array[adjustNode]){
                swap(array,child,adjustNode);
                adjustNode = child;
                child = (adjustNode << 1) + 1;
            }else{
                break;
            }
        }
    }
    public void heapSort(int[] array,int length){
        createHeap(array,array.length);
        for (int i = array.length - 1;i > 0;i--){
            swap(array,0,i);
            adjustHeap(array,0,i);
        }
    }
}






import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (input.length == 0 || k > input.length){
            return result;
        }else{
            int[] temp = new int[input.length];
            mergeSort(input,temp,0,input.length - 1);
            for (int i = 0;i < k;i++){
                result.add(input[i]);
            }
            return result;
        }
    }
    public void mergeSort(int[] array,int[] temp,int left,int right){
        if (left < right){
            int mid = (left + right) >> 1;
            mergeSort(array,temp,left,mid);
            mergeSort(array,temp,mid + 1,right);
            Merge(array,temp,left,mid,right);
        }
    }
    public void Merge(int[] array,int[] temp,int left,int mid,int right){
        int i = left;
        int j = mid + 1;
        int k = left;
        while(i <= mid && j <= right){
            if (array[i] <= array[j]){
                temp[k++] = array[i++];
            }else{
                temp[k++] = array[j++];
            }
        }
        while(i <= mid){
            temp[k++] = array[i++];
        }
        while(j <= right){
            temp[k++] = array[j++];
        }
        for (;left <= right;left++){
            array[left] = temp[left];
        }
    }
}