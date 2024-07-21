// runtime: 0ms, beats 100%
// memory: 41.64MB, beats 56.20%
class Solution {
    public int findMiddleIndex(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int totalSum = 0;
        for (int i : nums) totalSum += i;
        int leftSum = 0;
        for (int mid = 0; mid < nums.length; mid++) {
            if (leftSum == totalSum - leftSum - nums[mid]) return mid;
            leftSum += nums[mid];
        }
        return -1;
    }
}
