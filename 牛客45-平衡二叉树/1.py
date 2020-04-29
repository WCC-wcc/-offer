# # -*- coding:utf-8 -*-
# # class TreeNode:
# #     def __init__(self, x):
# #         self.val = x
# #         self.left = None
# #         self.right = None
# class Solution:
#     def IsBalanced_Solution(self, pRoot):
#         # write code here
#         def getTreeDepth(root):
#             if not root:
#                 return 0
#             leftDepth = getTreeDepth(root.left)
#             rightDepth = getTreeDepth(root.right)
#             if leftDepth < rightDepth:return 1 + rightDepth
#             else: return 1 + leftDepth  

#         def isBalance(root):
#             if not root:
#                 return True
#             if root.left and root.left.val >= root.val:
#                 return False
#             if root.right and root.right.val <= root.val:
#                 return False
#             return True

#         if not pRoot:
#             return True

#         if isBalance(pRoot):
#             leftTreeDepth = getTreeDepth(pRoot.left)
#             rightTreeDepth = getTreeDepth(pRoot.right)
#             if abs(leftTreeDepth - rightTreeDepth) <= 1:
#                 return self.IsBalanced_Solution(pRoot.left) and self.IsBalanced_Solution(pRoot.right)
#             else:
#                 return False
#         else:
#             return False
        



# -*- coding:utf-8 -*-
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
class Solution:
    def IsBalanced_Solution(self, pRoot):
        # write code here
        def getTreeDepth(root):
            if not root:
                return 0
            leftDepth = getTreeDepth(root.left)
            if leftDepth == -1:
                return -1
            rightDepth = getTreeDepth(root.right)
            if rightDepth == -1:
                return -1
            if abs(leftDepth - rightDepth) > 1:
                return -1 
            else: return max(1 + leftDepth,1+rightDepth)   

        if not pRoot:
            return True
        return getTreeDepth(pRoot) != -1




# -*- coding:utf-8 -*-
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
class Solution:
    def IsBalanced_Solution(self, pRoot):
        # write code here
        def getTreeDepth(root):
            if not root:
                return 0
            leftDepth = getTreeDepth(root.left)
            rightDepth = getTreeDepth(root.right)
            if leftDepth < rightDepth:return 1 + rightDepth
            else: return 1 + leftDepth  

        if not pRoot:
            return True

        leftTreeDepth = getTreeDepth(pRoot.left)
        rightTreeDepth = getTreeDepth(pRoot.right)
        if abs(leftTreeDepth - rightTreeDepth) <= 1:
            return self.IsBalanced_Solution(pRoot.left) and self.IsBalanced_Solution(pRoot.right)
        else:
            return False
        