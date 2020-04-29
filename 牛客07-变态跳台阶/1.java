public class Solution1 {
    public int JumpFloorII(int target) {
        int Fibonacci_new[] = new int[target + 1];
        Fibonacci_new[0] = 1;
        Fibonacci_new[1] = 1;
        for (int i = 2; i < target + 1;i++){
            Fibonacci_new[i] = 2 * Fibonacci_new[i - 1];
        }
        return Fibonacci_new[target];
    }
}

public class Solution2 {
    public int JumpFloorII(int target) {
        return power(2,target - 1);
    }
    public static int power(int a , int b) {
    int power = 1;
    for (int c = 0; c < b; c++)
      power *= a;
    return power;
  }
}

public class Solution3 {
    public int JumpFloorII(int target) {
        if (target < 2){
            return target;
        }else{
            return 2 * JumpFloorII(target - 1);
        }
            
    }
}