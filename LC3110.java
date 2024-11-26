// problem: 3110. Score of a String
// difficulty: easy
// time complexity: O(n)
// space complexity: O(1)
class Solution {
    public int scoreOfString(String s) {
        int score = 0;

        for (int i = 1; i < s.length(); i++) {
            score += Math.abs(s.charAt(i-1) - s.charAt(i));
        }

        return score;
    }
}
