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

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;
        inOrder(pRootOfTree);
        for (int i = 0;i < res.size() - 1;i++){
            res.get(i).right = res.get(i + 1);
            res.get(i + 1).left = res.get(i);
        }
        return res.get(0);
    }
}




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

    public TreeNode currNode = null;

    public void inOrder(TreeNode root){
        if (root != null){
            inOrder(root.left);
            root.left = currNode;
            if (currNode != null)
                currNode.right = root;
            currNode = root;
            inOrder(root.right);
        }
    }

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;
        TreeNode node = pRootOfTree;
        while(node.left != null)
            node = node.left;
        inOrder(pRootOfTree);
        return node;
    }
}