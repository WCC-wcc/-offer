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
    int num = 0;
    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

    public void DFS(TreeNode root,ArrayList<Integer> path){
        path.add(root.val);             //这里在传入的path直接操作，在处理完一个节点后必须回退状态
                                        //否则，所有的path就都是一个样子
        if (root.left == null && root.right == null){
            int sum = 0;
            for (Integer item : path){
                sum += item;
            }
            if (sum == num){
                res.add(new ArrayList<Integer>(path));  //使用复制版本，保证保存的path不一致
            }
        }
        if (root.left != null){
            DFS(root.left,path);
        }
        if (root.right != null){
            DFS(root.right,path);
        }
        path.remove(path.size() - 1);    //回退状态
    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        
        ArrayList<Integer> path = new ArrayList<Integer>();
        if (root == null) return res;
        num = target;
        DFS(root,path);
        return res;
    }
}



import java.util.ArrayList;
import java.util.Stack;
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
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root == null){
            return res;
        }


        Stack<TreeNode> stackNode = new Stack<TreeNode>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        Stack<ArrayList<Integer>> stackPath = new Stack<ArrayList<Integer>>();

        TreeNode node = root;
        path.add(node.val);

        stackNode.push(node);
        stackPath.push(path);

        while(!stackNode.isEmpty() && !stackPath.isEmpty()){
            node = stackNode.pop();
            path = stackPath.pop();
            if (node.left == null && node.right == null){
                int sum = 0;
                for (Integer item : path){
                    sum += item;
                }
                if (sum == target){
                    res.add(path);
                }
            }
            if (node.right != null){
                ArrayList<Integer> p = new ArrayList<Integer>(path);
                p.add(node.right.val);
                stackNode.push(node.right);
                stackPath.push(p);
            }
            if (node.left != null){
                ArrayList<Integer> p = new ArrayList<Integer>(path);
                p.add(node.left.val);
                stackNode.push(node.left);
                stackPath.push(p);
            }
        }
        return res;
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
    int num = 0;
    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

    public void DFS(TreeNode root,ArrayList<Integer> path){
        ArrayList<Integer> path1 = new ArrayList<Integer>(path);
        path1.add(root.val);             //这里创建新的path1，处理完节点后，不用做额外处理
        if (root.left == null && root.right == null){
            int sum = 0;
            for (Integer item : path1){
                sum += item;
            }
            if (sum == num){
                res.add(path1);  
            }
        }
        if (root.left != null){
            DFS(root.left,path1);
        }
        if (root.right != null){
            DFS(root.right,path1);
        }
    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        
        ArrayList<Integer> path = new ArrayList<Integer>();
        if (root == null) return res;
        num = target;
        DFS(root,path);
        return res;
    }
}