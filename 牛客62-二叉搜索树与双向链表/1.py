# -*- coding:utf-8 -*-
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
class Solution:
    def __init__(self):
        self.res = []

    def inOrder(self,root):
        if root:
            self.inOrder(root.left)
            self.res.append(root)
            self.inOrder(root.right)

    def Convert(self, pRootOfTree):
        # write code here
        if not pRootOfTree:
            return None
        self.inOrder(pRootOfTree)
        for i in range(0,len(self.res) - 1):
            self.res[i].right = self.res[i + 1]
            self.res[i + 1].left = self.res[i]
        return self.res[0]





# -*- coding:utf-8 -*-
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
class Solution:
    def __init__(self):
        self.currNode = None

    def inOrder(self,root):
        if root:
            self.inOrder(root.left)
            root.left = self.currNode
            if self.currNode:
                self.currNode.right = root
            self.currNode = root
            self.inOrder(root.right)

    def Convert(self, pRootOfTree):
        # write code here
        if not pRootOfTree:
            return None
        node = pRootOfTree
        while (node.left):
            node = node.left
        self.inOrder(pRootOfTree)
        return node