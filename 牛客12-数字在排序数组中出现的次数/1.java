public class Solution1 {
    public int GetNumberOfK(int [] array , int k) {
       int count = 0;
       for (int i = 0;i < array.length;i++){
           if (array[i] == k){
               count++;
           }
       }
        return count;
    }
}


public class Solution2 {     //二分查找   注意begin end mid更新，边界值确定
    public int BinSearch(int[] array,double k){         //BinSearch 返回的是数组中大于k的第一个数的索引
        int begin = 0;
        int end = array.length;
        int mid = (begin + end) / 2;
        while (begin != end){
            if (array[mid] > k){
                end = mid;
                mid = (begin + end) / 2;
            }else{
                begin = mid + 1;
                mid = (begin + end) / 2;
            }
        }
        return mid;
    }
    
    public int GetNumberOfK(int [] array , int k) {
        int first = BinSearch(array,k + 0.5);   //这里输入 k + 0.5 返回的是大于k的第一个数的索引
        int last = BinSearch(array,k - 0.5);	//这里输入 k - 0.5 返回的是等于k的第一个数的索引
       return  first - last ;
    }
}