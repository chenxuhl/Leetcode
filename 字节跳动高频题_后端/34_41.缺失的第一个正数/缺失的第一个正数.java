/*
41. 缺失的第一个正数
给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。

示例 1:

输入: [1,2,0]
输出: 3
示例 2:

输入: [3,4,-1,1]
输出: 2
示例 3:

输入: [7,8,9,11,12]
输出: 1
 

提示：

你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
*/

//Java
//Author:Joey
//Date：2020/07/24

//方法一：最小正整数，从1开始


/*
执行结果：
执行用时：1 ms, 在所有 Java 提交中击败了87.73%的用户
内存消耗：37.7 MB, 在所有 Java 提交中击败了8.33%的用户
*/

class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);  //先排序
        int n = nums.length;

        int res = 1;  //最小正整数
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) continue;
            if (nums[i] == res) {
                res++;
                continue;
            }
        }
        return res;
    }
}


//方法二：参考官方解题：不排序，置换

/*
执行结果：
执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：37.3 MB, 在所有 Java 提交中击败了8.33%的用户
*/

class Solution {
    public int firstMissingPositive(int[] nums) {  //不排序
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i]-1] != nums[i]) {  //循环，直至当前位置元素与其他位置都不符
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != (i + 1)) return i + 1;  //返回元素与位置不符的元素
        }
        return n + 1;
    }
}