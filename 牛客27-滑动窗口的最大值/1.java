import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        int length = num.length - size + 1;
        ArrayList<Integer> maxInWindow = new ArrayList<Integer>();
        if (size == 0){
            return maxInWindow;
        }else{
            for(int i = 0; i < length;i++){
               int max = num[i]; 
               for(int j = i; j < i + size;j++){
                   if (max < num[j]){
                       max = num[j];
                   }
               }
               maxInWindow.add(max);
            }
            return maxInWindow;
        }
    }
}



// Deque --> double  ended queue  双端队列  可以在队列两端进行插入删除操作
// 继承关系： Deque-->queue-->Collection-->Iterable
// 实现方法： Deque<Type> deque = new LinkedList<Type>();      大小可变的链表双端队列，允许元素为 null
//           Deque<Type> deque = new ArrayDeque<Type>();      大小可变的数组双端队列， 不允许元素为 null

// deque.add() deque.addFirst() deque.addLast()    数组容量没有限制
// deque.offer() deque.offerFirst() deque.offerLast()  数组容量有限制
// deque.remove() deque.removeFirst() deque.removeLast()  为空报错
// deque.poll()  deque.pollFirst()    deque.pollLast()    为空返回null
// deque.get() deque.getFirst() deque.getLast()  为空报错
// deque.peek()  deque.peekFirst()    deque.peekLast()    为空返回null

import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;
public class Solution {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Deque<Integer> temp = new ArrayDeque<Integer>();
        for (int i = 0;i < num.length;i++){
          int flag = i - size + 1;
          while(!temp.isEmpty() && num[i] >= num[temp.peekLast()]){
            temp.pollLast();
          }
          while(!temp.isEmpty() && temp.peekFirst() < flag){
            temp.pollFirst();
          }
          temp.add(i);
          if (flag >= 0 && size > 0){
            result.add(num[temp.peekFirst()]);
          }
        }
        return result;
    }
}