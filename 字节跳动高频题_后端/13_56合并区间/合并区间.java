/*
56. 合并区间
给出一个区间的集合，请合并所有重叠的区间。

示例 1:

输入: [[1,3],[2,6],[8,10],[15,18]]
输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例 2:

输入: [[1,4],[4,5]]
输出: [[1,5]]
解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
*/

//解题思路：先将数组按元素左端点排列，再循环遍历合并

//Java
//Author:Joey
//Date：2020/07/13

/*
执行结果：
执行用时：14 ms, 在所有 Java 提交中击败了11.05%的用户
内存消耗：42.6 MB, 在所有 Java 提交中击败了35.61%的用户
*/

class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n < 2) return intervals;
        List<int[]> res = new ArrayList<int[]>();

        Arrays.sort(intervals, Comparator.comparingInt(a->a[0]));  排列

        for (int i = 0 ; i < n -1; i++) {
            if (intervals[i][1] >= intervals[i+1][0]) {
                intervals[i+1][0] = intervals[i][0];
                intervals[i+1][1] = Math.max(intervals[i][1], intervals[i+1][1]);
            } else {
                res.add(intervals[i]);
            }
        }
        res.add(intervals[n-1]);
        return res.toArray(new int[res.size()][2]);

    }
}

//修改版：

/*
执行结果：
执行用时：82 ms, 在所有 Java 提交中击败了5.08%的用户
内存消耗：42.1 MB, 在所有 Java 提交中击败了42.46%的用户
*/

class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n < 2) return intervals;
        List<int[]> res = new ArrayList<int[]>();

        for (int i = 0; i < n-1; i++) {  //自己写冒泡排序
            for(int j = i+1; j < n; j++) {
                if (intervals[i][0] > intervals[j][0]) {
                    int temp_0 = intervals[i][0];
                    int temp_1 = intervals[i][1];
                    intervals[i][0] = intervals[j][0];
                    intervals[i][1] = intervals[j][1];
                    intervals[j][0] = temp_0;
                    intervals[j][1] = temp_1;                    
                }
            }
        }

        for (int i = 0 ; i < n -1; i++) {
            if (intervals[i][1] >= intervals[i+1][0]) {
                intervals[i+1][0] = intervals[i][0];
                intervals[i+1][1] = Math.max(intervals[i][1], intervals[i+1][1]);
            } else {
                res.add(intervals[i]);
            }
        }
        res.add(intervals[n-1]);
        return res.toArray(new int[res.size()][2]);

    }
}