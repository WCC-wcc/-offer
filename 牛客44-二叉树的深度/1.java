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
    public int TreeDepth(TreeNode root) {
        if (root == null) return 0;
        else{
            int leftDepth = TreeDepth(root.left);
            int rightDepth = TreeDepth(root.right);
            if (leftDepth <= rightDepth) return 1 + rightDepth;
            else return 1 + leftDepth;
        }
    }
}



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
    public int TreeDepth(TreeNode root) {
        if (root == null) return 0;
        ArrayList<TreeNode> res = new ArrayList<TreeNode>();
        res.add(root);
        int maxDepth = 0;
        while(res.size() > 0){
            maxDepth++;
            int size = res.size();
            while(size > 0){
                if (res.get(size - 1).left != null){
                    res.add(res.get(size - 1).left);
                }
                if (res.get(size - 1).right != null){
                    res.add(res.get(size - 1).right);
                }
                res.remove(size - 1);
                size--;
            } 
        }
        return maxDepth;
    }
}