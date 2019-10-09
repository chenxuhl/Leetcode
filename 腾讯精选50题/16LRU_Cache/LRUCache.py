#146.LRU缓存机制
"""
题目描述：
运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。

获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，

"""
#示例：
"""
LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // 返回  1
cache.put(3, 3);    // 该操作会使得密钥 2 作废
cache.get(2);       // 返回 -1 (未找到)
cache.put(4, 4);    // 该操作会使得密钥 1 作废
cache.get(1);       // 返回 -1 (未找到)
cache.get(3);       // 返回  3
cache.get(4);       // 返回  4

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/lru-cache
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
#python3
class LRUCache:

    def __init__(self, capacity: int):
        self.capacity = capacity#缓存器的容量大小
        self.stack = list()#初始化列表，存放缓存器内容列表
        self.cache = dict()#初始化字典，HashMap,保存key和缓存器各项的迭代器之间的映射

    def get(self, key: int) -> int: #若key存在于cache中，获取key对应value，否则返回-1
        if key in self.cache:
            self.stack.remove(key)
            self.stack.append(key)
            return self.cache[key]
        return -1

    def put(self, key: int, value: int) -> None:
        if key in self.cache:
            self.stack.remove(key)
        else:
            if len(self.cache) == self.capacity:#当缓存容量达到上限时，删除最近最少使用数据值，为新数据留出空间
                del self.cache[self.stack[0]]
                self.stack.pop(0)
        self.stack.append(key)#若key不存在，写入其数据值
        self.cache[key] = value

# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)
