# -*- coding:utf-8 -*-
# class TreeLinkNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
#         self.next = None
class Solution:
    def GetNext(self, pNode):
        # write code here
        res = []
        def inOrder(root):
            if (root):
                inOrder(root.left)
                res.append(root)
                inOrder(root.right)

        node  = pNode
        while(node.next != None):
            node = node.next
        inOrder(node)
        for i in range(len(res)):
            if res[i] == pNode and i + 1 < len(res):
                return res[i + 1]
        return None

# -*- coding:utf-8 -*-
# class TreeLinkNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
#         self.next = None
class Solution:
    def GetNext(self, pNode):
        # write code here
        if pNode.right:
            node = pNode.right
            while node.left != None:
                node = node.left   
            return node
        elif pNode.next and pNode.next.left == pNode:
            return pNode.next
        elif pNode.next and pNode.next.right == pNode:
            node = pNode.next
            while(node.next and node.next.right == node):
                node = node.next
            return node.next
        else:
            return None