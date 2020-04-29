import java.util.ArrayList;


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
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<TreeNode> temp = new ArrayList<TreeNode>();
        if (pRoot == null) return res;
        temp.add(pRoot);
        while(temp.size() > 0){
            int size = temp.size();
            ArrayList<Integer> currLayer = new ArrayList<Integer>();
            while (size > 0){
                currLayer.add(temp.get(0).val);
                if (temp.get(0).left != null) temp.add(temp.get(0).left);
                if (temp.get(0).right != null) temp.add(temp.get(0).right);
                temp.remove(0);
                size--;
            }
            res.add(currLayer);
        }
        return res;
    }
    
}