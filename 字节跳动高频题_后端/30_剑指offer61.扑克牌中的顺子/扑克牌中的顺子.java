/*
剑指 Offer 61. 扑克牌中的顺子
从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。

 

示例 1:

输入: [1,2,3,4,5]
输出: True
 

示例 2:

输入: [0,0,1,2,5]
输出: True
*/

//Java
//Author:Joey
//Date：2020/07/22

//解题思路：排序，统计0的个数

/*
执行结果：
执行用时：1 ms, 在所有 Java 提交中击败了89.50%的用户
内存消耗：37.4 MB, 在所有 Java 提交中击败了100.00%的用户
*/

class Solution {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int flag = 0; //统计0的个数
        for (int i = 0; i < 4; i++) {
            if (nums[i] == 0) {
                flag++;
                continue;
            }
            if (nums[i] < nums[i+1]) {
                if (nums[i+1] - nums[i] == 1) continue;
                if (nums[i+1] - nums[i] - 1 <= flag) continue;
                return false;
            }
            return false;
        }
        return true;
    }
}