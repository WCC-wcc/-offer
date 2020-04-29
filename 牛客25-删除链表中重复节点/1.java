/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {
    public ListNode deleteDuplication(ListNode pHead)
    {
        if (pHead == null || pHead.next == null){
            return pHead;
        }
        ListNode p = new ListNode(0);
        ListNode result = p;
        ListNode pre = pHead;
        ListNode curr = pHead.next;
        while(curr != null){
            if (pre.val == curr.val){
                if (curr.next == null){
                    p.next = null;
                    return result.next;
                }
                pre = curr.next;
                curr = pre.next;
            }
            else{
                p.next = pre;
                p = p.next;
                pre = curr;
                curr = curr.next;
            }
        }
        if (curr == null && pHead.val == pre.val){
            p.next = null;
            return result.next;
        }else{
            p.next = pre;
            return result.next;
        }
    }
}



/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {
    public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead == null || pHead.next == null){
            return pHead;
        }
        ListNode result = new ListNode(0);
        ListNode temp = result;
        while(pHead != null && pHead.next != null){
            if (pHead.val == pHead.next.val){
                int val = pHead.val;
                pHead = pHead.next;
                while (pHead != null && pHead.val == val){
                    pHead = pHead.next;
                }
            }else{
                temp.next = pHead;
                temp = temp.next;
                pHead = pHead.next;
            }
        }
        if (pHead != null){
            temp.next = pHead;
            temp = temp.next;
        }
        temp.next = null;
        return result.next;
    }
}



/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {
    public ListNode deleteDuplication(ListNode pHead)
    {
        if (pHead == null || pHead.next == null){
            return pHead;
        }
        ListNode result = new ListNode(0);
        if (pHead.val != pHead.next.val){
            result.next = pHead;
            result.next.next = deleteDuplication(pHead.next);
        }else{
            int val = pHead.val;
            while(pHead != null && pHead.val == val){
                pHead = pHead.next;
            }
            result.next = deleteDuplication(pHead);
        }
        return result.next;
    }
}
