/**
55.跳跃游戏
给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

判断你是否能够到达最后一个位置。

示例?1:

输入: [2,3,1,1,4]
输出: true
解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
示例?2:

输入: [3,2,1,0,4]
输出: false
解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/jump-game
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
**/

//Java 
//- * - coding：utf-8 - * -
//Author:JoeyChen
//Data:2020/04/20

//方法一：贪心法

/**
执行结果：
执行用时 :2 ms, 在所有 Java 提交中击败了69.88%的用户
内存消耗 :41.5 MB, 在所有 Java 提交中击败了14.06%的用户
**/

class Solution {
    public boolean canJump(int[] nums) {
        int ultraright= 0;  //所能到达最远右端
        for (int i = 0; i < nums.length; i++) {
            if (i <= ultraright) {  //i在能到达的最远右端之内才可以继续进行
                ultraright = Math.max(ultraright, i + nums[i]);  //更新右端最远点
                if (ultraright >= nums.length -1) return true;  //判断是否满足条件，若满足提前结束循环
            }
        }
        return false;  //若遍历完后仍不满足，则返回false

    }
}
