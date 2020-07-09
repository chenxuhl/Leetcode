/*
146. LRU缓存机制
运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。

获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。

 

进阶:

你是否可以在 O(1) 时间复杂度内完成这两种操作？

 

示例:

LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // 返回  1
cache.put(3, 3);    // 该操作会使得关键字 2 作废
cache.get(2);       // 返回 -1 (未找到)
cache.put(4, 4);    // 该操作会使得关键字 1 作废
cache.get(1);       // 返回 -1 (未找到)
cache.get(3);       // 返回  3
cache.get(4);       // 返回  4
*/

//解题思路：https://leetcode-cn.com/problems/lru-cache/solution/lruhuan-cun-ji-zhi-by-leetcode-solution/

//Java
//Author:Joey
//Date：2020/07/09

/*
执行结果：
执行用时：26 ms, 在所有 Java 提交中击败了25.20%的用户
内存消耗：47.8 MB, 在所有 Java 提交中击败了100.00%的用户
*/

public class LRUCache {

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode() {}
        public DLinkedNode (int _key, int _value) {
            key = _key;
            value = _value;
        }
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();  // value就是双向链表
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;

    }
    
    public int get(int key) {
        DLinkedNode node = cache.get(key);  //HashMap自带get
        if (node == null) return -1;
        MoveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if(node == null) {
            DLinkedNode newnode = new DLinkedNode(key, value);
            cache.put(key, newnode);
            AddToHead(newnode);
            size++;
            if (size > capacity) {
                DLinkedNode tail = RemoveTail();
                cache.remove(tail.key);
                size--;
            }
        }
        else {
            node.value = value;
            MoveToHead(node);
        }

    }

    private void AddToHead(DLinkedNode node) {
        node.prev = head;
        head.next.prev = node;
        node.next = head.next;
        head.next = node;
    }

    private void RemoveNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void MoveToHead(DLinkedNode node) {
        RemoveNode(node);
        AddToHead(node);
    }

    private DLinkedNode RemoveTail() {
        DLinkedNode res = tail.prev;
        RemoveNode(res);
        return res;
    } 
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */