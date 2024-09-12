// problem: 541. Reverse String II
// difficulty: easy
// runtime: 3ms, beats 16.81%
// memory: 44.20MB, beats 17.35%
class Solution {
    public String reverseStr(String s, int k) {
        if (s.length() == 1 || k == 1) return s;

        char[] ss = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int even = 1;

        for (int start = k-1, end = 0; end < ss.length; start += k, end += k) {
            if (start >= ss.length) start = ss.length-1;
            if (even % 2 == 1) {
                for (int i = start; i >= end; i--) sb.append(ss[i]);
            } else {
                for (int i = end; i <= start; i++) sb.append(ss[i]);
            }
            
            even++;
        }

        return sb.toString();

    }
}
