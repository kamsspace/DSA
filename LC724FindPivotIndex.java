// runtime: 3ms, beats 16.01%
// memory: 45.26MB, beats 59.88%
class Solution {
    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int totalSum = Arrays.stream(nums).sum();
        int leftSum = 0;
        for (int mid = 0; mid < nums.length; mid++) {
            if (leftSum == totalSum - leftSum - nums[mid]) return mid;
            leftSum += nums[mid];
        }
        return -1;
    }
}
