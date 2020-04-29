import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
      Stack<Integer> stack = new Stack<Integer>();
      int j = 0;
      for (int i = 0;i < pushA.length;i++){
        stack.push(pushA[i]);
        while(!stack.empty() && stack.peek() == popA[j]){
            stack.pop();
            j++;
        }
      }
        if (stack.empty()) return true;
        else return false;
    }
}