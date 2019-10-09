#230.二叉搜索树中第K小的元素

#题目来源：
"""
https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst
"""
#题目描述：
"""
给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。

说明：
你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
"""
#示例1：
"""
输入: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
输出: 1
"""
#示例2：
"""
输入: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
输出: 3

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
#解题思路：
"""
二叉搜索树，中序遍历所有节点就会得到到一个有序数组，所以重点是中序遍历。
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        result = list()
        self._inOrder(root, result, k)
        return result[k - 1]

    def _inOrder(self, root, arr, k):  #中序遍历
        if root:
            self._inOrder(root.left, arr, k)
            if len(arr) >= k:
                return
            arr.append(root.val)
            self._inOrder(root.right, arr, k)
