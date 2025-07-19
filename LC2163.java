// LeetCode problem: 2163. Minimum Difference in Sums After Removal of Elements
// Difficulty: hard
// time: O(n log n)
// space: O(n)

class Solution {
    public long minimumDifference(int[] nums) {
        int n = nums.length / 3;

        PriorityQueue<Integer> mx = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> mn = new PriorityQueue<>();

        int i = 0;
        long sm = 0;
        long[] dp = new long[n+1];

        while (i < 2 * n) {
            int m = nums[i];
            sm += m;
            mx.offer(m);

            if (mx.size() > n) {
                sm -= mx.poll();
            }

            if (mx.size() == n) {
                dp[i-(n-1)] = sm;
            }
            i++;
        }

        i = 3 * n - 1;
        sm = 0;
        long[] dp2 = new long[n+1];

        while (n <= i) {
            int m = nums[i];
            sm += m;
            mn.offer(m);

            if (mn.size() > n) {
                sm -= mn.poll();
            }

            if (mn.size() == n) {
                dp2[i-n] = sm;
            }
            i--;
        }

        i = 0;
        sm = Long.MAX_VALUE;

        while (i < n+1) {
            sm = Math.min(dp[i] - dp2[i], sm);
            i++;
        }

        return sm;
    }
}
