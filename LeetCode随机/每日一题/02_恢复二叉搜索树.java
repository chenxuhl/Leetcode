/*
99. 恢复二叉搜索树
二叉搜索树中的两个节点被错误地交换。

请在不改变其结构的情况下，恢复这棵树。

示例 1:

输入: [1,3,null,null,2]

   1
  /
 3
  \
   2

输出: [3,1,null,null,2]

   3
  /
 1
  \
   2
示例 2:

输入: [3,1,4,null,null,2]

  3
 / \
1   4
   /
  2

输出: [2,1,4,null,null,3]

  2
 / \
1   4
   /
  3
进阶:

使用 O(n) 空间复杂度的解法很容易实现。
你能想出一个只使用常数空间的解决方案吗
*/

//Java
//Author:Joey
//Date：2020/08/08

//解题思路：递归，参考官方解题（没思路）

//时间复杂度: O(n), 空间复杂度：O(n)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void recoverTree(TreeNode root) {
        List<Integer> arr = new ArrayList();
        inorder(root, arr);  //中序遍历
        int[] swap = Swap(arr);
        recover(root, 2, swap[0], swap[1]);        
    }

    public void inorder(TreeNode root, List<Integer> arr) {
        if (root == null) return ;

        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
    }

    public int[] Swap(List<Integer> arr) {
        int n = arr.size();
        int x = -1, y = -1;
        for (int i = 0; i < n -1; i++) {
            if (arr.get(i+1) < arr.get(i)) {
                y = arr.get(i+1);
                if (x == -1) x = arr.get(i);
                else break;
            }
        }
        return new int[]{x, y};
    }

    public void recover(TreeNode root, int n, int x, int y) {
        if (root != null) {
            if (root.val == x || root.val == y) {
                root.val = root.val == x ? y : x;
                if (--n == 0) {
                    return;
                }
            }
            recover(root.left, n, x, y);
            recover(root.right, n, x, y);
        }    
    }
}
