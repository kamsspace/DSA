// problem: 6. Zigzag Conversion
// difficulty: medium
// runtime: 22ms, beats 13.7%
// memory: 45.16MB, beats 54.53%
class Solution {
    public String convert(String s, int numRows) {
        if (s.length() <= numRows || s.length() < 3 || numRows == 1) return s;

        int len = s.length();
        char[][] zz = new char[numRows][(len * 2) / 3];
        char[] ss = s.toCharArray();
        int i,j,l;
        i = j = l = 0;

        while (i < len) {
            for (j = 0; j < numRows; j++) {
                if (i < len) zz[j][l] = ss[i++];
                else break;
            }

            for (j-=2,l++; j > 0; j--,l++) {
                if (i < len) zz[j][l] = ss[i++];
                else break;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (char[] a : zz) {
            for (char c : a) {
                if (c != '\u0000') sb.append(c);
            }
        }

        return sb.toString();
    }
}
