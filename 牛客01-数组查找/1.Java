public class Solution {
    public boolean Find(int target, int [][] array) {
        int row = array.length; 								//java中数组长度获取方法时  array.length
        int col = array[0].length;
        int i = 0;
        int j = col - 1;
        while((i < row - 1) && (j > -1)){
            if (target == array[i][j]){
                return true;
            }else if(target < array[i][j]){
                j = j - 1;
            }else{
                i = i + 1;
            }
        }
        return false;
    }
}