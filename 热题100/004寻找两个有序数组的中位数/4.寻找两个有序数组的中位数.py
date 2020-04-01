#题目描述：
"""
给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。

请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

你可以假设 nums1 和 nums2 不会同时为空。

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
"""

#解题思路：
"""
由于时间复杂度的限制，考虑二分查找法的思想去解题
"""

#python
#Author: JoeyChen
#data:2019.12.03
#runtime：执行用时 :72 ms, 在所有 python 提交中击败了99.23%的用户
#memory: 内存消耗 :11.9 MB, 在所有 python 提交中击败了27.75%的用户
class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        m = len(nums1)
        n = len(nums2)
        if m > n:   #使得数组内元素少的在前
            nums1, nums2, m, n = nums2, nums1, n, m 
        if n == 0: #若都为空，则报错
            raise ValueError
        k = (m + n + 1) // 2 #需要取的中位数的次序
        i = 0  #nums1的断点处
        j = 0  #nums2的断点处
        i_left = 0  #二分查找的左右边界
        i_right = m 
        
        while i_left <= i_right: #循环终止条件
            i = (i_left + i_right) // 2  #取左右边界的中间值 相当于(i_right - i_left) // 2 + i_left
            j = k - i   #在nums2中的断点
            if i < m and nums1[i] < nums2[j-1]: #nums1断点右值小于nums2断点左边值，i断点需要右移
                i_left = i + 1
            elif i > 0 and nums1[i-1] > nums2[j]:# nums1断点左值大于nums2断点右边值，i断点需要左移
                i_right = i - 1
            else:
                if i == 0:  #断点只在nums2中取的，也即是nums1中所有值都大于中位数
                    max_of_left = nums2[j-1]
                elif j == 0:  #断点只在nums1中取，也即是nums2中所有值皆大于中位数
                    max_of_left = nums1[i-1]
                else:  #否则，取nums1和nums2断点左边值的最大
                    max_of_left = max(nums1[i-1], nums2[j-1])
                if (m + n) % 2 == 1: #若总数组长度为奇，即是中位数
                    return max_of_left

                if i == m:  #nums1中数全都小于中位数，故全都位于左侧
                    min_of_right = nums2[j]
                elif j == n: #nums2中所有值全都小于中位数，故全都位于中位数左侧
                    min_of_right = nums1[i]
                else:  #若不然，取nums1和nums2断点的有边界最小值
                    min_of_right = min(nums1[i], nums2[j])
                return (max_of_left + min_of_right) / 2.0  #数组总长度为偶数，故中位数为中间两数平均值