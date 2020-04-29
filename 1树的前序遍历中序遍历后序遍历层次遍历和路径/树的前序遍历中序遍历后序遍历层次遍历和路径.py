res = []
def preOrder(root):
    if root:
        res.append(root)
        preOrder(root.left)
        preOrder(root.right)

res = []
def inOrder(root):  
    if root:
        inOrder(root.left)
        res.append(root)
        inOrder(root.right)


res = []
def postOrder(root):
    if root:
        postOrder(root.left)
        postOrder(root.right)
        res.append(root)

res = []
def levelOrder(root):
    temp = [root]
    while(temp):
        node = temp.pop(0)
        res.append(node)
        if node.left:
            temp.append(node.left)
        if node.right:
            temp.append(node.right)


res = []
def findPath(root,path):
    path = path + [root.val]
    if not root.left and not root.right:
        res.append(path)
    if root.left:
        findPath(root.left,path)
    if root.right:
        findPath(root.right,path)

def preOrder(root):
    stack = []
    res = []
    node = root
    while(stack or node):
        if node:
            res.append(node)
            stack.append(node.right)
            node = node.left
        else:
            node = stack.pop(-1)
    return res



def inOrder(root):
    stack = []
    res = []
    node = root
    while(stack or node):
        if node:
            stack.append(node)
            node = node.left
        else:
            node = stack.pop(-1)
            res.append(node)
            node = node.right
    return res

def postOrder(root):
    stack = []
    res = []
    node = root
    while(stack or node):
        if node:
            res.append(node)
            stack.append(node.left)
            node = node.right
        else:
            node = stack.pop(-1)
    return res[::-1]


def findPath(root):
    res = []
    stack = []
    node = root
    stack.append((node,[node.val]))
    while(stack):
        node,path = stack.pop()
        if not node.left and not node.right:
            res.append(path)
        if node.right:
            stack.append((node.right,path + [node.right.val]))
        if node.left:
            stack.append((node.left,path + [node.left.val]))
    return res