/*
剑指 Offer 11. 旋转数组的最小数字
把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  

示例 1：

输入：[3,4,5,1,2]
输出：1
示例 2：

输入：[2,2,2,0,1]
输出：0
注意：本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
*/

//Java
//Author:Joey
//Date：2020/07/28

//解题思路: 二分查找


//时间复杂度: O(n), 空间复杂度：O(n)

class Solution {
    public int minArray(int[] numbers) {
        if (numbers.length == 0) return Integer.MIN_VALUE;
        if (numbers.length == 1) return numbers[0];
        if (numbers.length == 2) return Math.min(numbers[0], numbers[1]);
        int n = numbers.length;
        int left = 0, right = n -1;
        while (left < right) {
            int mid = (right + left) / 2;
            if (numbers[mid] > numbers[right]) left = mid+1;
            else if (numbers[mid] < numbers[right]) right = mid;  //不能是mid-1,mid处也可能是最小值
            else right--;  //相等的情况
        }
        return numbers[left];
    }
}