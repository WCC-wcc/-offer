public class Solution {
    public int getTreeDepth(TreeNode root){
        if (root == null) return 0;
        int leftDepth = getTreeDepth(root.left);
        if (leftDepth == -1) return -1;

        int rightDepth =getTreeDepth(root.right);
        if (rightDepth == -1) return -1;

        if (Math.abs(rightDepth - leftDepth) > 1) return -1;
        
        if (leftDepth < rightDepth) return 1 + rightDepth;
        else return 1 + leftDepth;
    }


    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) return true;
        return (getTreeDepth(root) != -1);
    }
}