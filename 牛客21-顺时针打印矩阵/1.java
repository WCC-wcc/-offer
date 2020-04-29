import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        ArrayList temp = new ArrayList();
        recursive(0,m,0,n,matrix,temp,0,0);
        return temp;
    }
    public void recursive(int i_top,int i_bottom,int j_left,int j_right,int[][] matrix,ArrayList temp,int i,int j){
        if (temp.size() == (matrix.length * matrix[0].length)){
            return ;
        }else if(i == i_top){
            for (int k = j_left;k < j_right;k++){
                temp.add(matrix[i][k]);
            }
            recursive(i_top + 1,i_bottom,j_left,j_right,matrix,temp,i,j_right);
        }else if(j == j_right){
            for (int k = i_top;k < i_bottom;k++){
                temp.add(matrix[k][j - 1]);
            }
            recursive(i_top,i_bottom,j_left,j_right - 1,matrix,temp,i_bottom,j);
        }else if(i == i_bottom){
            for (int k = j_right - 1;k > j_left - 1;k--){
                temp.add(matrix[i - 1][k]);
            }
            recursive(i_top,i_bottom - 1,j_left,j_right,matrix,temp,i,j_left);
        }else if(j == j_left){
            for (int k = i_bottom - 1;k > i_top -1;k--){
                temp.add(matrix[k][j]);
            }
            recursive(i_top,i_bottom,j_left + 1,j_right,matrix,temp,i_top,j);
        }
    }
}