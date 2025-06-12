// problem: 3423. Maximum Difference Between Adjacent Elements in a Circular Array
// difficulty: easy
// time: O(n)
// space: O(1)
class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int N = nums.length;

        if (N == 2) {
            return Math.abs(nums[0] - nums[1]);
        }

        int i = 0, j = 1, maxDiff = Math.abs(nums[i++] - nums[j++]);
        
        while (j < N) {
            maxDiff = Math.max(maxDiff, Math.abs(nums[i++] - nums[j++]));
        }

        return Math.max(maxDiff, Math.abs(nums[0] - nums[N-1]));
    }
}
