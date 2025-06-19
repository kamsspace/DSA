// LeetCode problem: 2294. Partition Array Such That Maximum Difference Is K
// Difficulty: medium
// time: O(NlogN)
// space: O(1)
// Array, Greedy, Sorting
class Solution {
    public int partitionArray(int[] nums, int k) {
        if (nums.length == 1) {
            return 1;
        }

        Arrays.sort(nums);

        int sub = 1;
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - prev > k) {
                sub++;
                prev = nums[i];
            }
        }

        return sub;
    }
}
