/**
42.接雨水
给定?n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。?感谢 Marcos 贡献此图。

示例:

输入: [0,1,0,2,1,0,1,3,2,1,2,1]
输出: 6

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/trapping-rain-water
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
**/

//Java 
//- * - coding：utf-8 - * -
//Author:JoeyChen
//Data:2020/04/17

//方法一：暴力求解法

/**
解题思路：对每一个元素，找到其左右的最大值，其左右最大值中的最小值和此元素构成的条形面积，即为容水量
最终结果为所有条状图的面积总和；
**/

/**
执行结果：
执行用时 :91 ms, 在所有 Java 提交中击败了8.57%的用户
内存消耗 :39.4 MB, 在所有 Java 提交中击败了12.86%的用户
**/

class Solution {
    public int trap(int[] height) {
        int res = 0;
        for (int i = 1; i < height.length; i++) {
            int max_left = 0, max_right = 0;
            for (int j = i; j >= 0; j--) { //寻找左侧最大值
                max_left = Math.max(max_left, height[j]);
            }
            for (int j = i; j < height.length; j++) {  //寻找右侧最大值
                max_right = Math.max(max_right, height[j]);
            }

            res += Math.min(max_left, max_right) - height[i];  //结果的累加
        }
        return res;

    }
}

//方法二：动态规划，空间换时间

/**
解题思路：相较于法一暴力解题，利用数组将每个元素左右侧最大值存储起来，待使用时可直接使用，而不用循环嵌套
**/

/**
执行结果:
执行用时 :1 ms, 在所有 Java 提交中击败了99.99%的用户
内存消耗 :39.3 MB, 在所有 Java 提交中击败了12.86%的用户炫耀一下:
**/

class Solution {
    public int trap(int[] height) {
        //动态规划，空间换时间
        int res = 0;
        int len = height.length;
        //特殊情况
        if (height == null || len == 0) {
            return res;
        }
        int[] max_left = new int[len];
        int[] max_right = new int[len];
        //存储元素左侧最大值
        max_left[0] = height[0];
        for (int i = 1; i < len; i++) {
            max_left[i] = Math.max(max_left[i-1], height[i]);
        }
        //存储元素右侧最大值
        max_right[len-1] = height[len-1];
        for (int j = len-2; j >= 0; j--) {
            max_right[j] = Math.max(max_right[j+1], height[j]);
        }
        for (int k = 0; k < len; k++) {
            res += Math.min(max_left[k], max_right[k]) - height[k];
        }
        return res;

    }
}


//方法三：双指针

/**
解题思路：动态规划思想的基础上使用双指针，不用存储数组中，只需要存储左右各一个最大值即可
参考：https://leetcode-cn.com/problems/trapping-rain-water/solution/jie-yu-shui-by-leetcode/
**/

/**
执行结果：
执行用时 :1 ms, 在所有 Java 提交中击败了99.99%的用户
内存消耗 :39.3 MB, 在所有 Java 提交中击败了12.86%的用户
**/

class Solution {
    public int trap(int[] height) {
        int res = 0;
        if (height == null || height.length == 0) return res;
        int max_left = 0, max_right = 0;
        int left = 0, right = height.length -1;
        while (left <= right) {
            if (max_left < max_right) {  //左边小，左边取
                if (height[left] >= max_left) {
                    max_left = height[left];
                } else {
                    res += (max_left - height[left]);
                }
                left++;
            } else {  //右边小，右边取
                if (height[right] >= max_right) {
                    max_right = height[right];
                } else {
                    res += (max_right - height[right]);
                }
                right--;
            }
        }
        return res;

    }
}

