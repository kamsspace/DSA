// problem: 746. Min Cost Climbing Stairs
// difficulty: easy
// runtime: 0ms, beats 100%
// memory: 28%
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp=new int[cost.length+2];

        for (int i=cost.length-1;i>=0;i--) {
            dp[i]=cost[i] + Math.min(dp[i+1], dp[i+2]);
        }

        return Math.min(dp[0],dp[1]);
    }
}
