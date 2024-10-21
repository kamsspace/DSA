// problem: 394. Decode String
// difficulty: medium
// runtime: 0ms, beats 100%
// memory: 59%

class Solution {
    public String decodeString(String s) {
        StringBuilder[] _sb = new StringBuilder[s.length()];
        int lastS = -1;
        int[] _n = new int[s.length()];
        int last = -1;
        StringBuilder sb = new StringBuilder();
        int n = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) 
                n = n * 10 + (c - '0');
            else if (c == '[') {
                _n[++last] = n;
                _sb[++lastS] = sb;
                n = 0;
                sb = new StringBuilder();
            } else if (c == ']') {
                int r = _n[last--];
                StringBuilder cur = sb;
                sb = _sb[lastS--];

                for (int i = 0; i < r; i++) 
                    sb.append(cur);
            } else 
                sb.append(c);
        }

        return sb.toString();
    }
}
