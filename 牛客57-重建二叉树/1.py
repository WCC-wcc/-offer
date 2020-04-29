# -*- coding:utf-8 -*-
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
class Solution:
    # 返回构造的TreeNode根节点
    def reConstructBinaryTree(self, pre, tin):
        # write code here
        if not pre or not tin:
            return None
        if len(pre) == 1:
            return TreeNode(pre[0])
        root = TreeNode(pre[0])
        for i in range(len(tin)):
            if tin[i] == root.val:
                root.left = self.reConstructBinaryTree(pre[1:i + 1],tin[0:i])         
                root.right = self.reConstructBinaryTree(pre[i + 1:],tin[i + 1:])  
                break
        return root