// LeetCode problem 1498. Number of Subsequences That Satisfy the Given Sum Condition
// Difficulty: medium
// time: O(n log n)
// space: O(1)

class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;

        int MOD = 1_000_000_007;
        int c = 0;

        for (int i = 0; i < n; i++) {
            int j = bs(nums, i, n - 1, target);
            if (j != -1 && j >= i) {
                c = (c + pw(2L,j-i, MOD)) % MOD;
            }
        }

        return c;
    }

    public static int bs(int[] arr, int l, int r, int t) {
        int mn = arr[l];
        int ans = -1;

        while (l <= r) {
            int m = (l + r) / 2;
            if (mn + arr[m] <= t) {
                ans = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return ans;
    }

    public static int pw(long b, int p, int MOD) {
        long ans = 1L;
        
        while (p > 0) {
            if ((p & 1) == 1) {
                ans = (ans * b) % MOD;
            }
            b = (b * b) % MOD;
            p >>= 1;
        }
        return (int) ans;
    }
}
