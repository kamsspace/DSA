// problem: 5. Longest Palindromic Substring
// difficulty: medium

// runtime: 1574ms, beats 10.32%
// memory: 42.40MB, 70.22%
// solution without using dynamic programming (which will use in the next solution later...)
class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 1) return s;
        int maxLength = 1, maxTemp = 1;
        int start = 0, end = 0;
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (isPalindrome(s, j, i)) {
                    if ((i - j + 1) > maxTemp) {
                        maxTemp = i - j + 1;
                        end = i;
                        start = j;
                    }
                }
            }
        }
        return s.substring(start, end + 1); 
    }

    public boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
