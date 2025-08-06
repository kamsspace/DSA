// LeetCode problem: 3638. Minimum Balanced Shipments
// Difficulty: medium
// Time: O(n)
// Space: O(1)
// DSA: WC461

class Solution {
    public int maxBalancedShipments(int[] weight) {
        int mx = 0;
        int mxb = 0;

        for (int i : weight) {
            if (i < mx) {
                mxb++;
                mx = 0;
            } else {
                mx = i;
            }
        }

        return mxb;
    }
}
