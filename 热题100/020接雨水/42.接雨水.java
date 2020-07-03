/**
 * 42.����ˮ
 * ����?n ���Ǹ�������ʾÿ�����Ϊ 1 �����ӵĸ߶�ͼ�����㰴�����е����ӣ�����֮���ܽӶ�����ˮ��
 * <p>
 * ���� [0,1,0,2,1,0,1,3,2,1,2,1] ��ʾ�ĸ߶�ͼ������������£����Խ� 6 ����λ����ˮ����ɫ���ֱ�ʾ��ˮ����?��л Marcos ���״�ͼ��
 * <p>
 * ʾ��:
 * <p>
 * ����: [0,1,0,2,1,0,1,3,2,1,2,1]
 * ���: 6
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/trapping-rain-water
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * <p>
 * ����˼·����ÿһ��Ԫ�أ��ҵ������ҵ����ֵ�����������ֵ�е���Сֵ�ʹ�Ԫ�ع��ɵ������������Ϊ��ˮ��
 * ���ս��Ϊ������״ͼ������ܺͣ�
 **/

//Java 
//- * - coding��utf-8 - * -
//Author:JoeyChen
//Data:2020/04/17

//����һ��������ⷨ

/**
 ����˼·����ÿһ��Ԫ�أ��ҵ������ҵ����ֵ�����������ֵ�е���Сֵ�ʹ�Ԫ�ع��ɵ������������Ϊ��ˮ��
 ���ս��Ϊ������״ͼ������ܺͣ�
 **/

/**
 ִ�н����
 ִ����ʱ :91 ms, ������ Java �ύ�л�����8.57%���û�
 �ڴ����� :39.4 MB, ������ Java �ύ�л�����12.86%���û�
 **/

class Solution {
    public int trap(int[] height) {
        int res = 0;
        for (int i = 1; i < height.length; i++) {
            int max_left = 0, max_right = 0;
            for (int j = i; j >= 0; j--) { //Ѱ��������ֵ
                max_left = Math.max(max_left, height[j]);
            }
            for (int j = i; j < height.length; j++) {  //Ѱ���Ҳ����ֵ
                max_right = Math.max(max_right, height[j]);
            }

            res += Math.min(max_left, max_right) - height[i];  //������ۼ�
        }
        return res;

    }
}

//����������̬�滮���ռ任ʱ��

/**
 ����˼·������ڷ�һ�������⣬�������齫ÿ��Ԫ�����Ҳ����ֵ�洢��������ʹ��ʱ��ֱ��ʹ�ã�������ѭ��Ƕ��
 **/

/**
 ִ�н��:
 ִ����ʱ :1 ms, ������ Java �ύ�л�����99.99%���û�
 �ڴ����� :39.3 MB, ������ Java �ύ�л�����12.86%���û���ҫһ��:
 **/

class Solution {
    public int trap(int[] height) {
        //��̬�滮���ռ任ʱ��
        int res = 0;
        int len = height.length;
        //�������
        if (height == null || len == 0) {
            return res;
        }
        int[] max_left = new int[len];
        int[] max_right = new int[len];
        //�洢Ԫ��������ֵ
        max_left[0] = height[0];
        for (int i = 1; i < len; i++) {
            max_left[i] = Math.max(max_left[i - 1], height[i]);
        }
        //�洢Ԫ���Ҳ����ֵ
        max_right[len - 1] = height[len - 1];
        for (int j = len - 2; j >= 0; j--) {
            max_right[j] = Math.max(max_right[j + 1], height[j]);
        }
        for (int k = 0; k < len; k++) {
            res += Math.min(max_left[k], max_right[k]) - height[k];
        }
        return res;

    }
}


//��������˫ָ��

/**
 ����˼·����̬�滮˼��Ļ�����ʹ��˫ָ�룬���ô洢�����У�ֻ��Ҫ�洢���Ҹ�һ�����ֵ����
 �ο���https://leetcode-cn.com/problems/trapping-rain-water/solution/jie-yu-shui-by-leetcode/
 **/

/**
 ִ�н����
 ִ����ʱ :1 ms, ������ Java �ύ�л�����99.99%���û�
 �ڴ����� :39.3 MB, ������ Java �ύ�л�����12.86%���û�
 **/

class Solution {
    public int trap(int[] height) {
        int res = 0;
        if (height == null || height.length == 0) return res;
        int max_left = 0, max_right = 0;
        int left = 0, right = height.length - 1;
        while (left <= right) {
            if (max_left < max_right) {  //���С�����ȡ
                if (height[left] >= max_left) {
                    max_left = height[left];
                } else {
                    res += (max_left - height[left]);
                }
                left++;
            } else {  //�ұ�С���ұ�ȡ
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

