// LeetCode Problem: 3614. Process String with Special Operations II
// Difficulty: hard
// time: O(n)
// space: O(1)
class Solution {
    public char processStr(String s, long k) {
        long n = 0;
        int i = 0;

        for (char ch : s.toCharArray()) {
            switch (ch) {
                case '#': n <<= 1; break;
                case '*': if (n > 0) n--; break;
                case '%': break;
                default: n++;
            }

            i++;
        }

        i--;
        k++;

        if (k > n) {
            return '.';
        }

        while (i >= 0) {
            switch (s.charAt(i)) {
                case '#': n /= 2; if (k > n) k -= n; break;
                case '*': n++; break;
                case '%': k = n - k + 1; break;
                default: if (n > k) n--;
                        else return s.charAt(i);
                        break;
            }
            
            i--;
        }

        return '.';
    }
}
