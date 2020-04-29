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
    public void Mirror(TreeNode root) {
        if (root != null){
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            if(root.left != null){
                Mirror(root.left);
            }
            if(root.right != null){
                Mirror(root.right);
            }
        }
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
import java.util.ArrayList;
public class Solution {
    public void Mirror(TreeNode root) {
        if (root != null){
            ArrayList<TreeNode> temp = new ArrayList<TreeNode>();
            temp.add(root);
            while(temp.size() > 0){
                TreeNode node = temp.get(0).left;
                temp.get(0).left = temp.get(0).right;
                temp.get(0).right = node;
                if (temp.get(0).left != null){
                    temp.add(temp.get(0).left);
                }
                if (temp.get(0).right != null){
                    temp.add(temp.get(0).right);
                }
                temp.remove(0);
            }
        }
    }
}