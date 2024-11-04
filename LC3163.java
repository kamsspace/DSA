// problem: 3163. String Compression III
// difficulty: medium
// runtime: 14ms, beats 98.31%
// memory: 59.79%

class Solution {
    public String compressedString(String word) {
        StringBuilder comp=new StringBuilder();
        int c=1;
        char[] w=word.toCharArray();
        char prev=word.charAt(0);
        char ch=prev;

        for (int i=1;i<w.length;i++) {
            ch=w[i];

            if (prev==ch) {
                c++;

                if (c==9) {
                    comp.append((char)(c+'0'));
                    comp.append(ch);
                    c=0;
                }
            } else {
                if (c>0) {
                    comp.append((char)(c+'0'));
                    comp.append(prev);
                }
                prev=ch;
                c=1;
            }
        }

        if (c>0) {
            comp.append((char)(c+'0'));
            comp.append(ch);
        }
        return comp.toString();
    }
}
