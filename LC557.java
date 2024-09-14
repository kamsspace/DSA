// problem: 557. Reverse Words in a String III
// difficulty: easy
// runtime: 4ms, beats 87.88%
// memory: 45.17MB, beats 65.24%
class Solution {
    public String reverseWords(String s) {
        String[] ss = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for (String i : ss) {
            sb.append(new StringBuilder(i).reverse());
            sb.append(' ');
        }

        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}


// runtime: 6ms, beats 54.66%
// memory: 45.28MB, beats 50%
class Solution {
    public String reverseWords(String s) {
        char[] ss = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int start = s.indexOf(' ');
        int end = 0;

        for (int i = start-1; i >= end; i--) {
            sb.append(ss[i]);

            if (i == end) {
                end = start+1;
                start = s.indexOf(' ',start+1);
                if (start != -1) {
                    i = start;
                    sb.append(' ');
                }
            }
        }

        if (start == -1) {
            if (end > 0) sb.append(' ');
            for (int i = ss.length-1; i >= end; i--) {
                sb.append(ss[i]);
            }
        }

        return sb.toString();
    }
}
