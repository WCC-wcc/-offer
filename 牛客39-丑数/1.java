public class Solution {
    public int GetUglyNumber_Solution(int index) {
        if(index < 1){
            return 0;
        }        
        int[] res = new int[index];
        res[0] = 1;
        int nodeTwo = 0;
        int nodeThree = 0;
        int nodeFive = 0;
        for (int i = 1;i < index;i++){
            res[i] = Math.min(res[nodeTwo] * 2,Math.min(res[nodeThree] * 3,res[nodeFive] * 5));
            if (res[i] == res[nodeTwo] * 2) nodeTwo++;  //这里三个if，而不是if  else  是为了跳过重复数字2*3 3*2
            if (res[i] == res[nodeThree] * 3) nodeThree++;
            if (res[i] == res[nodeFive] * 5) nodeFive++;
        }
        return res[index - 1];
    }
}