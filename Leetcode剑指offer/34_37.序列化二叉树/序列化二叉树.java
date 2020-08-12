/*
剑指 Offer 37. 序列化二叉树
请实现两个函数，分别用来序列化和反序列化二叉树。

示例: 

你可以将以下二叉树：

    1
   / \
  2   3
     / \
    4   5

序列化为 "[1,2,3,null,null,4,5]"
注意：本题与主站 297 题相同：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
*/

//Java
//Author:Joey
//Date：2020/08/12


//时间复杂度：O(n), 空间复杂度：O(n)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "[]";
        StringBuffer res = new StringBuffer("[");
        Queue<TreeNode> que = new LinkedList();
        que.offer(root);
        while (!que.isEmpty()) {
            TreeNode node = que.poll();
            if (node != null) {
                res.append(node.val + ",");
                que.offer(node.left);
                que.offer(node.right);
            } else {
                res.append("null" + ",");
            }
        }
        res.deleteCharAt(res.length()-1);  //去除最后一个逗号
        res.append("]");
        return res.toString();
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("[]")) return null;
        String[] str = data.substring(1, data.length() - 1).split(",");  //取子串
        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
        Queue<TreeNode> que = new LinkedList();  //队列的先进先出
        que.offer(root);
        int i = 1;
        while (!que.isEmpty()) {
            TreeNode node = que.poll();
            if (!str[i].equals("null")){
                node.left = new TreeNode(Integer.parseInt(str[i]));
                que.offer(node.left);
            }
            i++;
            if (!str[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(str[i]));
                que.offer(node.right);
            }
            i++;
        }
        return root;        
    }

}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));