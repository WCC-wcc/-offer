/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode reBuiltTree(int [] pre,int beginpre,int endpre,int [] in,int beginin,int endin) {
        if (endpre < beginpre  || endin < beginin) return null;
        TreeNode node = new TreeNode(pre[beginpre]);
        if (endpre == beginpre) return node; 
        for (int i = beginin;i <= endin;i++){
            if (in[i] == node.val){
                node.left = reBuiltTree(pre,beginpre + 1,beginpre + (i - beginin),in,beginin,i - 1);
                node.right = reBuiltTree(pre,beginpre + (i - beginin) + 1,endpre,in,i + 1,endin);
            }
        }
        return node;
    } 
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        // if (pre.length < 1 || in.length < 1) return null;
        return reBuiltTree(pre,0,pre.length - 1,in,0,in.length - 1);
    }
}