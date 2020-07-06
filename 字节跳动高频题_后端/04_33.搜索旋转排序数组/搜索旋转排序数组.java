/*
33. ������ת��������
���谴�����������������Ԥ��δ֪��ĳ�����Ͻ�������ת��

( ���磬���� [0,1,2,4,5,6,7] ���ܱ�Ϊ [4,5,6,7,0,1,2] )��

����һ��������Ŀ��ֵ����������д������Ŀ��ֵ���򷵻��������������򷵻� -1 ��

����Լ��������в������ظ���Ԫ�ء�

����㷨ʱ�临�Ӷȱ����� O(log n) ����

ʾ�� 1:

����: nums = [4,5,6,7,0,1,2], target = 0
���: 4
ʾ�� 2:

����: nums = [4,5,6,7,0,1,2], target = 3
���: -1
*/

/*
����˼·�����ȸ����е�ֵ����˵�ֵ��ϵ���ж�������໹���Ҳ��������
�ֱ����������������ж���˵���Ŀ��ֵ�Ĵ�С��ϵ����ζ��֣����յó����
*/

//Java
//Author:Joey
//Date��2020/07/06

/*
ִ�н����
ִ����ʱ��0 ms, ������ Java �ύ�л�����100.00%���û�
�ڴ����ģ�39.6 MB, ������ Java �ύ�л�����17.74%���û�
*/

class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, mid = -1;  //��ʼ���˵�ֵ
        while (right >= left) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] >= nums[left]) {  //���ֵ�������Ҳ࣬����������򣬡�=������ȥ��
                if (target >= nums[left] && target < nums[mid]) {  //target���������
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            } else {  //�Ҳ���������
                if (target <= nums[right] && target > nums[mid]) {  //target�������Ҳ�
                    left = mid + 1;
                } else {  //target���������
                    right = mid - 1;
                }

            }

        }
        return -1;

    }
}
