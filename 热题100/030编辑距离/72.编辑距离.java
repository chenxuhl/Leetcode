/**
 * 72.�༭����
 * ������������?word1 ��?word2������������?word1?ת����?word2 ��ʹ�õ����ٲ�����?��
 * <p>
 * ����Զ�һ�����ʽ����������ֲ�����
 * <p>
 * ����һ���ַ�
 * ɾ��һ���ַ�
 * �滻һ���ַ�
 * ?
 * <p>
 * ʾ��?1��
 * <p>
 * ���룺word1 = "horse", word2 = "ros"
 * �����3
 * ���ͣ�
 * horse -> rorse (�� 'h' �滻Ϊ 'r')
 * rorse -> rose (ɾ�� 'r')
 * rose -> ros (ɾ�� 'e')
 * ʾ��?2��
 * <p>
 * ���룺word1 = "intention", word2 = "execution"
 * �����5
 * ���ͣ�
 * intention -> inention (ɾ�� 't')
 * inention -> enention (�� 'i' �滻Ϊ 'e')
 * enention -> exention (�� 'n' �滻Ϊ 'x')
 * exention -> exection (�� 'n' �滻Ϊ 'c')
 * exection -> execution (���� 'u')
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/edit-distance
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * <p>
 * ����˼·���ο�https://www.youtube.com/watch?v=We3YDTzNXEk
 * ���룺https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/EditDistance.java
 **/

//Java 
//- * - coding��utf-8 - * -
//Author:JoeyChen
//Data:2020/04/24

//����һ����̬�滮

/**
 ����˼·���ο�https://www.youtube.com/watch?v=We3YDTzNXEk
 ���룺https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/EditDistance.java
 **/

/**
 ִ�н����
 ִ����ʱ :7 ms, ������ Java �ύ�л�����62.44%���û�
 �ڴ����� :40.2 MB, ������ Java �ύ�л�����5.00%���û�
 **/

class Solution {
    public int minDistance(String word1, String word2) {
        //��ά�����Ž��
        int[][] res = new int[word2.length() + 1][word1.length() + 1];

        //��ʼ������
        for (int i = 0; i <= word1.length(); i++) {
            res[0][i] = i;
        }
        //��ʼ������
        for (int j = 0; j <= word2.length(); j++) {
            res[j][0] = j;
        }

        for (int i = 1; i <= word2.length(); i++) {
            for (int j = 1; j <= word1.length(); j++) {
                //���ָ�ֵ���
                if (word2.charAt(i - 1) == word1.charAt(j - 1)) {
                    res[i][j] = res[i - 1][j - 1];
                } else {
                    res[i][j] = 1 + Math.min(Math.min(res[i - 1][j], res[i - 1][j - 1]), res[i][j - 1]);
                }
            }
        }
        return res[word2.length()][word1.length()];

    }
}