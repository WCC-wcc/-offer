public class Solution1 {
    public int FindGreatestSumOfSubArray(int[] array) {
        int sum = 0;
        int max_sum = -1;
        for (int i = 0;i < array.length;i++){
            sum += array[i];
            if(sum > max_sum){
                max_sum = sum;
            }
            if(sum < 0){
                sum = 0;
            }
        }
        return max_sum;
    }
}


public class Solution2 {
    public int FindGreatestSumOfSubArray(int[] array) {
        int sum = 0;
        int max_sum = -1;
        for (int i = 0;i < array.length;i++){
            sum += array[i];
            if(sum < array[i]){
                sum = array[i];
            }
            if(sum > max_sum){
                max_sum = sum;
            }
        }
        return max_sum;
    }
}

