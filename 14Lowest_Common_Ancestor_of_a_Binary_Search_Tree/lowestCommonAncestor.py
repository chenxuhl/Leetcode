#235.二叉搜索树的最近公共祖先

#题目来源：
"""
https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
"""
#题目描述：
"""
给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
"""
#示例1：
"""
         6
       /   \
      2     8
     / \   / \
    0   4 7   9
       / \
      3   5
输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
输出: 6 
解释: 节点 2 和节点 8 的最近公共祖先是 6。

"""
#示例2：
"""
输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
输出: 2
解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
#解题思路：
"""
根据搜索二叉树的特点左<根<右，根节点的值大于左子树所有节点值，小于右子树所有节点值，
进行判断，若根节点值大于p和q之间的最大值，此时进入左子树进行递归搜索；若根节点值小于
p和q之间的最小值，此时进入右子树进行递归搜索；若都不是，则说明当前根节点就是最小共同
父节点，直接返回即可。
"""
#python
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root == None:
            return NULL
        if root.val > max(p.val, q.val):
            return self.lowestCommonAncestor(root.left, p, q)
        elif root.val < min(p.val, q.val):
            return self.lowestCommonAncestor(root.right, p, q)
        else:
            return root
