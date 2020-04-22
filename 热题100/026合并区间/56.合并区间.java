/**
56.合并区间
给出一个区间的集合，请合并所有重叠的区间。

示例 1:

输入: [[1,3],[2,6],[8,10],[15,18]]
输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例?2:

输入: [[1,4],[4,5]]
输出: [[1,5]]
解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-intervals
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
**/

//Java 
//- * - coding：utf-8 - * -
//Author:JoeyChen
//Data:2020/04/22

/**
解题思路：
先按照每个数组左端点进行排序，再依次比较相邻数组左端点和右端点大小，进行合并操作
**/

/**
执行结果：
执行用时 :9 ms, 在所有 Java 提交中击败了53.54%的用户
内存消耗 :42.1 MB, 在所有 Java 提交中击败了42.46%的用户
**/

class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if  (n < 2) return intervals;
        //按照每个数组左端点进行排序
        Arrays.sort(intervals, Comparator.comparingInt(a->a[0]));
		//存放结果
        List<int[]> res = new ArrayList<>();
		//遍历数组
        for (int i = 0; i < n -1; i++) {
            if (intervals[i][1] >= intervals[i+1][0]) {
                intervals[i+1][0] = intervals[i][0];
                intervals[i+1][1] = Math.max(intervals[i][1], intervals[i+1][1]);
            } else {
                res.add(intervals[i]);
            }
        }
        res.add(intervals[n-1]);  //遍历完后，添加上最后一个数组
        return res.toArray(new int[res.size()][2]);  //列表转换为数组后返回

    }
}