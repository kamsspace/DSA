// LeetCode problem: 3487. Maximum Unique Subarray Sum After Deletion
// Difficulty: easy
// Time: O(n)
// Space: O(n)

class Solution {
    public int maxSum(int[] nums) {
        TreeSet<Integer> s = new TreeSet<>();

        for (int i : nums) {
            s.add(i);
        }

        if (s.last() < 0) {
            return s.last();
        }

        int sm = 0;
        for (int i : s) {
            if (i > 0) {
                sm += i;
            }
        }
        return sm;
    }
}
