// runtime: 2ms, beats 13.02%
// memory: 42.28MB, beats 8.45%
class Solution {
    public int lengthOfLastWord(String s) {
        String[] a = s.replaceAll("\\s+", ",").split(",");
        if (a.length == 0) return 0;
        return a[a.length-1].length();
    }
}
