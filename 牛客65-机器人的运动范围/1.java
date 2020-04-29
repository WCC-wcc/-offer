public class Solution {
    int count = 0;

    public boolean pass(int i,int j,int k){
        int sum = 0;
        while (i != 0){
            sum += i % 10;
            i /= 10;
        }
        while (j != 0){
            sum += j % 10;
            j /= 10;
        }
        return sum > k;
    }

    public void move(int threshold, int rows, int cols,int i,int j,int[][] matrix){
        if (i < 0 || i >= cols || j < 0 || j >= rows) return ;
        if (matrix[i][j] == 1) return ;
        if (pass(i,j,threshold)){
            matrix[i][j] = 1;
            return ;
        }
        count++;
        matrix[i][j] = 1;
        move(threshold,rows,cols,i - 1,j,matrix);
        move(threshold,rows,cols,i + 1,j,matrix);
        move(threshold,rows,cols,i,j - 1,matrix);
        move(threshold,rows,cols,i,j + 1,matrix);
    }

    public int movingCount(int threshold, int rows, int cols)
    {
        if (threshold < 0 || rows < 0 || cols < 0) return 0;
        int[][] matrix = new int[cols][rows];
        move(threshold,rows,cols,0,0,matrix);
        return count;
    }
}