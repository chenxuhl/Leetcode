/**
 * 56.�ϲ�����
 * ����һ������ļ��ϣ���ϲ������ص������䡣
 * <p>
 * ʾ�� 1:
 * <p>
 * ����: [[1,3],[2,6],[8,10],[15,18]]
 * ���: [[1,6],[8,10],[15,18]]
 * ����: ���� [1,3] �� [2,6] �ص�, �����Ǻϲ�Ϊ [1,6].
 * ʾ��?2:
 * <p>
 * ����: [[1,4],[4,5]]
 * ���: [[1,5]]
 * ����: ���� [1,4] �� [4,5] �ɱ���Ϊ�ص����䡣
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/merge-intervals
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * <p>
 * ����˼·��
 * �Ȱ���ÿ��������˵�������������αȽ�����������˵���Ҷ˵��С�����кϲ�����
 **/

//Java 
//- * - coding��utf-8 - * -
//Author:JoeyChen
//Data:2020/04/22

/**
 ����˼·��
 �Ȱ���ÿ��������˵�������������αȽ�����������˵���Ҷ˵��С�����кϲ�����
 **/

/**
 ִ�н����
 ִ����ʱ :9 ms, ������ Java �ύ�л�����53.54%���û�
 �ڴ����� :42.1 MB, ������ Java �ύ�л�����42.46%���û�
 **/

class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n < 2) return intervals;
        //����ÿ��������˵��������
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        //��Ž��
        List<int[]> res = new ArrayList<>();
        //��������
        for (int i = 0; i < n - 1; i++) {
            if (intervals[i][1] >= intervals[i + 1][0]) {
                intervals[i + 1][0] = intervals[i][0];
                intervals[i + 1][1] = Math.max(intervals[i][1], intervals[i + 1][1]);
            } else {
                res.add(intervals[i]);
            }
        }
        res.add(intervals[n - 1]);  //���������������һ������
        return res.toArray(new int[res.size()][2]);  //�б�ת��Ϊ����󷵻�

    }
}