/*
剑指 Offer 35. 复杂链表的复制
请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。

 

示例 1：
输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
示例 2：

输入：head = [[1,1],[2,1]]
输出：[[1,1],[2,1]]
示例 3：


输入：head = [[3,null],[3,0],[3,null]]
输出：[[3,null],[3,0],[3,null]]
示例 4：

输入：head = []
输出：[]
解释：给定的链表为空（空指针），因此返回 null。
 
提示：

-10000 <= Node.val <= 10000
Node.random 为空（null）或指向链表中的节点。
节点数目不超过 1000 。
 

注意：本题与主站 138 题相同：https://leetcode-cn.com/problems/copy-list-with-random-pointer/
*/

//Java
//Author:Joey
//Date：2020/08/06

/*
解题思路:
参考：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/solution/jian-zhi-offer-35-fu-za-lian-biao-de-fu-zhi-by-132/ 
*/

//时间复杂度: O(n), 空间复杂度：O(n)

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    public Node copyRandomList(Node head) {
        cloneNodes(head);
        connectSiblingNode(head);
        return reconnectNodes(head);
    }

    void cloneNodes(Node head){
        Node node = head;
        while(node != null){
            Node cloned = new Node(head.val);
            cloned.val = node.val;
            cloned.next = node.next;
            cloned.random = null;

            node.next = cloned;
            node = cloned.next;
        }
    }

    void connectSiblingNode(Node head){
        Node node = head;
        while(node != null){
            Node cloned = node.next;
            if(node.random != null){
                cloned.random = node.random.next;
            }
            node = cloned.next;
        }
    }

    Node reconnectNodes(Node head){
        Node node = head;
        Node clonedHead = null;
        Node clonedNode = null;

        if(node != null){
            clonedHead = clonedNode = node.next;
            node.next = clonedNode.next;
            node = node.next;
        }

        while(node != null){
            clonedNode.next = node.next;
            clonedNode = clonedNode.next;
            node.next = clonedNode.next;
            node = node.next;
        }

        return clonedHead;
    }
}