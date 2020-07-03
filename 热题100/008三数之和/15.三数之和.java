/**
 * 15.����֮��
 * ����һ������ n ������������?nums���ж�?nums?���Ƿ��������Ԫ�� a��b��c ��ʹ��?a + b + c = 0 �������ҳ��������������Ҳ��ظ�����Ԫ�顣
 * <p>
 * ע�⣺���в����԰����ظ�����Ԫ�顣
 * <p>
 * ?
 * <p>
 * ʾ����
 * <p>
 * �������� nums = [-1, 0, 1, 2, -1, -4]��
 * <p>
 * ����Ҫ�����Ԫ�鼯��Ϊ��
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/3sum
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * <p>
 * ����˼·��
 * ˫ָ�룬����11��ⷨ
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
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;  //ȥ�أ������ظ���Ԫ��
            int left = i + 1, right = nums.length - 1, sum = 0 - nums[i];
            while (left < right) {
                if (nums[left] + nums[right] == sum) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;  //ȥ�أ������ظ���Ԫ��
                    while (left < right && nums[right] == nums[right - 1]) right--;  //ȥ�أ������ظ���Ԫ��
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

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) return Collections.emptyList();
        List<List<Integer>> res = new ArrayList<>();
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        int negSize = 0, posSize = 0;
        int zeroSize = 0;
        for (int v : nums) {
            if (v < minValue) minValue = v;
            if (v > maxValue) maxValue = v;
            if (v > 0) posSize++;
            else if (v < 0) negSize++;
            else zeroSize++;
        }
        if (zeroSize >= 3) res.add(Arrays.asList(0, 0, 0));//��� ���� 0 �����
        if (negSize == 0 || posSize == 0) return res;
        //��ʱminValueһ��Ϊ������maxValueһ��Ϊ����
        //���maxValue > -2*minValue����ô���� -2*minValue��Ԫ�ؿ϶������Ǵ𰸣������ų��������Ը���maxValue
        if (minValue * 2 + maxValue > 0) maxValue = -minValue * 2;
            //ͬ�����minValue
        else if (maxValue * 2 + minValue < 0) minValue = -maxValue * 2;
        //�Լ�����һ��hashmap��ֵ��ʾԪ���ظ�������ע��java����Ĭ��ֵΪ 0
        int[] map = new int[maxValue - minValue + 1];
        int[] negs = new int[negSize];
        int[] poses = new int[posSize];
        negSize = 0;
        posSize = 0;
        for (int v : nums) {
            if (v >= minValue && v <= maxValue) {//ֻ������[minValue,maxValue]�����ڵ�Ԫ��
                if (map[v - minValue]++ == 0) {//������ȥ��
                    if (v > 0) poses[posSize++] = v;//poses���������ȥ�غ����ֵ
                    else if (v < 0) negs[negSize++] = v;//negs���������ȥ�غ�ĸ�ֵ
                }
            }
        }
        //����������������
        Arrays.sort(poses, 0, posSize);
        Arrays.sort(negs, 0, negSize);
        int basej = 0;
        for (int i = negSize - 1; i >= 0; i--) {//��������Ӻ���ǰ����
            int nv = negs[i];//nvΪ��ǰ����ֵ
            //minp = -nv/2���൱����Ԫ����������Ԫ�ص�ƽ��ֵ����Ϊ������Ԫ���н�Сֵ���Ͻ磬�ϴ�ֵ���½�
            int minp = (-nv) >>> 1;
            //��λ������������ֵ�պ�С��ƽ��ֵ��Ԫ�أ�����ط�Ӧ�û������Ż�Ϊʹ�ö��ֲ��ң�
            while (basej < posSize && poses[basej] < minp) basej++;
            for (int j = basej; j < posSize; j++) {//��������Ӵ��ڵ���ƽ��ֵ��Ԫ�ؿ�ʼ����
                int pv = poses[j];//pv Ϊ��ǰ����ֵ
                int cv = 0 - nv - pv;//cv ΪҪѰ�ҵ���һ��ֵ
                //Ŀ��ֵ cv Ӧ���� [nv,pv] ����
                //���������cv<=pv����nvΪ����ʱ���п��ܻ��ظ����
                if (cv >= nv && cv <= pv) {
                    if (cv == nv) {
                        if (map[nv - minValue] > 1)//������ͬ�ĸ�����һ�����������
                            res.add(Arrays.asList(nv, nv, pv));
                    } else if (cv == pv) {
                        if (map[pv - minValue] > 1)//������ͬ��������һ�����������
                            res.add(Arrays.asList(nv, pv, pv));
                    } else {
                        if (map[cv - minValue] > 0)//������ͬԪ�ص����
                            res.add(Arrays.asList(nv, cv, pv));
                    }
                } else if (cv < nv) break;//��� cv С�� nv�ˣ���������������ں���Ѱ�ң�Ϊ�����ظ����������ѭ��
            }
        }
        return res;
    }
}