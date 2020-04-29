/**
*    public class ListNode {
*        int val;
*        ListNode next = null;
*
*        ListNode(int val) {
*            this.val = val;
*        }
*    }
*
*/

//简单方法是在从头到尾遍历链表时，依次把数据添加到list中，但是调用list.add(index,element)方法，
//每次把数据添加到表头，这样就可以，保证顺序从尾到头
//这个方法不好

import java.util.ArrayList;
public class Solution1 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (listNode != null){
            list.add(0,listNode.val);  
            listNode = listNode.next;   
        }
        return list;
    }
}

//第二种解法就是很直观的想到栈这个数据结构，先进后出。调用push(),pop()方法即可
import java.util.ArrayList;
import java.util.Stack;
public class Solution2 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> tempStack = new Stack<Integer>();
        while(listNode != null){
            tempStack.push(listNode.val);								//进栈
            listNode = listNode.next;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(!tempStack.isEmpty()){ 									//判断栈是否为空
            list.add(tempStack.pop());									//出栈
        }
        return list;
    }
}


//采用递归也是很好的方法，   递归判断依据是当前节点不是最后一个节点 ，就递归下个节点，之后再把本节点值加入list中
import java.util.ArrayList;
public class Solution3 {
    public void recursive(ArrayList list,ListNode listNode){
        if(listNode.next != null){
            recursive(list,listNode.next);
            list.add(listNode.val);
        }else{
            list.add(listNode.val);
        }
    }
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(listNode == null){
            return list;
        }
        recursive(list,listNode);
        return list;
    }
}