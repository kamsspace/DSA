# problem: 1790. Check if One String Swap Can Make Strings Equal
# difficulty: easy
# time: O(n)
# space: O(1)
class Solution:
    def areAlmostEqual(self, s1: str, s2: str) -> bool:
        i = -1
        j = -1
        N = len(s1)
        c = 0
        for k in range(N):
            if s1[k] != s2[k]:
                c += 1
                if i == -1: i = k
                elif j == -1: j=k
        if c == 0: return True
        elif c == 2 and s1[i] == s2[j] and s1[j] == s2[i]:
            return True
        return False
