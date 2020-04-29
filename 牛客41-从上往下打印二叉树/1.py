# -*- coding:utf-8 -*-
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
class Solution:
    # 返回从上到下每个节点值列表，例：[1,2,3]
    def PrintFromTopToBottom(self, root):                 #广度优先 每次都放进去左右节点，在依次处理左右节点即可
        # write code here
        if not root:
            return []
        res = []
        nodeTemp = []
        nodeTemp.append(root)
        while(nodeTemp):
            res.append(nodeTemp[0].val)
            if nodeTemp[0].left:
                nodeTemp.append(nodeTemp[0].left)
            if nodeTemp[0].right:
                nodeTemp.append(nodeTemp[0].right)
            # del(nodeTemp[0])
            nodeTemp.pop(0)
        return res

