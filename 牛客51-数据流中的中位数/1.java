import java.util.ArrayList;
import java.util.Collections;
public class Solution {
    ArrayList<Integer> res = new ArrayList<Integer>();
    public void Insert(Integer num) {
        res.add(num);
    }

    public Double GetMedian() {
       Collections.sort(res);
        int length = res.size();
        if (length % 2 == 0){
            return (double)(res.get(length / 2 - 1) + res.get(length / 2)) / 2.0;
        }else{
            return (double)res.get(length / 2);
        }
    }


}

import java.util.PriorityQueue;  //优先队列是一种最小堆  可以通过重写comparator方法构造除最大堆
import java.util.Comparator;     //count为奇数时，把数字添加到左边，偶数时添加到右边
                                 //将数据流划分为两个部分，小的数字放在左边构造最大堆，大的数字放在右边构造最小堆
public class Solution {
    int count = 0;
    PriorityQueue<Integer> right = new PriorityQueue<Integer>();
    PriorityQueue<Integer> left = new PriorityQueue<>(new Comparator<Integer>(){
        @Override
        public int compare(Integer o1,Integer o2){
            return o2 - o1;
        }
    });

    public void Insert(Integer num) {
        count++;
        if ((count & 1) == 1){
            if (!right.isEmpty() && right.peek() < num){
                right.offer(num);
                num = right.poll();
            }
            left.offer(num);
        } else{
            if (!left.isEmpty() && left.peek() > num){
                left.offer(num);
                num = left.poll();
            }
            right.offer(num);
        }       
    }

    public Double GetMedian() {
        double res;
        if ((count & 1) == 1){
            res = left.peek();
            return res; 
        }else{
            res = (left.peek() + right.peek()) / 2.0;
            return res;
        }
    }
}














