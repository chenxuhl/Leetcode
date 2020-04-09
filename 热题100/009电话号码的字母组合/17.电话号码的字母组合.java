/**
17.电话号码的字母组合
给定一个仅包含数字?2-9?的字符串，返回所有它能表示的字母组合。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

digitToLetter['2']="abc";
digitToLetter['3']="def";
digitToLetter['4']="ghi";
digitToLetter['5']="jkl";
digitToLetter['6']="mno";
digitToLetter['7']="pqrs";
digitToLetter['8']="tuv";
digitToLetter['9']="wxyz";

示例:

输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
**/

//Java 
//- * - coding：utf-8 - * -
//Author:JoeyChen
//Data:2020/04/09

//方法一：循环+回溯

/**
解题思路：
	循环每个数字对应的字母，并将每个数字中的字母作为一层，字母数表示可能排序数。如单个数字“2”有三种可能。依次逐层递增，排序可能结果为每层可能数的乘积
**/

/**
执行结果：
执行用时 :1 ms, 在所有 Java 提交中击败了92.71%的用户
内存消耗 :39.8 MB, 在所有 Java 提交中击败了5.18%的用户
**/

class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return Collections.EMPTY_LIST;  //为空情况

        Map<Character, String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        char[] chars = digits.toCharArray();  
        List<String> res = new ArrayList<>();  //存放结果
        res.add("");

        for (char c : chars) {
            List<String> tmpList = new ArrayList<>();
            String mapval = map.get(c);
            for (String str : res) {
                for (Character tmpC : mapval.toCharArray()) {
                    String tmpstr = str + tmpC;  //字母叠加
                    tmpList.add(tmpstr);
                }
            }
            res = tmpList;  //更新结果
        }
        return res;


    }
}
