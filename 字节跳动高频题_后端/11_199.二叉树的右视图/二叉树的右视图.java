/*
199. 二叉树的右视图
给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。

示例:

输入: [1,2,3,null,5,null,4]
输出: [1, 3, 4]
解释:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
*/

//方法一：深度优先搜索---栈

//Java
//Author:Joey
//Date：2020/07/11

/*
执行结果：
执行用时：3 ms, 在所有 Java 提交中击败了7.95%的用户
内存消耗：38.5 MB, 在所有 Java 提交中击败了5.00%的用户
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 //深度优先---栈
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer, Integer> MostRightvalue = new HashMap<Integer, Integer>();
        int max_depth = -1;  //初始化最大深度
        
        Stack<TreeNode> node_stack = new Stack<TreeNode>();
        Stack<Integer> depth_stack = new Stack<Integer>();
        depth_stack.push(0);
        node_stack.push(root);

        while (!node_stack.isEmpty()) {
            TreeNode node = node_stack.pop();
            int dept = depth_stack.pop();  //dept理解为树的第几层

            if (node != null) {
                max_depth = Math.max(max_depth, dept);

                if (!MostRightvalue.containsKey(dept)) {  //如果链表中对应当前深度没有value
                    MostRightvalue.put(dept, node.val);  //用链表就是为了去重（一层中有很多节点）
                }

                node_stack.push(node.left);
                node_stack.push(node.right);  //后入先出
                depth_stack.push(dept+1);
                depth_stack.push(dept+1);


            }
        }
        List<Integer> right_view = new ArrayList<Integer>();
        for (int dept = 0; dept <= max_depth; dept++) {  //将链表中数存放到数组中输出
            right_view.add(MostRightvalue.get(dept));
        }
        return right_view;

    }
}

//方法二：广度优先---队列

/*
执行结果：
执行用时：2 ms, 在所有 Java 提交中击败了26.26%的用户
内存消耗：38.5 MB, 在所有 Java 提交中击败了5.00%的用户
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer, Integer> rightmostValueAtDepth = new HashMap<Integer, Integer>();
        int max_depth = -1;

        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();  //链表实现
        Queue<Integer> depthQueue = new LinkedList<Integer>();
        nodeQueue.add(root);
        depthQueue.add(0);

        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();
            int depth = depthQueue.remove();

            if (node != null) {
            	// 维护二叉树的最大深度
                max_depth = Math.max(max_depth, depth);

                // 由于每一层最后一个访问到的节点才是我们要的答案，因此不断更新对应深度的信息即可
                rightmostValueAtDepth.put(depth, node.val);  //队列是先进先出特性

                nodeQueue.add(node.left);
                nodeQueue.add(node.right);
                depthQueue.add(depth+1);
                depthQueue.add(depth+1);
            }
        }

        List<Integer> rightView = new ArrayList<Integer>();
        for (int depth = 0; depth <= max_depth; depth++) {
            rightView.add(rightmostValueAtDepth.get(depth));
        }

        return rightView;
    }
}

