// runtime: 6ms, beats 68.40%
// memory: 44.61MB, beats 37.20%

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> h = new HashMap<>();
        int maxLen = 0, a = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (h.containsKey(c) && h.get(c) >= a) {
                a = h.get(c) + 1;
            }
            h.put(c, i);
            maxLen = Math.max(maxLen, i - a + 1);
        }
        return maxLen;
    }
}
