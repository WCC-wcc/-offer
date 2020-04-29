/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode list = new ListNode(0);
        ListNode temp = list;
        while (list1 != null && list2 != null){
            if (list1.val <= list2.val){
                temp.next = list1;
                list1 = list1.next;
            }else{
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        if (list1 != null){
            temp.next = list1;
        }
        if (list2 != null){
            temp.next = list2;
        }
        return list.next;
    }
}


public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode list = new ListNode(0);
        if (list1 == null){
            return list2;
        }
        else if (list2 == null){
            return list1;
        }
        else if (list1.val <= list2.val){
            list = list1;
            list.next = Merge(list1.next,list2);
        }else{
            list = list2;
            list.next = Merge(list1,list2.next);
        }
        return list;
    }
}