/**
 * 75.颜色分类
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 *
 * 示例:
 *
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * 进阶：
 *
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/

//Java
//- * - coding：utf-8 - * -
//Author:JoeyChen
//Data:2020/04/25

//方法一：普通解法---直接冒泡排序即可

/**
 * 执行结果：
 * 执行用时 :1 ms, 在所有 Java 提交中击败了14.99%的用户
 * 内存消耗 :37.9 MB, 在所有 Java 提交中击败了6.67%的用户
 **/

class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        if (n == 0 || n == 1) return;
        for (int i = 0; i < n -1; i++) {
            for (int j = i+1; j < n; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
}

//方法二：使用三指针一次遍历完成排序

/**
 *解题思路：三个指针curr，p0， p2初始分别指向数组头，和数组末尾
 * p0：终点为0的最右
 * p2：终点为2的最左
 * curr：当前遍历位置
 * 当curr > p2则遍历结束
 */

/**
 *执行结果：
 * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗 :38.2 MB, 在所有 Java 提交中击败了6.67%的用户
 */

class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;  //数组长度
        int p0 = 0, p2 = n -1, curr = 0;  //初始化位置
        while (curr <= p2) {  //遍历终止条件
            if (nums[curr] == 2) {   //数字2放最右,并将p2左移一位
                swap(nums, curr, p2);
                p2--;
            }
            else if (nums[curr] == 1) curr++;  //数字1位置不变
            else {  //数字0放最左，并将p0，curr共同右移一位
                swap(nums, curr, p0);
                p0++;
                curr++;
            }
        }
    }

    //交换数组中数位置
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}

