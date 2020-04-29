ArrayList<TreeNode> res = new ArrayList<TreeNode>();
public void preOrder(TreeNode root){
    if (root != null){
        res.add(root);
        preOrder(root.left);
        preOrder(root.right);
    }
}


ArrayList<TreeNode> res = new ArrayList<TreeNode>();
public void inOrder(TreeNode root){
    if (root != null){
        inOrder(root.left);
        res.add(root);
        inOrder(root.right);
    }
}


ArrayList<TreeNode> res = new ArrayList<TreeNode>();
public void postOrder(TreeNode root){
    if (root != null){
        postOrder(root.left);
        postOrder(root.right);
        res.add(root);
    }
}


public ArrayList<TreeNode> levelOrder(TreeNode root){
    ArrayList<TreeNode> res = new ArrayList<TreeNode>();
    Queue<TreeNode> temp = new Queue<TreeNode>();
    temp.offer(root);
    while(!temp.empty()){
        TreeNode node = temp.poll();
        res.add(node);
        if (node.left != null){
            temp.offer(node.left);
        }
        if (node.right != null){
            temp.offer(node.right);
        }
    }
    return res;
}



ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
public void findPath(TreeNode root,ArrayList<Integer> path){
    path.add(root.val);
    if (root.left == null && root.right == null){
        res.add(new ArrayList<Integer>(path));
    }
    if (root.left != null){
        findPath(root.left,path);
    }
    if (root.right != null){
        findPath(root.right,path);
    }
    path.remove(path.size() - 1);
}



public ArrayList<TreeNode> preOrder(TreeNode root){
    ArrayList<TreeNode> res = new ArrayList<TreeNode>();
    Stack<TreeNode> temp = new Stack<TreeNode>();
    TreeNode node = root;
    while(!temp.empty() || node != null){
        if (node != null){
            res.add(node);
            temp.push(node.right);
            node = node.left; 
        }else{
            node = temp.pop();
        }
    }
    return res;
}


public ArrayList<TreeNode> inOrder(TreeNode root){
    ArrayList<TreeNode> res = new ArrayList<TreeNode>();
    Stack<TreeNode> temp = new Stack<TreeNode>();
    TreeNode node = root;
    while(!temp.empty() || node != null){
        if (node != null){
            temp.push(node);
            node = node.left; 
        }else{
            node = temp.pop();
            res.add(node);
            node = node.right;
        }
    }
    return res;
}


public ArrayList<TreeNode> postOrder(TreeNode root){
    ArrayList<TreeNode> res = new ArrayList<TreeNode>();
    Stack<TreeNode> temp = new Stack<TreeNode>();
    TreeNode node = root;
    while(!temp.empty() || node != null){
        if (node != null){
            res.add(node);
            temp.push(node.left);
            node = node.right; 
        }else{
            node = temp.pop();
        }
    }
    return Collections.reverse(res);
}

public ArrayList<ArrayList<Integer>> findPath(TreeNode root){
    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

    ArrayList<Integer> path = new ArrayList<Integer>();
    Stack<TreeNode> nodeTemp = new Stack<TreeNode>();
    Stack<ArrayList<Integer>> pathTemp = new Stack<ArrayList<Integer>>();
    
    TreeNode node = root;
    path.add(root.val);
    nodeTemp.push(node);
    pathTemp.push(path);
    
    while(!nodeTemp.isEmpty() && !pathTemp.isEmpty()){
        node = nodeTemp.pop();
        path = pathTemp.pop();
        if (node.left == null && node.right == null){
            res.add(new ArrayList<Integer>(path));
        }
        if (node.right != null){
            ArrayList<Integer> p = new ArrayList<Integer>(path);
            p.add(node.right.val);
            nodeTemp.push(node.right);
            pathTemp.push(p);
        }
        if (node.left != null){
            ArrayList<Integer> p = new ArrayList<Integer>(path);
            p.add(node.left.val);
            nodeTemp.push(node.left);
            pathTemp.push(p);
        }
    }
    return res;
}