/*
剑指 Offer 39. 数组中出现次数超过一半的数字
数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。

 

你可以假设数组是非空的，并且给定的数组总是存在多数元素。

 

示例 1:

输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
输出: 2
 

限制：

1 <= 数组长度 <= 50000

 

注意：本题与主站 169 题相同：https://leetcode-cn.com/problems/majority-element/
*/

//Java
//Author:Joey
//Date：2020/08/13

//解题思路：先排序，再统计

//时间复杂度：O(n^2), 空间复杂度：O(1)

class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int res = nums[0];
        Arrays.sort(nums);
        int flag = 0;
        for (int i = 0; i < n-1; i++) {
            if (nums[i] == nums[i+1]) {
                flag++;
                if (flag >= n / 2) {
                    res = nums[i];
                    break;
                }
            } else {
                flag = 0;
            }
        }
        return res;
    }
}