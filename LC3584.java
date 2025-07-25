// LeetCode problem: 3584. Maximum Product of First and Last Elements of a Subsequence
// Difficulty: medium
// Time: O(n)
// Space: O(1)
class Solution {
    public long maximumProduct(int[] nums, int m) {
        long mxp = 0;
        if (m == 1) {
            for (long i : nums) {
                mxp = Math.max(mxp, i*i);
            }
            return mxp;
        }

        int n = nums.length;
        mxp = Long.MIN_VALUE;
        long mn = nums[0], mx = nums[0];
        
        for (int i = m - 1; i < n; i++) {
            int j = i - m + 1;
            
            if (j > 0) {
                if (nums[j] > mx) {
                    mx = nums[j];
                }
                if (nums[j] < mn) {
                    mn = nums[j];
                }

            }
            
            if (mxp < mx * nums[i]) {
                mxp = mx * nums[i];
            }
            if (mxp < mn * nums[i]) {
                mxp = mn * nums[i];
            }
        }

        return mxp;
    }
}
