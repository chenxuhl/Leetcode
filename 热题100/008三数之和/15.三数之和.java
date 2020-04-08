/**
15.三数之和
给你一个包含 n 个整数的数组?nums，判断?nums?中是否存在三个元素 a，b，c ，使得?a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。

?

示例：

给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/3sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
**/

//Java 
//- * - coding：utf-8 - * -
//Author:JoeyChen
//Data:2020/04/08

//方法一：先排序，转化为两数和问题，使用双指针解题
/**
解题思路：
双指针，类似11题解法
**/

/**
执行结果：
执行用时 :24 ms, 在所有 Java 提交中击败了85.17%的用户
内存消耗 :43.4 MB, 在所有 Java 提交中击败了99.81%的用户
**/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);  //排序---从小到大
        List<List<Integer>> res = new ArrayList<>();  //新建列表存放结果
        for (int i = 0; i < nums.length -2; i++) {
            if (i>0 && nums[i] == nums[i-1]) continue;  //去重，避免重复三元组
            int left = i + 1, right = nums.length - 1, sum = 0 - nums[i];
            while (left < right) {
                if (nums[left] + nums[right] == sum) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left+1]) left++;  //去重，避免重复三元组
                    while (left < right && nums[right] == nums[right-1]) right--;  //去重，避免重复三元组
                    left++;
                    right--;
                    
                } else if (nums[left] + nums[right] < sum) left++;
                else right--;
            }
        }
        return res;

    }
}

//方法二：Java最优解法(目前没有看懂)

/**
执行结果：执行用时 :8 ms, 在所有 Java 提交中击败了99.99%的用户
内存消耗 :44 MB, 在所有 Java 提交中击败了98.78%的用户
**/