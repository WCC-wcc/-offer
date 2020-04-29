public class Solution {
    public int JumpFloor(int target) {
        if(target < 4){
            return target;
        }
        else{
            return JumpFloor(target - 1) + JumpFloor(target - 2);
        }
    }
}

public class Solution {
    public int JumpFloor(int target) {
        if(target < 4){
            return target;
        }
        else{
            int Fibonacci[] = new int[target + 1];
            Fibonacci[0] = 0;
            Fibonacci[1] = 1;
            Fibonacci[2] = 2;
            for (int i = 3;i < target + 1;i++){
                Fibonacci[i] = Fibonacci[i - 1] + Fibonacci[i - 2];
            }
            return Fibonacci[target];
        }
    }
}

public class Solution {
    public int JumpFloor(int target) {
        if(target < 4){
            return target;
        }
        else{
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