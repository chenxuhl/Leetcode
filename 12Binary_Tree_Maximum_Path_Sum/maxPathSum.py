#124.二叉树中的最大路径和
#题目来源：
"""
https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
"""
#题目描述：
"""
给定一个非空二叉树，返回其最大路径和。
本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。
该路径至少包含一个节点，且不一定经过根节点。
"""
#示例1：
"""
输入: [1,2,3]

       1
      / \
     2   3

输出: 6
"""
#示例2：
"""
输入: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

输出: 42
"""
#解题思路：
"""
运用递归，当结点不存在时，直接返回0，若结点存在，则将当前结点值与0进行比较，小于0则舍弃；
更新全局最大值：res = 以左子结点为终点的最大path之和 + 以右子结点为终点的最大path之和 + 当前结点值
递归返回值：left 和 right 中较大值 + 当前结点值 (因为返回值的定义是以当前结点为终点的path之和)
"""
#-*- coding: utf-8 -*-
#Author: Joey
import sys

class Solution:
    def __init__(self):
        self.res = -sys.maxsize   #赋一个足够小的初始值
    def maxPathSum(self, root):
        self.helper(root)   #调用递归
        return self.res

    def helper(self, root):
        if root == None:
            return 0
        left = max(self.helper(root.left), 0)
        right = max(self.helper(root.right), 0)
        self.res = max(self.res, left + right + root.val) #更新全局最大值结果
        return max(left, right) + root.val

