/**
46.全排列
给定一个 没有重复 数字的序列，返回其所有可能的全排列。

示例:

输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/permutations
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
**/

//Java 
//- * - coding：utf-8 - * -
//Author:JoeyChen
//Data:2020/04/17

//方法一：回溯法

/**
执行结果：
执行用时 :2 ms, 在所有 Java 提交中击败了78.96%的用户
内存消耗 :40.3 MB, 在所有 Java 提交中击败了7.32%的用户
**/

class Solution {
  public void backtrack(int n,
                        ArrayList<Integer> nums,
                        List<List<Integer>> output,
                        int first) {
    // 递归出口
    if (first == n)
      output.add(new ArrayList<Integer>(nums));
    for (int i = first; i < n; i++) {
      Collections.swap(nums, first, i);
      backtrack(n, nums, output, first + 1);
	  //还原
      Collections.swap(nums, first, i);
    }
  }

  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> output = new LinkedList();

    // 将数组转化成列表
    ArrayList<Integer> nums_lst = new ArrayList<Integer>();
    for (int num : nums)
      nums_lst.add(num);

    int n = nums.length;
    backtrack(n, nums_lst, output, 0);
    return output;
  }
}