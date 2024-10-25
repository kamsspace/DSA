// problem: 693. Binary Number with Alternating Bits
// difficulty: easy
// runtime: 0ms, beats 100%
class Solution {
    public boolean hasAlternatingBits(int n) {
        int ones = n^(n>>1);
        int zeros = (n^(n>>1)) + 1;
        return (ones&zeros) == 0;
    }
}
