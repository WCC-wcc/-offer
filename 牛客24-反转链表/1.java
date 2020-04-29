/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode aft = head.next.next;
        pre.next = null;                         //注意处理首节点，指向null
        while (aft != null){
            cur.next = pre;
            pre = cur;
            cur = aft;
            aft = aft.next;
        }
        cur.next = pre;
        return cur;
    }
}