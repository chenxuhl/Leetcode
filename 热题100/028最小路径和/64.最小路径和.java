/**
 * 64.��С·����
 * ����һ�������Ǹ������� m?x?n?�������ҳ�һ�������Ͻǵ����½ǵ�·����ʹ��·���ϵ������ܺ�Ϊ��С��
 * <p>
 * ˵����ÿ��ֻ�����»��������ƶ�һ����
 * <p>
 * ʾ��:
 * <p>
 * ����:
 * [
 * ? [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * ���: 7
 * ����: ��Ϊ·�� 1��3��1��1��1 ���ܺ���С��
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/minimum-path-sum
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * <p>
 * ����˼·������62�ⲻͬ·����ʹ�ö�̬�滮������洢����ά�����С��������½Ƿ���
 * ֻ�����������ϲⷽ�񵽴��ֻ�����н�Сֵ�͵�ǰ������ֵ��ӣ���Ϊ��ǰ·�������ֺ���С
 **/

//Java 
//- * - coding��utf-8 - * -
//Author:JoeyChen
//Data:2020/04/23

//����һ����̬�滮

/**
 ����˼·������62�ⲻͬ·����ʹ�ö�̬�滮������洢����ά�����С��������½Ƿ���
 ֻ�����������ϲⷽ�񵽴��ֻ�����н�Сֵ�͵�ǰ������ֵ��ӣ���Ϊ��ǰ·�������ֺ���С
 **/

/**
 ִ�н����
 ִ����ʱ :3 ms, ������ Java �ύ�л�����89.37%���û�
 �ڴ����� :42.3 MB, ������ Java �ύ�л�����31.82%���û�
 **/

class Solution {
    public int minPathSum(int[][] grid) {
        //�ж��Ƿ�Ϊ��
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        if (n == 0) return 0;
        //��ʼ��res��Ž��
        int[][] res = new int[m][n];
        //��ʼ��res
        res[0][0] = grid[0][0];
        //res��һ�и�ֵ
        for (int i = 1; i < m; i++) {
            res[i][0] = res[i - 1][0] + grid[i][0];
        }
        //res��һ�и�ֵ
        for (int j = 1; j < n; j++) {
            res[0][j] = res[0][j - 1] + grid[0][j];
        }
        //res���帳ֵ
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                res[i][j] = Math.min(res[i - 1][j], res[i][j - 1]) + grid[i][j];
            }
        }
        return res[m - 1][n - 1];  //���ؽ��

    }
}

//�򻯰�
class Solution {
    public int minPathSum(int[][] grid) {
        //�ж��Ƿ�Ϊ��
        int m = grid.length;  //��
        int n = grid[0].length;  //��
        //��Ž��
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) res[i][j] = grid[i][j];
                else if (i == 0 && j != 0) res[i][j] = res[i][j - 1] + grid[i][j];
                else if (i != 0 && j == 0) res[i][j] = res[i - 1][j] + grid[i][j];
                else res[i][j] = Math.min(res[i - 1][j], res[i][j - 1]) + grid[i][j];
            }
        }
        return res[m - 1][n - 1];

    }
}