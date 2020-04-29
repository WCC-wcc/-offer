import java.util.ArrayList;
/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null){
            return res;
        }
        ArrayList<TreeNode> nodeTemp = new ArrayList<TreeNode>();
        nodeTemp.add(root);
        while(nodeTemp.size() != 0){
            res.add(nodeTemp.get(0).val);
            if(nodeTemp.get(0).left != null){
                nodeTemp.add(nodeTemp.get(0).left);
            } 
            if(nodeTemp.get(0).right != null){
                nodeTemp.add(nodeTemp.get(0).right);
            }
            nodeTemp.remove(0);
        }
        return res;
    }
}

ArrayList:  ArrayList.add(element)  ArrayList.get(index)    ArrayList.remove(index)    ArrayList.size()
            ArrayList.contains(element)     ArrayList.sublist(begin,end)    ArrayList.set(index,element)
            ArrayList.indexOf(element)
Queue:      Queue.offer(element)    Queue.peekFirst()   Queue.peekLast()    Queue.pollFirst()   Queue.pollLast()
            Queue.add(element)      Queue.getFirst()    Queue.getLast()     Queue.removeFirst() Queue.removeLast()
            Queue.isEmpty()