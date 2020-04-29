# -*- coding:utf-8 -*-
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
class Solution:
    # 返回对应节点TreeNode
    def KthNode(self, pRoot, k):
        # write code here
        res = []

        def inOrder(root):
            if root:
                inOrder(root.left)
                res.append(root)
                inOrder(root.right)

        inOrder(pRoot)
        if len(res) >= k and k > 0:
            return res[k - 1]
        else:
            return None


# -*- coding:utf-8 -*-
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
class Solution:
    # 返回对应节点TreeNode
    def KthNode(self, pRoot, k):
        # write code here
        if not pRoot or k <= 0:
            return None
        node = pRoot
        res = []
        while(res || node):
            if node:
                res.append(node)
                node = node.left
            else:
                node = res[-1]
                res.pop(-1)
                k -= 1
                if k == 0:
                    return node
                node = node.right
        return None




