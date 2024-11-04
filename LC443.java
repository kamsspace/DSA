// problem: 443. String Compression
// difficulty: medium
// runtime: 1ms, beats 99.61%
// memory: 54.98%

class Solution {
    public int compress(char[] chars) {
        int n=chars.length;
        if (n==1) return 1;

        int c=1;
        char ch=chars[0];
        StringBuilder sb=new StringBuilder();

        for (int i=1;i<n;i++) {
            if (ch==chars[i]) {
                c++;
            } else {
                sb.append(ch);

                if (c>1) sb.append(c);

                ch=chars[i];
                c=1;
            }            
        }

        sb.append(ch);
        
        if (c>1) sb.append(c);

        c=0;

        for (char l:sb.toString().toCharArray()) {
            chars[c++]=l;
        }
        return sb.length();
    }
}
