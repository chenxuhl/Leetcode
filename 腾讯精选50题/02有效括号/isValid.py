#20.ÓÐÐ§À¨ºÅ

class Solution:
    def isValid(self, s: str) -> bool:
        st = []
        dic = {')':'(','}':'{',']':'['}
        for c in s:
            if c == '(' or c == '[' or c == '{':
                st.append(c)
            elif c == ']' or c == ')' or c == '}':
                if len(st) == 0 or st.pop() != dic[c]:
                    return False
        return len(st) == 0
        