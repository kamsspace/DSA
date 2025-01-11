// problem: 1400. Construct K Palindrome Strings
// difficulty: medium
// time complexity: O(n)
// space complexity: O(1)

class Solution {
    public boolean canConstruct(String s, int k) {
        int n = s.length();
        if (n < k) return false;

        int[] c = new int[26];

        for (char ch : s.toCharArray()) {
            c[(int)(ch - 'a')]++;
        }


        int ks = 0;

        for (int i : c) {
            if (i % 2 == 1) {
                ks++;
                if (ks > k) {
                    return false;
                }
            }
        }

        return true;
    }
}


// version 1.0
class Solution {
    public boolean canConstruct(String s, int k) {
        int n = s.length();
        if (n < k) return false;

        Map<Character, Integer> c = new HashMap<>();

        for (char ch : s.toCharArray()) {
            c.put(ch,c.getOrDefault(ch,0)+1);
        }


        int ks = 0;

        for (int i : c.values()) {
            if (i % 2 == 1) {
                ks++;
                if (ks > k) {
                    return false;
                }
            }
        }

        return true;
    }
}


// version 3.0
// bit manipulation
class Solution {
    public boolean canConstruct(String s, int k) {
        int n = s.length();
        if (n < k) return false;
        if (n == k) return true;

        int c = 0;

        for (char ch : s.toCharArray()) {
            c ^= 1 << (int)(ch - 'a');
        }

        return Integer.bitCount(c) <= k;
    }
}
