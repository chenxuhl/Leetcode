/**
49.字母异位词分组
给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

示例:

输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
说明：

所有输入均为小写字母。
不考虑答案输出的顺序。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/group-anagrams
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
**/

//Java 
//- * - coding：utf-8 - * -
//Author:JoeyChen
//Data:2020/04/18

//方法一：使用HashMap，数组+链表

/**
执行结果：
执行用时 :28 ms, 在所有 Java 提交中击败了20.62%的用户
内存消耗 :43.5 MB, 在所有 Java 提交中击败了26.47%的用户
**/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ret = new ArrayList<List<String>>();  //存放结果
        Map<String,List<String>> map = new HashMap<>();  //存放键和值
        for(String s : strs) {
            char[] c = s.toCharArray();  //字符串转换成字符数组
            Arrays.sort(c);  //字符数组中字母进行排序
            String sorted = "";
            for(char tmp : c)
                sorted += tmp;  //排序后的数组C转换成字符串
			
            if(map.get(sorted) == null) {
                List<String> list = new ArrayList<String>();
                list.add(s);
                map.put(sorted, list);  //put key和value
            } else {
                map.get(sorted).add(s);  //HashMap中加入新字符串
            }
        }
        for(List<String> tmp : map.values()) {  //将map中所有value存入到ret中，作为结果返回
            ret.add(tmp);
        }
        return ret;
    }
}