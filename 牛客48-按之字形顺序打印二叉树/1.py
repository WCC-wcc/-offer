# -*- coding:utf-8 -*-
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
class Solution:
    # 返回二维列表[[1,2],[4,5]]
    def Print(self, pRoot):
        # write code here
        if not pRoot:
            return []
        currLayer = [pRoot]                     #当前层节点
        nextLayer = []                          #下一层节点
        res = []                                #总结果
        depth = 1
        while(currLayer):                       #还存在节点
            if depth % 2 != 0:
                temp = [i.val for i in currLayer]   #每一层返回值
            else:
                temp = [i.val for i in currLayer[::-1]]
            depth += 1
            res.append(temp)
            for item in currLayer:
                if item.left:
                    nextLayer.append(item.left)
                if item.right:
                    nextLayer.append(item.right)
            currLayer,nextLayer = nextLayer,[]  #更新当前层和下一层
        return res