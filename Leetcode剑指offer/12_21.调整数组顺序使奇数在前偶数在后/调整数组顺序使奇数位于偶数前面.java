/*
剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。

 

示例：

输入：nums = [1,2,3,4]
输出：[1,3,2,4] 
注：[3,1,2,4] 也是正确的答案之一。
 

提示：

1 <= nums.length <= 50000
1 <= nums[i] <= 10000
*/

//Java
//Author:Joey
//Date：2020/07/30

//解题思路: 双指针


//时间复杂度: O(n), 空间复杂度：O(n)

class Solution {
    public int[] exchange(int[] nums) {  //使用到额外数组空间
        if (nums.length < 2) return nums;
        int n = nums.length;
        int left = 0, right = n - 1;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 1) {
                res[left] = nums[i];
                left++;
            }
            else {
                res[right] = nums[i];
                right--;
            }
        }
        return res;
    }
}


//优化版：参考评论区，使用快慢指针

//时间复杂度: O(n), 空间复杂度：O(1)

class Solution {
    public int[] exchange(int[] nums) {
        if (nums.length < 2) return nums;
        int n = nums.length;
        int slow = 0;  //慢指针
        while (slow < n && nums[slow] % 2 != 0) {
            //找到第一个偶数
            slow++;
        }
        int fast = slow + 1;  //快指针
        while (fast < n) {
            if (nums[fast] % 2 != 0) {
                //找到奇数交换
                swap(nums, fast, slow);
                slow++;
            }
            fast++;
        }
        return nums;
    }
    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}