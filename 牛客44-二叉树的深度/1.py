# -*- coding:utf-8 -*-
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
class Solution:                        #递归解法
    def TreeDepth(self, pRoot):
        # write code here
        if not pRoot:
            return 0
        leftDepth = self.TreeDepth(pRoot.left)
        rightDepth = self.TreeDepth(pRoot.right)
        return 1 + max(leftDepth,rightDepth)



# -*- coding:utf-8 -*-       #层次遍历,每轮添加一层的节点，然后深度加1，再把这一轮节点子节点添加进来以后
# class TreeNode:            #删除这一轮节点
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
class Solution:
    def TreeDepth(self, pRoot):
        # write code here
        if not pRoot:
            return 0
        maxDepth = 0
        res = [pRoot]
        while(res):
            maxDepth += 1
            size = len(res)
            while(size > 0):
                if res[size - 1].left :
                    res.append(res[size - 1].left) 
                if res[size - 1].right:
                    res.append(res[size - 1].right)
                res.pop(size - 1)
                size -= 1
        return maxDepth