public class Solution1 {								//利用数组优化时间
    public int Fibonacci(int n) {
        int[] Fibonacci = new int[40];
        Fibonacci[0] = 0;
        Fibonacci[1] = 1;
        for (int i = 2 ;i < n + 1;i++){
            Fibonacci[i] = Fibonacci[i - 1] + Fibonacci[i - 2];
        }
        return Fibonacci[n];
    }
}

public class Solution2 {								//利用三个变量优化内存
    public int Fibonacci(int n) {
        if(n < 2){
            return n;
        }else{
            int first = 0;
            int second = 1;
            int i = 2;
            int sum = 0;
            while(i <= n){
                sum = first + second;
                first = second;
                second = sum;
                i++;
            }
            return sum;
        }
    }
}

public class Solution3 {							//利用两个变量优化内存
    public int Fibonacci(int n) {
        if(n < 2){
            return n;
        }else{
            int first = 0;
            int second = 1;
            int i = 2;
            while(i <= n){
                second = first + second;
                first = second - first;
                i++;
            }
            return second;
        }
    }
}


public class Solution4 {						//最简单迭代
    public int Fibonacci(int n) {
        if(n < 2){
            return n;
        }else{
           return Fibonacci(n - 1) + Fibonacci(n - 2);
        }
    }
}