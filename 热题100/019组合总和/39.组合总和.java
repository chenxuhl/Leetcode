/**
 * 39.����ܺ�
 * ����һ�����ظ�Ԫ�ص�����?candidates?��һ��Ŀ����?target?���ҳ�?candidates?�����п���ʹ���ֺ�Ϊ?target?����ϡ�
 * <p>
 * candidates?�е����ֿ����������ظ���ѡȡ��
 * <p>
 * ˵����
 * <p>
 * �������֣�����?target��������������
 * �⼯���ܰ����ظ�����ϡ�?
 * ʾ��?1:
 * <p>
 * ����: candidates = [2,3,6,7], target = 7,
 * ����⼯Ϊ:
 * [
 * [7],
 * [2,2,3]
 * ]
 * ʾ��?2:
 * <p>
 * ����: candidates = [2,3,5], target = 8,
 * ����⼯Ϊ:
 * [
 * ? [2,2,2,2],
 * ? [2,3,3],
 * ? [3,5]
 * ]
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/combination-sum
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 **/

//Java
//-*- coding:utf-8 -*-
//JoeyChen
//2020/04/15

//����һ��������Ȼ��ݹ�

/**
 ִ�н����
 ִ����ʱ :3 ms, ������ Java �ύ�л�����93.98%���û�
 �ڴ����� :40.2 MB, ������ Java �ύ�л�����9.43%���û�
 **/

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        getAnswers(res, candidates, target, new ArrayList<>(), 0);
        return res;
    }

    public void getAnswers(List<List<Integer>> res, int[] candidates, int target,
                           List<Integer> tempList, int index) {
        if (target == 0) {
            res.add(tempList);
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                List<Integer> list = new ArrayList<>(tempList);
                list.add(candidates[i]);
                getAnswers(res, candidates, target - candidates[i], list, i);
            } else {
                break;
            }
        }
    }
}