// problem: 389. Find the Difference
// difficulty: easy
// runtime: 1ms, beats 100%
// memory: 41.66MB, beats 63.71%
class Solution {
    public char findTheDifference(String s, String t) {
        if (s.isEmpty()) return t.charAt(0);

        int[] ss = new int[256];
        int[] tt = new int[256];
        char res = ' ';

        for (char c : s.toCharArray()) ss[c]++;
        for (char c : t.toCharArray()) tt[c]++;
        for (int i = 0; i < 256; i++) {
            if (tt[i] > 0) {
                if (ss[i] < tt[i]) return (char) i;
            }
        }

        return res;
    }
}


// runtime: 2ms, beats 73.81%
// memory: 41.44MB, beats 90.07%
class Solution {
    public char findTheDifference(String s, String t) {
        if (s.isEmpty()) return t.charAt(0);

        int[] ss = new int[256];
        int[] tt = new int[256];
        char res = ' ';

        for (char c : s.toCharArray()) ss[c]++;
        for (char c : t.toCharArray()) tt[c]++;
        for (int i = 0; i < 256; i++) {
            if (ss[i] < tt[i]) res = (char) i;
        }

        return res;
    }
}


// runtime: 3ms, beats 43.47%
// memory: 41.92MB, beats 19.74%
class Solution {
    public char findTheDifference(String s, String t) {
        if (s.isEmpty()) return t.charAt(0);

        char[] sS = s.toCharArray();
        char[] sT = t.toCharArray();

        Arrays.sort(sS);
        Arrays.sort(sT);
        char res = ' ';

        for (int i = 0; i < sS.length; i++) {
            if (sS[i] != sT[i]) return sT[i];
        }

        if (res == ' ') res = sT[sT.length-1];

        return res;
    }
}
