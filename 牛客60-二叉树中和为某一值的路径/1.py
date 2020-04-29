# -*- coding:utf-8 -*-
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
class Solution:
    # 返回二维列表，内部每个列表表示找到的路径

    def __init__(self):
        self.res = []
        self.num = 0

    def DFS(self,root,path):
        # path += [root.val]
        path = path + [root.val]
        if not root.left and not root.right and self.num == sum(path):
            self.res.append(path)
        if root.left:
            self.DFS(root.left,path)
        if root.right:
            self.DFS(root.right,path)


    def FindPath(self, root, expectNumber):
        # write code here
        if not root:
            return []
        path = []
        self.num = expectNumber
        self.DFS(root,path)
        return self.res


# root = TreeNode(1)
# root.left = TreeNode(2)
# root.right = TreeNode(5)
# root.left.left  = TreeNode(3)
# root.left.right  = TreeNode(4)
# root.right.left = TreeNode(6)
# root.right.left.right = TreeNode(60)

# Solution = Solution()
# Solution.FindPath(root,10)

# 1.append()  向列表尾部追加一个新元素，列表只占一个索引位，在原有列表上增加
# 2.extend() 向列表尾部追加一个列表，将列表中的每个元素都追加进来，在原有列表上增加
# 3.+  直接用+号看上去与用extend()一样的效果，但是实际上是生成了一个新的列表存这两个列表的和，只能用在两个列表相加上
# 4.+= 效果与extend()一样，向原列表追加一个新元素，在原有列表上增



# -*- coding:utf-8 -*-
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
class Solution:
    # 返回二维列表，内部每个列表表示找到的路径
    def FindPath(self, root, expectNumber):
        # write code here
        if not root:
            return []
        res = []
        stack = []
        stack.append((root,[root.val]))
        while stack:
            node,path = stack.pop()
            if not node.left and not node.right and sum(path) == expectNumber:
                res.append(path)
            if node.right:
                stack.append((node.right,path + [node.right.val]))
            if node.left:
                stack.append((node.left,path + [node.left.val]))
        return res