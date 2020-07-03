/**
 * 20.��Ч������
 * ����һ��ֻ���� '('��')'��'{'��'}'��'['��']'?���ַ������ж��ַ����Ƿ���Ч��
 * <p>
 * ��Ч�ַ��������㣺
 * <p>
 * �����ű�������ͬ���͵������űպϡ�
 * �����ű�������ȷ��˳��պϡ�
 * ע����ַ����ɱ���Ϊ����Ч�ַ�����
 * <p>
 * ʾ�� 1:
 * <p>
 * ����: "()"
 * ���: true
 * ʾ��?2:
 * <p>
 * ����: "()[]{}"
 * ���: true
 * ʾ��?3:
 * <p>
 * ����: "(]"
 * ���: false
 * ʾ��?4:
 * <p>
 * ����: "([)]"
 * ���: false
 * ʾ��?5:
 * <p>
 * ����: "{[]}"
 * ���: true
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/valid-parentheses
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * <p>
 * ����˼·��
 * ����ջ�����ʡ��Ƚ��������������������ջ����Ϊ�����ţ��ж�ջ���Ƿ�Ϊƥ��������ţ���������ƥ�䣬�򷵻�true����Ȼfalse
 **/

//Java
//-*- coding:utf-8 -*-
//JoeyChen
//2020/04/10

/**
 ����˼·��
 ����ջ�����ʡ��Ƚ��������������������ջ����Ϊ�����ţ��ж�ջ���Ƿ�Ϊƥ��������ţ���������ƥ�䣬�򷵻�true����Ȼfalse
 **/

/**
 ִ�н����
 ִ����ʱ :2 ms, ������ Java �ύ�л�����89.13%���û�
 �ڴ����� :37.8 MB, ������ Java �ύ�л�����5.08%���û�
 **/

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char elemt = s.charAt(i);
            if (elemt == '(' || elemt == '[' || elemt == '{') {
                stack.push(elemt);
            }
            //
            else {
                if (stack.isEmpty()) return false;
                else {
                    char topelemt = stack.pop(); //������������������� �ж��Ƿ�ƥ��
                    if (elemt == ')' && topelemt != '(') return false;
                    else if (elemt == ']' && topelemt != '[') return false;
                    else if (elemt == '}' && topelemt != '{') return false;
                }
            }

        }
        return stack.isEmpty();  //������ȫ��ƥ�䣬���ӦΪ��ջ

    }
}