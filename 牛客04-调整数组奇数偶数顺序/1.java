//解决方法1是用内存换时间  用两个数组按照原数组顺序分别存储奇数和偶数
public class Solution {
    public void reOrderArray(int [] array) {
        int[] odd = new int[array.length];
        int[] mea = new int[array.length];
        int m = 0;
        int n = 0;
        for (int i = 0;i < array.length;i++){
            if(array[i] % 2 == 1){
                odd[m++] = array[i];
            }else{
                mea[n++] = array[i];
            }
        }
        for (int i = 0;i < array.length;i++){
            if(i < m){
                array[i] = odd[i];
            }
            else{
                array[i] = mea[i - m];
            }
        }
    }
}


//解决方法2是不用其他数组，在原数组上进行元素位置互换操作，时间复杂度为N^2
public class Solution2 {
    public void reOrderArray(int [] array) {
        for (int i = 1;i < array.length;i++){
            for (int j = i;j > 0;j--){
                if(array[j] % 2 == 1 && array[j-1] % 2 == 0){
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }
}