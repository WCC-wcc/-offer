import java.util.Stack;

public class Solution {

    public static Stack<Integer> stack = new Stack<Integer>();    //初始化两个栈变量
    public static Stack<Integer> minStack = new Stack<Integer>(); //用辅助栈保存实时的最小值，使得min()复杂度O(1)
    
    public void push(int node) {
        stack.push(node);
        if (!minStack.empty() && minStack.peek() <= node){
            minStack.push(minStack.peek());
        }else{
            minStack.push(node);
        }
    }
    
    public void pop() {
        if (!stack.empty()){
            stack.pop();
            minStack.pop();
        }
    }
    
    public int top() {
        if (!stack.empty()){
            return stack.peek();
        }
        return 0;
    }
    
    public int min() {
        if(!minStack.empty()){
            return minStack.peek();
        }
        return 0;
    }
}