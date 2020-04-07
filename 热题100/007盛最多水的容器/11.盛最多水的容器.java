/**
11.盛最多水的容器
给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点?(i,?ai) 。在坐标内画 n 条垂直线，垂直线 i?的两个端点分别为?(i,?ai) 和 (i, 0)。找出其中的两条线，使得它们与?x?轴共同构成的容器可以容纳最多的水。

说明：你不能倾斜容器，且?n?的值至少为 2。

垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水的最大值为?49。


示例：

输入：[1,8,6,2,5,4,8,3,7]
输出：49

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/container-with-most-water
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
**/

//Java 
//- * - coding：utf-8 - * -
//Author:JoeyChen
//Data:2020/04/07

//方法一；暴力解题
/**
解题思路：
循环嵌套
**/

/**
执行结果：
执行用时 :848 ms, 在所有 Java 提交中击败了5.04%的用户
内存消耗 :40.3 MB, 在所有 Java 提交中击败了19.05%的用户
**/

class Solution {
    public int maxArea(int[] height) {
        //暴力解法
        if (height == null || height.length<= 1) return 0;
        int maxArea = 0;
        for (int i = 0; i < height.length -1; i ++) {
            for (int j = i + 1; j < height.length; j ++) {
                maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
            }

        }
        return maxArea;

    }
}

//方法二：双指针
/**
解题思路：
	利用双指针分别指向数组首尾，并按照将指向较短线段的指针向较长线段的那端移动。
**/

/**
执行结果：
执行用时 :4 ms, 在所有 Java 提交中击败了75.52%的用户
内存消耗 :39.9 MB, 在所有 Java 提交中击败了64.44%的用户
**/

class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) return 0;
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left ++;
            } else {
                right --;
            }
        }
        return maxArea;

    }
}