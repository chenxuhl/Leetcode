#题目来源：
"""
https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
"""
#题目描述:
"""
给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
最近公共祖先表示为一个结点 x，
满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
"""
#示例1：
"""
       3
     /   \
    5     1
   / \   / \
  6   2 0   8
     / \
    7   4
输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
输出: 3
解释: 节点 5 和节点 1 的最近公共祖先是节点 3。

"""
#示例2：
"""
输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
输出: 5
解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
#解题思路：
"""
在二叉树中来搜索p和q，然后从路径中找到最后一个相同的节点即为父节点，可以用递归来实现。
在递归函数中，首先判断当前结点是否为空，若为空则直接返回为空，若为p或q中任意一个，也可直接
返回当前结点。否则就对其左右结点分别调用递归函数。由于题目限制了p和q一定都在二叉树中存在，
如果当前结点不等于p或q，则p和q要么分别位于左右子树中，要么都位于左子树，或右子树中，分别讨论如下：
1）若p和q分别位于左右子树中，对左右子树结点调用递归函数，会分别返回p和q结点的位置，而当前结点
正好就是p和q的最小共同父节点，直接返回即可；
2）若p和q同时位于左子树，有两种情况，一种是left会返回p和q中较高的那个位置，right会返回空，所有最终
返回非空的left即可，另一种情况会返回p和q的最小父节点
3）若p和q同时位于右子树，同理2），这里不赘述；
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
        if (root is None or root == p or root == q):
            return root  #若root为空或p或q，说明找到了p或q中的一个
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)
        if (left is not None and right is not None):
            return root   #若左子树和右子树找到p和q，则说明root就是公共祖先
        if (left is None):
            return right   #若左子树是None而右子树不是，则说明右子树找到p或q
        if (right is None):
            return left  #若右子树是None而左子树不是，则说明左子树找到p或q
        return None


