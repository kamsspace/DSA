// LeetCode problem: 594. Longest Harmonious Subsequence
// Difficulty: easy
// time: O(n log n)
// space: O(1)
class Solution {
    public int findLHS(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        Arrays.sort(nums);

        int i = 0;
        int j = 1;
        int ans = 0, n = nums.length;

        while (j < n) {
            int x = nums[j] - nums[i];
            if (x > 1) {
                if (j - i == 1) {
                    j++;
                }
                i++;
            } else if (x == 0) {
                j++;
            } else if (x == 1) {
                ans = Math.max(ans, j - i + 1);
                j++;
            }
        }
        
        return ans;
    }
}
