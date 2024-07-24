// problem: 2191. Sort the Jumbled Numbers
// runtime: 94ms, beats 77.45%
// memory: 56.12MB, beats 16.67%

class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int len = nums.length;
        int[][] check = new int[len][2];
        for (int i = 0; i < len; i++) {
            check[i][1] = nums[i];
            if (nums[i] == 0) check[i][0] = mapping[0];
            for (int j = nums[i], k = 1; j > 0; j /= 10, k *= 10) check[i][0] += (mapping[j % 10] * k);
        }
        Arrays.sort(check, Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < len; i++) nums[i] = check[i][1];
        return nums;
    }
}
