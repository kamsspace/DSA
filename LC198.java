// problem: 198. House Robber
// difficulty: medium
// runtime: 0ms, beats 100%
// memory: 40.80MB, beats 62.98%
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        nums[1]=nums[0]>nums[1] ? nums[0] : nums[1];
        int n=nums.length;

        for (int i=2; i<n;i++) {
            int temp=nums[i]+nums[i-2];

            if (temp>nums[i-1]) nums[i]=temp;
            else nums[i]=nums[i-1];
        }

        if (nums[1] > nums[n-1]) return nums[1];
        return nums[n-1];
    }
}
