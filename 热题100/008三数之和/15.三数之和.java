/**
15.����֮��
����һ������ n ������������?nums���ж�?nums?���Ƿ��������Ԫ�� a��b��c ��ʹ��?a + b + c = 0 �������ҳ��������������Ҳ��ظ�����Ԫ�顣

ע�⣺���в����԰����ظ�����Ԫ�顣

?

ʾ����

�������� nums = [-1, 0, 1, 2, -1, -4]��

����Ҫ�����Ԫ�鼯��Ϊ��
[
  [-1, 0, 1],
  [-1, -1, 2]
]

��Դ�����ۣ�LeetCode��
���ӣ�https://leetcode-cn.com/problems/3sum
����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
**/

//Java 
//- * - coding��utf-8 - * -
//Author:JoeyChen
//Data:2020/04/08

//����һ��������ת��Ϊ���������⣬ʹ��˫ָ�����
/**
����˼·��
˫ָ�룬����11��ⷨ
**/

/**
ִ�н����
ִ����ʱ :24 ms, ������ Java �ύ�л�����85.17%���û�
�ڴ����� :43.4 MB, ������ Java �ύ�л�����99.81%���û�
**/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);  //����---��С����
        List<List<Integer>> res = new ArrayList<>();  //�½��б��Ž��
        for (int i = 0; i < nums.length -2; i++) {
            if (i>0 && nums[i] == nums[i-1]) continue;  //ȥ�أ������ظ���Ԫ��
            int left = i + 1, right = nums.length - 1, sum = 0 - nums[i];
            while (left < right) {
                if (nums[left] + nums[right] == sum) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left+1]) left++;  //ȥ�أ������ظ���Ԫ��
                    while (left < right && nums[right] == nums[right-1]) right--;  //ȥ�أ������ظ���Ԫ��
                    left++;
                    right--;
                    
                } else if (nums[left] + nums[right] < sum) left++;
                else right--;
            }
        }
        return res;

    }
}

//��������Java���Žⷨ(Ŀǰû�п���)

/**
ִ�н����ִ����ʱ :8 ms, ������ Java �ύ�л�����99.99%���û�
�ڴ����� :44 MB, ������ Java �ύ�л�����98.78%���û�
**/