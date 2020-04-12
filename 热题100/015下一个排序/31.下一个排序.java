/**
31.下一个排序
实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

必须原地修改，只允许使用额外常数空间。

以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/next-permutation
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
**/

//Java
//-*- coding:utf-8 -*-
//JoeyChen
//2020/04/11

//方法一：

/**
解题思路：
从右往左遍历数组，找到第一个不满足递减的数，在其右侧找到与其相邻且大于其的数，并交换位置；
交换后的右侧数组进行升序排列
参考：https://blog.csdn.net/qq_41645636/article/details/98349631
**/

/**
执行结果：
执行用时 :1 ms, 在所有 Java 提交中击败了99.62%的用户
内存消耗 :39.8 MB, 在所有 Java 提交中击败了48.12%的用户
**/

class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        while (i > 0 && nums[i-1] >= nums[i]) {
            i--;
        }
        if (i > 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i-1]) {
                j--;
            }
            swap(nums, i-1 , j);
            }        
        reverse(nums, i);

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int i) {
        int j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}