// problem: 1930. Unique Length-3 Palindromic Subsequences
// difficulty: medium
// time complexity: O(n)
// space complexity: O(1)

class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int[] left = new int[26];
        int[] right = new int[26];
        int[] middle = new int[26];
        int leftMask = 0;
        int rightMask = 0;
        int uniqueSubs = 0;

        for (char ch : s.toCharArray()) {
            int b = (int) (ch - 'a'); 
            right[b]++;
            rightMask |= 1 << b;
        }

        for (int i = 0; i < n; i++) {
            int b = (int) (s.charAt(i) - 'a');


            if (i > 0) {
                leftMask |= 1 << (int) (s.charAt(i-1) - 'a');
                left[(int) (s.charAt(i-1) - 'a')]++;
            } 
            
            right[b]--;

            if (right[b] == 0) {
                rightMask ^= 1 << b;
            }
            
            middle[b] |= (leftMask & rightMask);
        }

        for (int i = 0; i < middle.length; i++) {
            uniqueSubs += Integer.bitCount(middle[i]);
        }

        return uniqueSubs;
    }
}
