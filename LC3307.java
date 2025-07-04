// LeetCode problem: 3307. Find the K-th Character in String Game II
// Difficulty: hard
// time: O(n)
// space: O(1)
// Math, Bit Manipulation, Recursion
class Solution {
    public char kthCharacter(long k, int[] operations) {
        if (k == 1) {
            return 'a';
        }
        long n = 1;
        
        int track = 0;
        for (int i : operations) {
            n *= 2;
            if (n >= k) break;
            track++;
        }

        int increment = 0;
        
        while (track >= 0) {
            n /= 2;
            int op = operations[track--];

            if (k > n) {
                k -= n;
                if (op == 1) {
                    increment++;
                }
            }
        }

        return (char) ((increment % 26) + 'a');
    }
}
