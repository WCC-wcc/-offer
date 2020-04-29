/*
public class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
*/
import java.util.ArrayList;
public class Solution {
    ArrayList<TreeLinkNode> res = new ArrayList<TreeLinkNode>();
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        TreeLinkNode node = pNode;
        while(node.next != null) node = node.next;
        inOrder(node);
        for (int i = 0;i < res.size();i++){
            if (res.get(i) == pNode && i + 1 < res.size()){
                return res.get(i + 1);
            }
        }
        return null;
    }
    public void inOrder(TreeLinkNode node){
        if (node != null){
            inOrder(node.left);
            res.add(node);
            inOrder(node.right);
        }
    }
}



// public class TreeLinkNode {
//     int val;
//     TreeLinkNode left = null;
//     TreeLinkNode right = null;
//     TreeLinkNode next = null;
//     public TreeLinkNode(int x){
//         this.val = x;
//     }
// }
public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if (pNode.right != null){
            TreeLinkNode node = pNode.right;
            while(node.left != null) node = node.left;
            return node;
        }else if (pNode.next != null && pNode.next.left == pNode){
            return pNode.next;
        }else if(pNode.next != null && pNode.next.right == pNode){
            TreeLinkNode node = pNode.next;
            while(node.next != null && node.next.right == node){
                node = node.next;
            }
            return node.next;
        }else{
            return null;
        }
    }
}