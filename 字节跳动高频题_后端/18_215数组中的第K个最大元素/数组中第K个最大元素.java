/*
215. 数组中的第K个最大元素
在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

示例 1:

输入: [3,2,1,5,6,4] 和 k = 2
输出: 5
示例 2:

输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
输出: 4
说明:

你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
*/



//解题思路:改进冒泡排序

//Java
//Author:Joey
//Date：2020/07/16

/*
执行结果：
执行用时：46 ms, 在所有 Java 提交中击败了7.41%的用户
内存消耗：40 MB, 在所有 Java 提交中击败了6.12%的用户
*/

class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        for (int i = 0; i < k; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] < nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;  //最大的放前面，从大到小排序
                }
            }
        }
        return nums[k-1];

    }
}

//官方解题：基于快排
//最优时间复杂度O(nlog(n)),最差情况时间复杂度O( n^2 ),平均时间复杂度：O(nlogn)
//最优的情况下空间复杂度为：O(logn)  ；每一次都平分数组的情况
//最差的情况下空间复杂度为：O( n )；退化为冒泡排序的情况
//参考链接：https://www.bilibili.com/video/BV1vx411d77a?from=search&seid=10962708530911812212
//https://leetcode-cn.com/problems/kth-largest-element-in-an-array/solution/shu-zu-zhong-de-di-kge-zui-da-yuan-su-by-leetcode-/

/*
执行结果：
执行用时：1 ms, 在所有 Java 提交中击败了99.47%的用户
内存消耗：39.8 MB, 在所有 Java 提交中击败了6.12%的用户
*/

class Solution {
    Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    public int quickSelect(int[] a, int l, int r, int index) {
        int q = randomPartition(a, l, r);
        if (q == index) {
            return a[q];
        } else {
            return q < index ? quickSelect(a, q + 1, r, index) : quickSelect(a, l, q - 1, index);
        }
    }

    public int randomPartition(int[] a, int l, int r) {
        int i = random.nextInt(r - l + 1) + l;
        swap(a, i, r);
        return partition(a, l, r);
    }

    public int partition(int[] a, int l, int r) {
        int x = a[r], i = l - 1;
        for (int j = l; j < r; ++j) {
            if (a[j] <= x) {
                swap(a, ++i, j);
            }
        }
        swap(a, i + 1, r);
        return i + 1;
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
//没看懂