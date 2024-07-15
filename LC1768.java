// Runtime: 0ms, beats 100%
// Memory: 41.75MB, beats 44.71%
class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder res = new StringBuilder();
        int i = 0;
        if (word1.length() > word2.length()) {
            for (i = 0; i < word2.length(); i++) {
                res.append(word1.charAt(i));
                res.append(word2.charAt(i));
            }
            res.append(word1.substring(i));
        } else if (word1.length() < word2.length()) {
            for (i = 0; i < word1.length(); i++) {
                res.append(word1.charAt(i));
                res.append(word2.charAt(i));
            }
            res.append(word2.substring(i));
        } else {
            for (i = 0; i < word1.length(); i++) {
                res.append(word1.charAt(i));
                res.append(word2.charAt(i));
            }
        }
        return res.toString();
    }
}
