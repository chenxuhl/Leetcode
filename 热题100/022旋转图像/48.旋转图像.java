/**
 * 48.��תͼ��
 * ����һ�� n?��?n �Ķ�ά�����ʾһ��ͼ��
 * <p>
 * ��ͼ��˳ʱ����ת 90 �ȡ�
 * <p>
 * ˵����
 * <p>
 * �������ԭ����תͼ������ζ������Ҫֱ���޸�����Ķ�ά�����벻Ҫʹ����һ����������תͼ��
 * <p>
 * ʾ�� 1:
 * <p>
 * ���� matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * <p>
 * ԭ����ת�������ʹ���Ϊ:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * ʾ�� 2:
 * <p>
 * ���� matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * <p>
 * ԭ����ת�������ʹ���Ϊ:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/rotate-image
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 **/

//Java 
//- * - coding��utf-8 - * -
//Author:JoeyChen
//Data:2020/04/18

//����һ���۲���תǰ������±�ֵ�ı仯

/**
 ִ�н����
 ִ����ʱ :0 ms, ������ Java �ύ�л�����100.00%���û�
 �ڴ����� :39.8 MB, ������ Java �ύ�л�����7.69%���û�
 **/

class Solution {
    public void rotate(int[][] matrix) {
        int col = matrix.length;
        int[][] copymat = new int[col][col];
        for (int i = 0; i < col; i++) {  //��ά�������
            copymat[i] = matrix[i].clone();
        }
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < col; j++) {
                matrix[j][col - 1 - i] = copymat[i][j];  //��תǰ���±�ֵ�ı��ϵ
            }
        }
    }
}