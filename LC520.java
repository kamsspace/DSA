// problem: 520. Detect Capital
// difficulty: easy
// runtime: 0ms, beats 100%
// memory: 41.66MB, beats 75.76%
class Solution {
    public boolean detectCapitalUse(String word) {
        char[] cc = word.toCharArray();
        int c = 0;

        for (int i = 0; i < cc.length; i++) {
            if (cc[i] < 91) c++;
        }

        if (cc[0] < 91 && c == 1) return true;
        if (c == cc.length || c == 0) return true;
        else return false;
    }
}
