// LeetCode problem: 3627. Maximum Median Sum of Subsequences of Size 3
// Difficulty: medium
// Time: O(n logn)
// Space: O(1)

class Solution {
    public long maximumMedianSum(int[] nums) {
        Arrays.sort(nums);

        long m = 0;

        for (int i = 0, j = nums.length-2; i < j; i++, j -= 2) {
            m += nums[j];
        }

        return m;
    }
}
