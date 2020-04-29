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
public class Solution {
    boolean isSymmetry(TreeNode root1,TreeNode root2)
    {
        if (root1 == null && root2 == null) return true;
        else if (root1 == null || root2 == null) return false;
        else if (root1.val != root2.val) return false;
        else return isSymmetry(root1.left,root2.right) && isSymmetry(root1.right,root2.left);
    }

    boolean isSymmetrical(TreeNode pRoot)
    {
        if (pRoot == null) return true;
        else return isSymmetry(pRoot.left,pRoot.right);
    }
}



import java.util.Queue;
import java.util.LinkedList;
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
public class Solution {
    boolean isSymmetrical(TreeNode pRoot)
    {
        if (pRoot == null) return true;
        Queue<TreeNode> res = new LinkedList<TreeNode>();
        res.offer(pRoot.left);
        res.offer(pRoot.right);
        while(!res.isEmpty()){
            TreeNode root1 = res.poll();
            TreeNode root2 = res.poll();
            if (root1 == null && root2 == null) continue;
            if (root1 == null || root2 == null) return false;
            if (root1.val != root2.val) return false;

            res.offer(root1.left);
            res.offer(root2.right);
            res.offer(root1.right);
            res.offer(root2.left);
        }
        return true;
    }
}







import java.util.Stack;
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
public class Solution {
    boolean isSymmetrical(TreeNode pRoot)
    {
        if (pRoot == null) return true;
        Stack<TreeNode> res = new Stack<TreeNode>();
        res.push(pRoot.left);
        res.push(pRoot.right);
        while(!res.isEmpty()){
            TreeNode root1 = res.pop();
            TreeNode root2 = res.pop();
            if (root1 == null && root2 == null) continue;
            if (root1 == null || root2 == null) return false;
            if (root1.val != root2.val) return false;

            res.push(root1.left);
            res.push(root2.right);
            res.push(root1.right);
            res.push(root2.left);
        }
        return true;
    }
}