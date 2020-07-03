/**
 * 10.������ʽƥ��
 * ����һ���ַ���?s?��һ���ַ�����?p��������ʵ��һ��֧�� '.'?��?'*'?��������ʽƥ�䡣
 * <p>
 * '.' ƥ�����ⵥ���ַ�
 * '*' ƥ���������ǰ�����һ��Ԫ��
 * ��νƥ�䣬��Ҫ����?����?�ַ���?s�ģ������ǲ����ַ�����
 * <p>
 * ˵��:
 * <p>
 * s?����Ϊ�գ���ֻ������?a-z?��Сд��ĸ��
 * p?����Ϊ�գ���ֻ������?a-z?��Сд��ĸ���Լ��ַ�?.?��?*��
 * ʾ�� 1:
 * <p>
 * ����:
 * s = "aa"
 * p = "a"
 * ���: false
 * ����: "a" �޷�ƥ�� "aa" �����ַ�����
 * ʾ�� 2:
 * <p>
 * ����:
 * s = "aa"
 * p = "a*"
 * ���: true
 * ����:?��Ϊ '*' �������ƥ���������ǰ�����һ��Ԫ��, ������ǰ���Ԫ�ؾ��� 'a'����ˣ��ַ��� "aa" �ɱ���Ϊ 'a' �ظ���һ�Ρ�
 * ʾ��?3:
 * <p>
 * ����:
 * s = "ab"
 * p = ".*"
 * ���: true
 * ����:?".*" ��ʾ��ƥ�����������'*'�������ַ���'.'����
 * ʾ�� 4:
 * <p>
 * ����:
 * s = "aab"
 * p = "c*a*b"
 * ���: true
 * ����:?��Ϊ '*' ��ʾ������������� 'c' Ϊ 0 ��, 'a' ���ظ�һ�Ρ���˿���ƥ���ַ��� "aab"��
 * ʾ�� 5:
 * <p>
 * ����:
 * s = "mississippi"
 * p = "mis*is*p*."
 * ���: false
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/regular-expression-matching
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 **/

//Java 
//- * - coding��utf-8 - * -
//Author:JoeyChen
//Data:2020/04/06

//����һ��

/**
 ִ�н����
 ִ����ʱ :82 ms, ������ Java �ύ�л�����27.83%���û�
 �ڴ����� :40.1 MB, ������ Java �ύ�л�����23.78%���û�
 **/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            int templenght = m;
            m = n;
            n = templenght;
        }
        int imin = 0, imax = m, half = (m + n + 1) / 2;
        while (imin <= imax) {
            int i = (imax + imin) / 2;
            int j = half - i;
            //i��С��i����������
            if (i < imax && nums2[j - 1] > nums1[i]) {
                imin = i + 1;
            }
            //i������i�����ټ�С
            else if (i > imin && nums1[i - 1] > nums2[j]) {
                imax = i - 1;
            } else {
                int leftmax = 0;
                // left_num1Ϊ��ʱ
                if (i == 0) {
                    leftmax = nums2[j - 1];
                }
                //left_num2Ϊ��ʱ
                else if (j == 0) {
                    leftmax = nums1[i - 1];
                } else {
                    leftmax = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if ((m + n) % 2 == 1) return leftmax;

                int rightmin = 0;
                // right_num1Ϊ��ʱ
                if (i == m) {
                    rightmin = nums2[j];
                }
                // right_num2Ϊ��ʱ
                else if (j == n) {
                    rightmin = nums1[i];
                } else {
                    rightmin = Math.min(nums1[i], nums2[j]);
                }
                return (leftmax + rightmin) / 2.0;
            }
        }
        return 0.0;

    }
}

//��������
/**
 ����˼·���ο����ӣ�https://www.youtube.com/watch?v=EdWzV-9lQMw
 �ݹ鷽��
 **/

/**
 ִ�н����
 ִ����ʱ :102 ms, ������ Java �ύ�л�����15.32%���û�
 �ڴ����� :40.5 MB, ������ Java �ύ�л�����23.47%���û�
 **/
class Solution {
    public boolean isMatch(String s, String p) {
        if (p.length() == 0) return s.length() == 0;

        boolean firstMatch = s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');

        //���������
        if (p.length() >= 2 && p.charAt(1) == '*') { //�ѵ㣬������������������Pǰ��λ��ƥ�䣻p��һλƥ��---�磺s=aaaaaa, p=a*
            return isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p));
        }
        //һ�������
        else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }
}

//��������
/**
 ����˼·���ο����ӣ�https://www.youtube.com/watch?v=EdWzV-9lQMw
 ��̬�滮����
 ʱ�临�Ӷȣ�O(m*n)
 �ռ临�Ӷȣ�O(m*n)
 **/

/**
 ִ�н����
 ִ����ʱ :4 ms, ������ Java �ύ�л�����77.09%���û�
 �ڴ����� :39.6 MB, ������ Java �ύ�л�����24.69%���û�
 **/
class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;  //�����մ�ƥ��

        //��ʼ�� ,��û���ⲿ�� �磺s=aa ,p=a* �����Ϊ��ƥ�䡣(�����Ϊ��p���а���*�Ĳ��֣��ܲ���ƥ��һ���մ�)
        for (int i = 2; i <= n; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }
        //���岿��
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1); //i,j��ʾλ�������±��һ
                char pc = p.charAt(j - 1);

                if (sc == pc || pc == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') { //�������
                    if (dp[i][j - 2]) { //�ظ�ǰ����ַ�
                        dp[i][j] = true;
                    } else if (sc == p.charAt(j - 2) || p.charAt(j - 2) == '.') { //������s=aaaa, p=a*���
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }
        return dp[m][n];

    }
}
