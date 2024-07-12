class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        int a = 0;
        int[] ar = new int[51];
        for (int i : nums) ar[i]++;
        for (int j = 1; j <= 50; j++) {
            if (ar[j] == 2) a ^= j;
        }
        return a;
    }
}
