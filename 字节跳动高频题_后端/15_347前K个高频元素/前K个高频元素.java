/*
347. 前 K 个高频元素
给定一个非空的整数数组，返回其中出现频率前 k 高的元素。

 

示例 1:

输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]
示例 2:

输入: nums = [1], k = 1
输出: [1]
 

提示：

你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
你可以按任意顺序返回答案。
*/

/*
解题思路:使用到HashMap和优先队列
先统计出元素个数，然后按次次数高低依次入队列
最后保留前K个元素，再依次弹出，保存到数组中，并翻转顺序即为结果
参考：https://leetcode-cn.com/problems/top-k-frequent-elements/solution/qian-k-ge-gao-pin-yuan-su-by-leetcode/
*/

//Java
//Author:Joey
//Date：2020/07/15

/*
执行结果：
一直报错：
Line 7: error: incompatible types: List<Integer> cannot be converted to int[] [in __Driver__.java]
      int[] ret = new Solution().topKFrequent(param_1, param_2);
不知何解，，，感觉代码正确
*/

// Author: Huahua
// Running time: 56 ms
class Solution {
  public List<Integer> topKFrequent(int[] nums, int k) {    
    Map<Integer, Integer> counts = new HashMap<>();  //用来存放元素个数统计结果
    for (int num : nums)
      counts.put(num, counts.getOrDefault(num, 0) + 1);  //getOrDefault---有value取value没value则置入0   
    
    PriorityQueue<int[]> queue = new PriorityQueue<>((x, y) -> x[0] - y[0]);  //优先队列保证每次取出元素都是队列中权值最小的
    for (Integer num : counts.keySet()) {  //获取Key值  迭代器
      queue.offer(new int[]{counts.get(num), num});  //也可以用add，数组中存放  数值出现次数和数值
      if (queue.size() > k) queue.poll();  //再将超出k个范围的值弹出
    }
        
    List<Integer> ans = new ArrayList<>();  //存放结果
    for (int i = 0; i < k; ++i)
      ans.add(queue.poll()[1]);  //倒序存放结果
    return ans;    
  }
}