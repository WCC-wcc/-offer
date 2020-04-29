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
    public boolean hasSameStruct(TreeNode root1,TreeNode root2){
        if (root2 == null) return true;
        if (root1 == null) return false;
        if (root1.val != root2.val) return false;
        return hasSameStruct(root1.left,root2.left) && hasSameStruct(root1.right,root2.right);
    }

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean res = false;
        if (root1 == null || root2 == null) return res;
        if (root1.val == root2.val){
            res = hasSameStruct(root1,root2);
        }
        if (res == false){
            res = HasSubtree(root1.left,root2);
        }
        if (res == false){
            res = HasSubtree(root1.right,root2);
        }
        return res;
    }
}