/**
4.寻找两个有序数组的中位数
给定两个大小为 m 和 n 的有序数组?nums1 和?nums2。

请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为?O(log(m + n))。

你可以假设?nums1?和?nums2?不会同时为空。

示例 1:

nums1 = [1, 3]
nums2 = [2]

则中位数是 2.0
示例 2:

nums1 = [1, 2]
nums2 = [3, 4]

则中位数是 (2 + 3)/2 = 2.5

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
**/
/**
解题思路：
根据时间复杂度限制，考虑使用二分法。
将有序数组A 和 B分别进行分割：Left_A Right_A 和 Left_B ,Right_B
Left_part 包括 Left_A 和 Left_B
Right_part 包括 Right_A 和 Right_B
中位数= （左边部分最大值+右边部分最小值）/ 2
其中还要分奇偶以及特殊情况：nums1或nums2全在左边部分或右边部分；
**/
//Java 
//- * - coding：utf-8 - * -
//Author:JoeyChen
//Data:2020/04/04
/**
执行结果：
执行用时 :2 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗 :40.4 MB, 在所有 Java 提交中击败了98.89%的用户
**/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m>n) {
            int[] temp = nums1;nums1 = nums2;nums2 = temp;
            int templenght = m; m = n;n = templenght;
        }
        int imin = 0,imax = m,half = (m+n+1)/2;
        while (imin<=imax) {
            int i = (imax+imin)/2;
            int j = half-i;
            //i过小且i可以再增大
            if(i<imax && nums2[j-1]>nums1[i]) {
                imin = i + 1;
            }
            //i过大且i可以再减小
            else if(i>imin && nums1[i-1]>nums2[j]) {
                imax = i - 1;
            }
            else {
                int leftmax = 0;
				// left_num1为空时
                if(i==0) {
                    leftmax = nums2[j-1];
                }
				//left_num2为空时
                else if(j==0) {
                    leftmax = nums1[i-1];
                }
                else {
                    leftmax = Math.max(nums1[i-1],nums2[j-1]);
                }
                if((m+n)%2 == 1) return leftmax;

                int rightmin = 0;
				 // right_num1为空时
                if(i==m) {
                    rightmin = nums2[j];
                }
				 // right_num2为空时
                else if(j==n) {
                    rightmin = nums1[i];
                }
                else {
                    rightmin = Math.min(nums1[i],nums2[j]);
                }
                return (leftmax + rightmin) / 2.0;
            }
        }
        return 0.0;

    }
}