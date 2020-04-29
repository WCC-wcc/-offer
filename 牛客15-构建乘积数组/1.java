import java.util.ArrayList;
public class Solution1 {
    public int[] multiply(int[] A) {
        int sum1 = 1;
        int[] B1 = new int[A.length];
        for (int i = 0;i < A.length;i++){
            B1[i] = sum1;
            sum1 *= A[i];
        }
        int sum2 = 1;
        int[] B2 = new int[A.length];
        for (int j = A.length - 1;j >= 0;j--){
            B2[j] = sum2;
            sum2 *= A[j];
        }
        int[] B = new int[A.length];
        for (int i = 0;i < A.length;i++){
            B[i] = B1[i] * B2[i];
        }
        return B;
    }
}


import java.util.ArrayList;
public class Solution2 {
    public int[] multiply(int[] A) {
        int sum = 1;
        int[] B = new int[A.length];
        for (int i = 0;i < A.length;i++){
            B[i] = sum;
            sum *= A[i];
        }
        sum = 1;
        for (int j = A.length - 1;j >= 0;j--){
            B[j] *= sum;
            sum *= A[j];
        }
        return B;
    }
}