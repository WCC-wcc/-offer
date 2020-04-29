public class Solution1 {
    public int RectCover(int target) {
        if(target < 3){
            return target;
        }else{
            int first = 1;
            int second = 2;
            int i = 3;
            while(i <= target){
                second = first + second;
                first = second - first;
                i++;
            }
            return second;
        }
    }
}

public class Solution2 {
    public int RectCover(int target) {
        if(target < 3){
            return target;
        }else{
            int first = 1;
            int second = 2;
            int sum = 0;
            int i = 3;
            while(i <= target){
                sum = first + second;
                first = second;
                second = sum;
                i++;
            }
            return sum;
        }
    }
}


public class Solution3 {
    public int RectCover(int target) {
        if(target < 3){
            return target;
        }else{
            int Fibonacci[] = new int[target + 1];
            Fibonacci[0] = 0;
            Fibonacci[1] = 1;
            Fibonacci[2] = 2;
            for (int i = 3;i <= target;i++){
                Fibonacci[i] = Fibonacci[i -1] + Fibonacci[i - 2];
            }
            return Fibonacci[target];
        }
    }
}

public class Solution4 {
    public int RectCover(int target) {
        if(target < 3){
            return target;
        }else{
            return RectCover(target - 1) + RectCover(target - 2);
        }
    }
}