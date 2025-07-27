// LeetCode problem: 2210. Count Hills and Valleys in an Array
// Difficulty: easy
// Time: O(n)
// Space: O(n)

class Solution {
    public int countHillValley(int[] nums) {
        int hv = 0;

        List<Integer> noduplicate = new ArrayList<>();
        noduplicate.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                continue;
            }
            noduplicate.add(nums[i]);
        }
        
        for (int i = 1; i < noduplicate.size() - 1; i++) {
            if (noduplicate.get(i-1) < noduplicate.get(i) && noduplicate.get(i) > noduplicate.get(i+1)) {
                hv++;
            } else if (noduplicate.get(i-1) > noduplicate.get(i) && noduplicate.get(i) < noduplicate.get(i+1)) {
                hv++;
            }
        }

        return hv;
    }
}
