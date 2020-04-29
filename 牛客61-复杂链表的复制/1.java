/*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
*/
public class Solution {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if (pHead == null) return null;
        RandomListNode target = new RandomListNode(pHead.label);
        RandomListNode node = target;
        RandomListNode cur = pHead;
        while(cur != null){
            if (cur.next == null) node.next = null;
            else node.next = new RandomListNode(cur.next.label);

            if (cur.random == null) node.random = null;
            else node.random = new RandomListNode(cur.random.label);

            node = node.next;
            cur = cur.next;
        }
        return target;
    }
}