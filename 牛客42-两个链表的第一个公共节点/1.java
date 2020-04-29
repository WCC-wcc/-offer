/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode shortNode = pHead1;
        ListNode longNode = pHead2;
        while(shortNode != longNode){
            if (shortNode != null){
                shortNode = shortNode.next;
            }else{
                shortNode = pHead2;
            }

            if (longNode != null){
                longNode = longNode.next;
            }else{
                longNode = pHead1;
            }
        }
        return shortNode;
    }
}


import java.util.ArrayList;
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ArrayList<ListNode> nodeTemp1 = new ArrayList<ListNode>();    
        ArrayList<ListNode> nodeTemp2 = new ArrayList<ListNode>();
        while(pHead1 != null){
            nodeTemp1.add(pHead1);
            pHead1 = pHead1.next;
        }
        while(pHead2 != null){
            nodeTemp2.add(pHead2);
            pHead2 = pHead2.next;
        }
        for (ListNode node1 : nodeTemp1){
            for (ListNode node2 : nodeTemp2 ) {
                if (node1 == node2){
                    return node1;
                }
            }
        }
        return null;
    }
}



jdk 1.5新特性：增强for循环      for(Type name : Object){
                                    ;
                                }
