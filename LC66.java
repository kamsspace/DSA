// problem: 66. Plus One
// difficulty: easy
// runtime: 0ms, beats 100%
// memory: 41.84MB, beats 32.68%
class Solution {
    public int[] plusOne(int[] digits) {
        int i = digits.length-1;

        for (; i>=0;i--) {
            if (digits[i] < 9) {
                digits[i]++;
                break;
            } else {
                digits[i] = 0;
                continue;
            }
        }

        if (i == -1) {
            int[] digitsOnePlus = new int[digits.length+1];
            digitsOnePlus[0]++;

            for (int j = 1; j < digitsOnePlus.length; j++) {
                digitsOnePlus[j] = digits[j-1];
            }

            return digitsOnePlus;
        } else return digits;
    }
}
