// LeetCode problem: 3136. Valid Word
// Difficulty: easy
// time: O(n)
// space: O(1)
class Solution {
    public boolean isValid(String word) {
        int n = word.length();
        if (n < 3) {
            return false;
        }

        String vow = "aeiou";
        boolean v = false, c = false;

        for (char ch : word.toLowerCase().toCharArray()) {
            if (Character.isLetter(ch)) {
                if (vow.indexOf(ch) != -1) {
                    v = true;
                } else {
                    c = true;
                }
            } else if (!Character.isDigit(ch)) {
                return false;
            }
        }

        return v && c;
    }
}
