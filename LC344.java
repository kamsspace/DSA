// problem: 344. Reverse String
// difficulty: easy
// runtime: 0ms, beats 100%
// memory: 49.26MB, beats 28.88%
class Solution {
    public void reverseString(char[] s) {
        char[] r = Arrays.copyOf(s,s.length);
        int i = s.length-1;
        for (char c : r) {
            s[i] = c;
            i--;
        }
    }
}
