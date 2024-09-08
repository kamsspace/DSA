// problem: 392. Is Subsequence
// difficulty: easy
// runtime: 0ms, beats 100%
// memory: 41.50MB, beats 40.45%
class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) return false;

        int prev = -1;
        char[] cT = t.toCharArray();

        for (char c : s.toCharArray()) {
            prev = exists(prev+1,cT,c);
            if (prev == -1) return false;
        }

        return true;
    }

    public int exists(int prev, char[] a, char c) {
        for (int i = prev; i < a.length; i++) {
            if (c == a[i]) {
                return i;
            }
        }
        
        return -1;
    }
}
