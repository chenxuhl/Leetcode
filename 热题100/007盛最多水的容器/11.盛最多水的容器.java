/**
 * 11.ʢ���ˮ������
 * ���� n ���Ǹ����� a1��a2��...��an��ÿ�������������е�һ����?(i,?ai) ���������ڻ� n ����ֱ�ߣ���ֱ�� i?�������˵�ֱ�Ϊ?(i,?ai) �� (i, 0)���ҳ����е������ߣ�ʹ��������?x?�Ṳͬ���ɵ�����������������ˮ��
 * <p>
 * ˵�����㲻����б��������?n?��ֵ����Ϊ 2��
 * <p>
 * ��ֱ�ߴ����������� [1,8,6,2,5,4,8,3,7]���ڴ�����£������ܹ�����ˮ�����ֵΪ?49��
 * <p>
 * <p>
 * ʾ����
 * <p>
 * ���룺[1,8,6,2,5,4,8,3,7]
 * �����49
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/container-with-most-water
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * <p>
 * ����˼·��
 * ѭ��Ƕ��
 **/

//Java 
//- * - coding��utf-8 - * -
//Author:JoeyChen
//Data:2020/04/07

//����һ����������
/**
 ����˼·��
 ѭ��Ƕ��
 **/

/**
 ִ�н����
 ִ����ʱ :848 ms, ������ Java �ύ�л�����5.04%���û�
 �ڴ����� :40.3 MB, ������ Java �ύ�л�����19.05%���û�
 **/

class Solution {
    public int maxArea(int[] height) {
        //�����ⷨ
        if (height == null || height.length <= 1) return 0;
        int maxArea = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
            }

        }
        return maxArea;

    }
}

//��������˫ָ��
/**
 ����˼·��
 ����˫ָ��ֱ�ָ��������β�������ս�ָ��϶��߶ε�ָ����ϳ��߶ε��Ƕ��ƶ���
 **/

/**
 ִ�н����
 ִ����ʱ :4 ms, ������ Java �ύ�л�����75.52%���û�
 �ڴ����� :39.9 MB, ������ Java �ύ�л�����64.44%���û�
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
                left++;
            } else {
                right--;
            }
        }
        return maxArea;

    }
}