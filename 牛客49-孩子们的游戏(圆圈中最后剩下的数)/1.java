public class Solution {

    public class ListNode{
        int val;
        ListNode next = null;
        ListNode(int val){
            this.val = val;
        }
    }

    public int LastRemaining_Solution(int n, int m) {
        if (n <= 0 || m < 0) return -1;
        ListNode circle = new ListNode(0);
        ListNode node = circle;
        for (int i = 1;i < n;i++){
            node.next = new ListNode(i);
            node = node.next;
        }
        node.next = circle;
        int count = 0;
        while(node.next != node){
            if (count == (m - 1)){
                node.next = node.next.next;
                count = 0;
            }else{
                count++;
                node = node.next;
            }
        }
        return node.val;
    }
}


import java.util.ArrayList;
public class Solution {
    public int LastRemaining_Solution(int n, int m) {
        if (n <= 0 || m < 0) return -1;
        int index = 0;
        int count = 0;
        int active = n;
        ArrayList<Integer> circle = new ArrayList<Integer>();
        for (int i = 0;i < n;i++){
            circle.add(i);
        }
        while(active > 1){
            if (count == m - 1){
                circle.set(index,-1);
                active--;
                count = 0;
                index = (index + 1) % n;
                while(circle.get(index) == -1)  index = (index + 1) % n;
            }
            else{
                count++;
                index = (index + 1) % n;
                while(circle.get(index) == -1)  index = (index + 1) % n;
            }
        }      
        return index;  
    }
}


public class Solution {
    public int LastRemaining_Solution(int n, int m) {
        if (n <= 0 || m < 0) return -1;
        if (n == 1) return 0;
        else return (LastRemaining_Solution(n-1,m) + m) % n;
    }
}