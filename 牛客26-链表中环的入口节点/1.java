/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
import java.util.Set;
import java.util.HashSet;
public class Solution {

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        Set<ListNode> s = new HashSet<ListNode>();          //采用集合   注意   set.add()  set.contains()方法
        while(pHead != null && !s.contains(pHead)){
            s.add(pHead);
            pHead = pHead.next;
        }
        return pHead;
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
import java.util.HashMap;
public class Solution { 								//用HashMap做  同样方法
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        HashMap<ListNode,Integer> m = new HashMap<ListNode,Integer>();
        while(pHead != null){
            if (m.get(pHead) != null){
                return pHead;
            }else{
                m.put(pHead,1);
                pHead = pHead.next;
            }
        }
        return null;
    }
}



// set.add() set.contains(key) set.indexOf(key)  set.remove(index) 
// map.put(key,value) map.get(key)



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

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        ListNode fastNode = pHead;
        ListNode slowNode = pHead;
        while(fastNode != null && fastNode.next != null){
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
            if(fastNode == slowNode){
                fastNode = pHead;
                while(fastNode != slowNode){
                    fastNode = fastNode.next;
                    slowNode = slowNode.next;
                }
                return slowNode;
            }
        }
        return null;
    }
}