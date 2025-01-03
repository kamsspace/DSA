// problem: 2270. Number of Ways to Split Array
// difficulty: medium
// time complexity: O(n)
// space complexity: O(1)
// to avoid overflow for integer, use long for rightSum and leftSum
class Solution {
    public int waysToSplitArray(int[] nums) {
        if (nums.length == 2) {
            return nums[0] >= nums[1] ? 1 : 0;
        }

        int validSplitCount = 0;
        long leftSum = nums[0];
        long rightSum = 0;
        int n = nums.length;

        for (int i = 1; i < n; i++) {
            rightSum += nums[i];
        }

        // System.out.println(leftSum + " " + rightSum + " " + validSplitCount);
        if (leftSum >= rightSum) {
            validSplitCount++;
        }

        for (int i = 1; i < n - 1; i++) {
            leftSum += nums[i];
            rightSum -= nums[i];

        // System.out.println(leftSum + " " + rightSum + " " + validSplitCount);
            if (leftSum >= rightSum) {
                validSplitCount++;
            }
        }

        
        // System.out.println(leftSum + " " + rightSum + " " + validSplitCount);

        return validSplitCount;
    }
}
