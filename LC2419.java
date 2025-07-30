// LeetCode problem: 2419. Longest Subarray With Maximum Bitwise AND
// Difficulty: medium
// Time: O(n)
// Space: O(1)
// DSA: Array, Bit Manipulation, Brainteaser, Weekly Contest 312

class Solution {
    public int longestSubarray(int[] nums) {
        int mx = 0;
        int sub = 0, mxSub = 0;
        int prev = 0;

        for (int i : nums) {
            if (i > mx) {
                mx = i;
                sub = 1;
                mxSub = sub;
            } else if (i == mx) {
                if (prev == i) {
                    sub++;
                } else {
                    sub = 1;
                }
            }

            prev = i;

            if (mxSub < sub) {
                mxSub = sub;
            }
        }

        return mxSub;
    }
}
