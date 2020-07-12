/*
88. 合并两个有序数组
给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。

 

说明:

初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 

示例:

输入:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

输出: [1,2,2,3,5,6]
*/

//解题思路：借助一个数组复制nums1，双指针逐个元素对比，数值小的放到nums1中

//Java
//Author:Joey
//Date：2020/07/12

/*
执行结果：
执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：39.7 MB, 在所有 Java 提交中击败了5.06%的用户
*/
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);  //复制nums1到nums1_copy

        int p1 = 0, p2 = 0, p = 0;  //双指针p1和p2

        while ((p1<m) && (p2<n)) {
            nums1[p++] = (nums1_copy[p1] > nums2[p2]) ? nums2[p2++] : nums1_copy[p1++];  //先执行后加加
        }

        if (p1<m) {
            System.arraycopy(nums1_copy, p1, nums1, p1+p2, m+n-p1-p2);
        }
        if (p2<n) {
            System.arraycopy(nums2, p2, nums1, p1+p2, m+n-p1-p2);
        }
    }
}

