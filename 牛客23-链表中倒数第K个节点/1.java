/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode temp = head;
        ListNode result = head;
        int count = 0;
        while(temp != null && count < k){
            temp = temp.next;
            count++;
        }       
        if (temp == null && count < k){
            return null;
        }
        while(temp != null){
            temp = temp.next;
            result = result.next;
        }
        return result;
    }
}