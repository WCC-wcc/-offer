# -*- coding:utf-8 -*-
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
class Solution:
    # 返回镜像树的根节点
    def Mirror(self, root):
        # write code here
        if root:
            temp = root.left
            root.left = root.right
            root.right = temp
            if root.left:
                self.Mirror(root.left)
            if root.right:
                self.Mirror(root.right)





# -*- coding:utf-8 -*-
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
class Solution:
    # 返回镜像树的根节点
    def Mirror(self, root):
        # write code here
        temp = []
        if root:
            temp.append(root)
            while(temp):
                node = temp[0].left
                temp[0].left = temp[0].right
                temp[0].right = node
                if (temp[0].left):
                    temp.append(temp[0].left)
                if (temp[0].right):
                    temp.append(temp[0].right)
                del(temp[0])