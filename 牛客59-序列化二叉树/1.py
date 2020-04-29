# -*- coding:utf-8 -*-
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
class Solution:
    def __init__(self):
        self.index = -1

    def Serialize(self, root):
        # write code here
        res = ''
        if not root:
            res += '#!'
            return res
        else:
            res += str(root.val) + '!'
            res += self.Serialize(root.left)
            res += self.Serialize(root.right)
            return res 


    def Deserialize(self, s):
        # write code here
        self.index += 1
        res = s.split("!")
        node = None
        if (res[self.index] != '#'):
            node = TreeNode((int)(res[self.index]))
            node.left = self.Deserialize(s)
            node.right = self.Deserialize(s)
        return node


# root = TreeNode(1)
# root.left = TreeNode(2)
# root.right = TreeNode(5)
# root.left.left  = TreeNode(3)
# root.left.right  = TreeNode(4)
# root.right.left = TreeNode(6)
# Solution = Solution()
# print(Solution.Serialize(root))


