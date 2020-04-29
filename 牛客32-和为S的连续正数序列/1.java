import java.util.ArrayList;
public class Solution {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
       ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
       int first = 1;
       int last = 2;
       int currSum = first;
       int tag = (sum >> 1) + 1;
       while (last <= tag){
        currSum += last;
        if(currSum == sum){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for (int i = first;i <= last;i++){
                temp.add(i);
            }
            res.add(temp);
            last++;
        }else if (currSum < sum){
            last++;
        }else{
            currSum -= first;
            first++;
            currSum -= last;
        }
       }
       return res;
    }
}




import java.util.ArrayList;
public class Solution {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
       ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
       int mid = (sum + 1) >> 1;
       for (int i = 1;i <= mid;i++){
        int currSum = i;
        for (int j = i + 1;j <= mid;j++){
            currSum += j;
            if (currSum == sum){
                ArrayList<Integer> temp = new ArrayList<Integer>();
                for (int k = i;k <= j;k++){
                    temp.add(k);
                }
                res.add(temp);
            }
        }
       }
       return res;
    }
}


import java.util.ArrayList;
public class Solution {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        int stop = (int)Math.sqrt(2 * sum);
        for (int n = stop;n > 1;n--){
            if ((n & 1) == 1 && (sum % n == 0) || (sum % n * 2 == n)){
                ArrayList<Integer> temp = new ArrayList<Integer>();
                int begin = sum / n - (n - 1) / 2;
                int first = begin;
                while(first < begin + n){
                    temp.add(first);
                    first++;
                }
                res.add(temp);
            }
        }
        return res;
    }
}
