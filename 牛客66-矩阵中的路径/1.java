public class Solution {

    public boolean findPath(char[] matrix, int rows, int cols, char[] str,int i,int j,int[][] flag,int index){
        if (str.length == index) return true;
        if (i < 0 || i >= rows || j < 0 || j >= cols) return false;
        if (flag[i][j] == 1) return false;
        if (matrix[i * cols + j] != str[index]) return false;
        else{
            flag[i][j] = 1;
            return  findPath(matrix,rows,cols,str,i - 1,j,flag,index + 1) ||
                    findPath(matrix,rows,cols,str,i + 1,j,flag,index + 1) ||
                    findPath(matrix,rows,cols,str,i,j - 1,flag,index + 1) ||
                    findPath(matrix,rows,cols,str,i,j + 1,flag,index + 1);
        }
    }

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        for (int i = 0;i < rows;i++){
            for (int j = 0; j < cols;j++){
                int[][] flag = new int[rows][cols];
                if (findPath(matrix,rows,cols,str,i,j,flag,0)) return true;
            }
        }
        return false;
    }
}