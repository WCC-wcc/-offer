# -*- coding:utf-8 -*-
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
class Solution:                                 #递归判断对应点的值是否相等
    def isSymmetrical(self, pRoot):
        # write code here
        def isSymmetry(root1,root2):
            if not root1 and not root2:
                return True
            if not root1 or not root2:
                return False
            if root1.val != root2.val:
                return False
            return isSymmetry(root1.left,root2.right) and isSymmetry(root1.right,root2.left)

        if not pRoot:
            return True
        return isSymmetry(pRoot.left,pRoot.right)



# -*- coding:utf-8 -*-
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
class Solution:                     #用队列，先进先出，BFS
    def isSymmetrical(self, pRoot):
        # write code here
        if not pRoot:
            return True
        res = [pRoot.left,pRoot.right]
        while(res):
            root1 = res.pop(0)
            root2 = res.pop(0)
            if not root1 and not root2:
                continue
            if not root1 or not root2:
                return False
            if root1.val != root2.val:
                return False

            res.append(root1.left)
            res.append(root2.right)
            res.append(root1.right)
            res.append(root2.left)
        return True




# -*- coding:utf-8 -*-
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
class Solution:                          #用栈，先进后出，DFS
    def isSymmetrical(self, pRoot):
        # write code here
        if not pRoot:
            return True
        res = [pRoot.left,pRoot.right]
        while(res):
            root1 = res.pop(-1)
            root2 = res.pop(-1)
            if not root1 and not root2:
                continue
            if not root1 or not root2:
                return False
            if root1.val != root2.val:
                return False

            res.append(root1.left)
            res.append(root2.right)
            res.append(root1.right)
            res.append(root2.left)
        return True