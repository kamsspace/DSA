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


// 2. 
// runtime: 11ms, beats 95%
// memory: 43.11MB, beats 67%
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        
        String t = prepro(s);
        int n = t.length();
        int[] p = new int[n];
        int center = 0, right = 0;
        
        for (int i = 1; i < n - 1; i++) {
            int mirror = 2 * center - i;
            
            if (i < right) {
                p[i] = Math.min(right - i, p[mirror]);
            }
            
            while (t.charAt(i + (1 + p[i])) == t.charAt(i - (1 + p[i]))) {
                p[i]++;
            }
            
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
        }
        
        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 1; i < n - 1; i++) {
            if (p[i] > maxLen) {
                maxLen = p[i];
                centerIndex = i;
            }
        }
        
        int start = (centerIndex - maxLen) / 2;
        return s.substring(start, start + maxLen);
    }

    private String prepro(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append('^');
        for (int i = 0; i < s.length(); i++) {
            sb.append('#');
            sb.append(s.charAt(i));
        }
        sb.append("#$");
        return sb.toString();
    }
}
