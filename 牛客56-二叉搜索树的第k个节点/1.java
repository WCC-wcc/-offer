/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
import java.util.ArrayList;
public class Solution {
    ArrayList<TreeNode> res = new ArrayList<TreeNode>();
    
    public void inOrder(TreeNode root){
        if (root != null){
            inOrder(root.left);
            res.add(root);
            inOrder(root.right);
        }
    }


    public TreeNode KthNode(TreeNode pRoot, int k)
    {
        inOrder(pRoot);
        if (res.size() >= k && k > 0){
            return res.get(k - 1);
        }else{
            return null;
        }
    }

}



/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
import java.util.Stack;
public class Solution {
    public TreeNode KthNode(TreeNode pRoot, int k)
    {
        if (pRoot == null || k < 1) return null;
        TreeNode node = pRoot;
        Stack<TreeNode> res = new Stack<TreeNode>();
        while(res.size() > 0 || node != null){
            if (node != null){
                res.push(node);
                node = node.left;
            }else{
                node = res.pop();
                if (--k == 0) return node;
                node = node.right;
            }
        }
        return null;
    }

}