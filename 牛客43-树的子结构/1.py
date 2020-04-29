# -*- coding:utf-8 -*-                #子树：   只要包含了一个结点，就得包含这个结点下的所有节点.
# class TreeNode:                     #子结构： 包含了一个结点，可以只取左子树或者右子树，或者都不取。
#     def __init__(self, x):          #要查找树A中是否存在和树B结构一样的子树，分成两步：
#         self.val = x                #第一，在树A中找到和B的根结点的值一样的结点R；
#         self.left = None            #第二，判断树A中以R为根结点的子树是不是包含和树B一样的结构。
#         self.right = None
class Solution:
    def HasSubtree(self, pRoot1, pRoot2):
        # write code here
        def hasSameStrut(root1,root2):  #输入的两棵树根节点值相等，递归的判断是否直到后者到达叶子结点，二者值均相等
            if not root2:
                return True
            if not root1:
                return False
            if root1.val != root2.val:
                return False
            return hasSameStrut(root1.left,root2.left) and hasSameStrut(root1.right,root2.right)
        

        res = False                         #res作为判断的标志位
        if not pRoot1 or not pRoot2:
            return res
        if pRoot1.val == pRoot2.val:        #根节点相同情况下  看二者是否具有相同结构
            res = hasSameStrut(pRoot1,pRoot2)
        if not res:                         #若之前相等节点的判断中发现不是相同的树结构，继续遍历大树的其他节点
            res = self.HasSubtree(pRoot1.left,pRoot2) 
        if not res:
            res = self.HasSubtree(pRoot1.right,pRoot2)
        return res


