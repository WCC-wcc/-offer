public class Solution1 {                              //双循环可以解决问题  但是耗时严重    牛客网会判定超时
    public int InversePairs(int [] array) {
        int count = 0;
        for (int i = 0;i < array.length - 1;i++){
            for (int j = i + 1;j < array.length;j++){
                if (array[i] > array[j]){
                    count++;
                }
            }
        }
        return count % 1000000007;
    }
}


public class Solution2 {                      // 归并排序  这种写法  内存不太友好  不是原地排序
    public int count = 0;
    public int [] MergeSort(int [] array){
        if (array.length <= 1){
            return array;
        }else{
            int[] left_array = new int[array.length / 2];
            int[] right_array = new int[array.length - left_array.length]; 
            for (int i = 0;i < left_array.length;i++){
                left_array[i] = array[i];
            }
            for (int j = 0;j < right_array.length;j++){
                right_array[j] = array[j + array.length / 2];
            }
            left_array = MergeSort(left_array);
            right_array = MergeSort(right_array);
            int [] result = new int [array.length];
            result = Merge(left_array,right_array);
            return result;
        }
    }
    
    public int[] Merge(int [] left_array,int [] right_array){
        int []result = new int[left_array.length + right_array.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < left_array.length && j < right_array.length){
            if (left_array[i] <= right_array[j]){
                result[k++] = left_array[i++];
            }else{
                result[k++] = right_array[j++];
                count += left_array.length - i;
                count = count % 1000000007; 			//牛客网报错就是这个地方数字太大导致的
            }
        }
        while( i < left_array.length){
            result[k++] = left_array[i++];
        }
        while( j < right_array.length){
            result[k++] = right_array[j++];
        }
//        System.out.println(Arrays.toString(result));
        return result;
    }
    
    
    public int InversePairs(int [] array) {
        MergeSort(array);
        return count % 1000000007;
    }
}










public class Solution3 { 				//归并排序   原地排序  内存友好
        int count = 0; 
        public  void MergeSort(int[] array,int[] temp,int left,int right){
            if(left < right){
                int mid = (left + right) / 2;
                MergeSort(array,temp,left,mid);
                MergeSort(array,temp,mid + 1,right);
                Merge(array,temp,left,mid,right);
            }
        }
        public  void Merge(int[] array,int[] temp,int left,int mid,int right){
            int i = left;
            int j = mid + 1;
            int k = left;
            while(i <= mid && j <= right){
                if(array[i] <= array[j]){
                    temp[k++] = array[i++];
                }else{
                    temp[k++] = array[j++];
                    count += mid - i + 1;
                    if(count > 1000000007){
                        count = count % 1000000007;
                    }
                }
            }
            while(i <= mid){
                temp[k++] = array[i++];
            }
            while(j <= right){
                temp[k++] = array[j++];
            }
            while(left <= right){
                array[left] = temp[left];
                left++;
            }
        }
        public int InversePairs(int [] array) {
            int[] temp = new int[array.length];
            MergeSort(array,temp,0,array.length - 1);
            return count % 1000000007;
        }
}