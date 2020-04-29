public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length == 0) return false;
        if (sequence.length == 1) return true;
        int root = sequence[sequence.length - 1];
        int splitIndex = 0;
        for (;splitIndex < sequence.length - 1;splitIndex++){
            if (sequence[splitIndex] > root){
                break;
            }
        }
        for (int j = splitIndex;j < sequence.length - 1;j++){
            if (sequence[j] < root){
                return false;
            }
        }
        int[] left = new int[splitIndex];
        int[] right = new int[sequence.length - splitIndex - 1];
        for (int i = 0;i < splitIndex;i++){
            left[i] = sequence[i];
        }
        for (int i = 0;i < sequence.length - splitIndex - 1;i++){
            right[i] = sequence[i + splitIndex];
        }
        boolean leftTree = true;
        boolean rightTree = true;
        if (splitIndex > 0){
            leftTree = VerifySquenceOfBST(left);
        }
        if (sequence.length - splitIndex - 1 > 0){
            rightTree = VerifySquenceOfBST(right);
        }
        return leftTree && rightTree; 
    }
}