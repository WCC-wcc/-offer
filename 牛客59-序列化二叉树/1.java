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
    int index = -1;
    String Serialize(TreeNode root) {
        StringBuffer res = new StringBuffer();
        if (root == null){
            res.append("#!");
            return res.toString();
        }else{
            res.append(root.val + "!");
            res.append(Serialize(root.left));
            res.append(Serialize(root.right));
            return res.toString();
        }
  }
    TreeNode Deserialize(String str) {
        index++;
        String[] res = str.split("!");

        TreeNode node = null;
        if(!res[index].equals("#")){        //java判断字符相等 必须用equals(),==判断的是判断的是地址
            node = new TreeNode(Integer.valueOf(res[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        return node;
  }
}







