// problem: 476. Number Complement
// difficulty: easy
// runtime: 0ms, beats 100%
// memory: 40.78MB, beats 15%
class Solution {
    public int findComplement(int num) {
        int n = Integer.toBinaryString(num).length();
        return ((1<<n) - 1) ^ num;
    }
}
