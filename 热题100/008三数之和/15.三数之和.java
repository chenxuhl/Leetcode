/**
15.三数之和
给你一个包含 n 个整数的数组?nums，判断?nums?中是否存在三个元素 a，b，c ，使得?a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。

?

示例：

给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/3sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
**/

//Java 
//- * - coding：utf-8 - * -
//Author:JoeyChen
//Data:2020/04/08

//方法一：先排序，转化为两数和问题，使用双指针解题
/**
解题思路：
双指针，类似11题解法
**/

/**
执行结果：
执行用时 :24 ms, 在所有 Java 提交中击败了85.17%的用户
内存消耗 :43.4 MB, 在所有 Java 提交中击败了99.81%的用户
**/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);  //排序---从小到大
        List<List<Integer>> res = new ArrayList<>();  //新建列表存放结果
        for (int i = 0; i < nums.length -2; i++) {
            if (i>0 && nums[i] == nums[i-1]) continue;  //去重，避免重复三元组
            int left = i + 1, right = nums.length - 1, sum = 0 - nums[i];
            while (left < right) {
                if (nums[left] + nums[right] == sum) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left+1]) left++;  //去重，避免重复三元组
                    while (left < right && nums[right] == nums[right-1]) right--;  //去重，避免重复三元组
                    left++;
                    right--;
                    
                } else if (nums[left] + nums[right] < sum) left++;
                else right--;
            }
        }
        return res;

    }
}

//方法二：Java最优解法(目前没有看懂)

/**
执行结果：执行用时 :8 ms, 在所有 Java 提交中击败了99.99%的用户
内存消耗 :44 MB, 在所有 Java 提交中击败了98.78%的用户
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
    if (zeroSize >= 3) res.add(Arrays.asList(0, 0, 0));//输出 三个 0 的情况 
    if (negSize == 0 || posSize == 0) return res;
    //此时minValue一定为负数，maxValue一定为正数
    //如果maxValue > -2*minValue，那么大于 -2*minValue的元素肯定不会是答案，可以排除掉，所以更新maxValue
    if (minValue * 2 + maxValue > 0) maxValue = -minValue * 2; 
    //同理更新minValue
    else if (maxValue * 2 + minValue < 0) minValue = -maxValue * 2;
    //自己构建一个hashmap，值表示元素重复次数，注意java数组默认值为 0
    int[] map = new int[maxValue - minValue + 1];
    int[] negs = new int[negSize];
    int[] poses = new int[posSize];
    negSize = 0;
    posSize = 0;
    for (int v : nums) {
        if (v >= minValue && v <= maxValue) {//只保留在[minValue,maxValue]区间内的元素
            if (map[v - minValue]++ == 0) {//计数加去重
                if (v > 0) poses[posSize++] = v;//poses数组存所有去重后的正值
                else if (v < 0) negs[negSize++] = v;//negs数组存所有去重后的负值 
            }
        }
    }
    //正负数两数组排序
    Arrays.sort(poses, 0, posSize);
    Arrays.sort(negs, 0, negSize);
    int basej = 0;
    for (int i = negSize - 1; i >= 0; i--) {//负数数组从后往前遍历
        int nv = negs[i];//nv为当前负数值
        //minp = -nv/2，相当于三元组中另外两元素的平均值，即为另两个元素中较小值的上界，较大值的下界
        int minp = (-nv) >>> 1;
        //定位到正数数组中值刚好小于平均值的元素（这个地方应该还可以优化为使用二分查找）
        while (basej < posSize && poses[basej] < minp) basej++;
        for (int j = basej; j < posSize; j++) {//正数数组从大于等于平均值的元素开始遍历
            int pv = poses[j];//pv 为当前正数值
            int cv = 0 - nv - pv;//cv 为要寻找的另一个值
            //目标值 cv 应该在 [nv,pv] 当中
            //如果不限制cv<=pv，当nv为奇数时，有可能会重复输出
            if (cv >= nv && cv <= pv) {
                if (cv == nv) {
                    if (map[nv - minValue] > 1)//两个相同的负数和一个正数的情况
                        res.add(Arrays.asList(nv, nv, pv));
                } else if (cv == pv) {
                    if (map[pv - minValue] > 1)//两个相同的正数和一个负数的情况
                        res.add(Arrays.asList(nv, pv, pv));
                } else {
                    if (map[cv - minValue] > 0)//三个不同元素的情况
                        res.add(Arrays.asList(nv, cv, pv));
                }
            } else if (cv < nv) break;//如果 cv 小于 nv了，表明这种情况会在后面寻找，为避免重复输出，跳出循环
        }
    }
    return res;
}
}