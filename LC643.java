// problem: 643. Maximum Average Subarray
// difficulty: easy
// time complexity: O(n)
// space complexity: O(1)
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;

        if (n == 1) return (float) nums[0];

        double mx=0.0;
        int sum = 0;

        for (int i=0;i<k;i++) {
            sum += nums[i];
        }

        mx = (double) sum/k;

        for (int i=0,j=k;j<n;i++,j++) {
            sum = sum + nums[j] - nums[i];
            mx = (double) Math.max(mx, (double) sum/k);
        }

        return mx;
    }
}
