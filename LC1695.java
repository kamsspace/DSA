// LeetCode problem: 1695. Maximum Erasure Value
// Difficulty: medium
// Time: O(n)
// Space: O(n)
// DSA: Array, Hash Table, Sliding Window, Weekly Contest 220 
class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        Map<Integer, Integer> m = new HashMap<>();
        int e = 0, s = 0;

        for (int i = 0, j = 0; i < n; i++) {
            if (m.containsKey(nums[i])) {
                int x = m.get(nums[i]);
                while (j <= x) {
                    m.remove(nums[j]);
                    s -= nums[j++];
                }
            }
            m.put(nums[i],i);
            s += nums[i];
            e = Math.max(e, s);
        }

        return e;
    }
}
