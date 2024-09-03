// problem: 125. Valid Palindrome
// difficulty: easy
// runtime: 14ms, beats 34.52%
// memory: 44.63MB, beats 40.49%

class Solution {
    public boolean isPalindrome(String s) {
        String ss = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String sss = new StringBuilder(ss).reverse().toString();
        return ss.equals(sss);
    }
}
