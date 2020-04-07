/**
10.正则表达式匹配
给你一个字符串?s?和一个字符规律?p，请你来实现一个支持 '.'?和?'*'?的正则表达式匹配。

'.' 匹配任意单个字符
'*' 匹配零个或多个前面的那一个元素
所谓匹配，是要涵盖?整个?字符串?s的，而不是部分字符串。

说明:

s?可能为空，且只包含从?a-z?的小写字母。
p?可能为空，且只包含从?a-z?的小写字母，以及字符?.?和?*。
示例 1:

输入:
s = "aa"
p = "a"
输出: false
解释: "a" 无法匹配 "aa" 整个字符串。
示例 2:

输入:
s = "aa"
p = "a*"
输出: true
解释:?因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
示例?3:

输入:
s = "ab"
p = ".*"
输出: true
解释:?".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
示例 4:

输入:
s = "aab"
p = "c*a*b"
输出: true
解释:?因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
示例 5:

输入:
s = "mississippi"
p = "mis*is*p*."
输出: false

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/regular-expression-matching
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
**/

//Java 
//- * - coding：utf-8 - * -
//Author:JoeyChen
//Data:2020/04/06

//方法一：
/**
执行结果：
执行用时 :82 ms, 在所有 Java 提交中击败了27.83%的用户
内存消耗 :40.1 MB, 在所有 Java 提交中击败了23.78%的用户
**/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m>n) {
            int[] temp = nums1;nums1 = nums2;nums2 = temp;
            int templenght = m; m = n;n = templenght;
        }
        int imin = 0,imax = m,half = (m+n+1)/2;
        while (imin<=imax) {
            int i = (imax+imin)/2;
            int j = half-i;
            //i过小且i可以再增大
            if(i<imax && nums2[j-1]>nums1[i]) {
                imin = i + 1;
            }
            //i过大且i可以再减小
            else if(i>imin && nums1[i-1]>nums2[j]) {
                imax = i - 1;
            }
            else {
                int leftmax = 0;
				// left_num1为空时
                if(i==0) {
                    leftmax = nums2[j-1];
                }
				//left_num2为空时
                else if(j==0) {
                    leftmax = nums1[i-1];
                }
                else {
                    leftmax = Math.max(nums1[i-1],nums2[j-1]);
                }
                if((m+n)%2 == 1) return leftmax;

                int rightmin = 0;
				 // right_num1为空时
                if(i==m) {
                    rightmin = nums2[j];
                }
				 // right_num2为空时
                else if(j==n) {
                    rightmin = nums1[i];
                }
                else {
                    rightmin = Math.min(nums1[i],nums2[j]);
                }
                return (leftmax + rightmin) / 2.0;
            }
        }
        return 0.0;

    }
}

//方法二：
/**
解题思路：参考链接：https://www.youtube.com/watch?v=EdWzV-9lQMw
递归方法
**/
/**
执行结果：
执行用时 :102 ms, 在所有 Java 提交中击败了15.32%的用户
内存消耗 :40.5 MB, 在所有 Java 提交中击败了23.47%的用户
**/
class Solution {
    public boolean isMatch(String s, String p) {
        if (p.length() == 0) return s.length() == 0;

        boolean firstMatch = s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');

		//特殊情况下
        if (p.length() >= 2 && p.charAt(1) == '*') { //难点，特殊情况下两种情况：P前两位不匹配；p第一位匹配---如：s=aaaaaa, p=a*
            return isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p));
        } 
		//一般情况下
		else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }
}

//方法三：
/**
解题思路：参考链接：https://www.youtube.com/watch?v=EdWzV-9lQMw
动态规划方法
**/
/**
执行结果：
执行用时 :4 ms, 在所有 Java 提交中击败了77.09%的用户
内存消耗 :39.6 MB, 在所有 Java 提交中击败了24.69%的用户
**/
class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;  //两个空串匹配
		
		//初始化 ,若没有这部分 如：s=aa ,p=a* 结果将为不匹配。(p当中包含*的部分，能不能匹配一个空串)
        for (int i = 2; i <= n; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1); //i,j表示位数，比下标多一
                char pc = p.charAt(j - 1);
                
                if (sc == pc || pc == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    if (dp[i][j - 2]) {
                        dp[i][j] = true;
                    } else if (sc == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                        dp[i][j] = dp[i -1][j];
                    }
                }
            }
        }
        return dp[m][n];

    }
}
