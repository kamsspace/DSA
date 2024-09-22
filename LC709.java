// problem: 709. To Lower Case
// difficulty: easy
// runtime: 0ms, beats 100%
// memory: 41.08MB, beats 98.29%
class Solution {
    public String toLowerCase(String s) {
        char[] low = new char[s.length()];
        int in = 0;

        for (char c : s.toCharArray()) {
            if (c < 91 && c > 64) low[in++] = (char)(c + 32);
            else low[in++] = c;
        }

        return new String(low);
    }
}
