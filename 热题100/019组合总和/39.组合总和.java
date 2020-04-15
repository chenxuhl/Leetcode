/**
39.组合总和
给定一个无重复元素的数组?candidates?和一个目标数?target?，找出?candidates?中所有可以使数字和为?target?的组合。

candidates?中的数字可以无限制重复被选取。

说明：

所有数字（包括?target）都是正整数。
解集不能包含重复的组合。?
示例?1:

输入: candidates = [2,3,6,7], target = 7,
所求解集为:
[
  [7],
  [2,2,3]
]
示例?2:

输入: candidates = [2,3,5], target = 8,
所求解集为:
[
? [2,2,2,2],
? [2,3,3],
? [3,5]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/combination-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
**/

//Java
//-*- coding:utf-8 -*-
//JoeyChen
//2020/04/15

//方法一：先排序，然后递归

/**
执行结果：
执行用时 :3 ms, 在所有 Java 提交中击败了93.98%的用户
内存消耗 :40.2 MB, 在所有 Java 提交中击败了9.43%的用户
**/

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        getAnswers(res,candidates,target,new ArrayList<>(),0);
        return res;
    }

    public void getAnswers(List<List<Integer>> res, int[] candidates, int target,
                                   List<Integer> tempList,int index) {
        if (target == 0) {
            res.add(tempList);
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i]<=target) {
                List<Integer> list=new ArrayList<>(tempList);
                list.add(candidates[i]);
                getAnswers(res,candidates,target-candidates[i],list,i);
            } else {
                break;
            }
        }
    }
}