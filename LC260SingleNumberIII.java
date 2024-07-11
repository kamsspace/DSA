// Runtime: 1ms. Beats 99.97%
// Memory: 45.68MB. Beats 29.64%
class Solution {
    public int[] singleNumber(int[] nums) {
        int a = 0, b = 0, c = 0, d = 0;
        for (int i : nums) a ^= i;
        b = a & -a;
        for (int i : nums) {
            if ((i & b) == 0) c ^= i;
            else d ^= i;
        }
        return new int[] {c, d};
    }
}
