// runtime: 1ms, beats 74.65%
// memory: 41.43MB, beats 45.31%
class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String f = strs[0];
        String l = strs[strs.length - 1];
        StringBuilder lcp = new StringBuilder();
        for (int i = 0; i < f.length() && i < l.length(); i++) {
                if (f.charAt(i) == l.charAt(i)) lcp.append(f.charAt(i));
                else break;
        }
        return lcp.toString();
    }
}
