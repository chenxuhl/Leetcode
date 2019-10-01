#104.二叉树的最大深度

#题目来源：
"""
https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
"""
#题目描述：
"""
给定一个二叉树，找出其最大深度。二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
"""
#示例：
"""
给定二叉树 [3,9,20,null,null,15,7]，

    3
   / \
  9  20
    /  \
   15   7
返回它的最大深度 3 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
#解题思路：
"""
深度优先，递归
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def maxDepth(self, root: TreeNode) -> int:
        if root == None:
            return 0
        leftDepth = self.maxDepth(root.left) #左子树
        rightDepth = self.maxDepth(root.right)#右子树
        return 1 + max(leftDepth, rightDepth)#左右子树深度最大值

