// LeetCode problem: 2106. Maximum Fruits Harvested After at Most K Steps
// Difficulty: Hard
// Time: O(n)
// Space: O(1)
// DSA: Array, Binary Search, Sliding Window, Prefix Sum, WC271
class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length;
        int mx = 0, sm = 0;

        // l = leftMostKthIndex
        int l = bs(fruits, startPos - k);
        int r = l; // it will start summing up all the fruits up to the k distance

        while (r < n && fruits[r][0] <= startPos + k) {
            sm += fruits[r][1];

            int left = fruits[l][0];
            int right = fruits[r][0];
            int mnDistance = Math.min(Math.abs(startPos - left) + (right - left), Math.abs(startPos - right) + (right - left));
            
            while (l <= r && mnDistance > k) {
                sm -= fruits[l][1];
                l++;
                left = fruits[l][0];
                mnDistance = Math.min(Math.abs(startPos - left) + (right - left), Math.abs(startPos - right) + (right - left));
            }

            mx = Math.max(mx, sm);
            r++;
        }

        return mx;
    }

    public static int bs(int[][] fruits, int leftMostKthIndex) {
        int l = 0, r = fruits.length;
        
        while (l < r) {
            int m = l + (r - l) / 2;
            if (fruits[m][0] < leftMostKthIndex) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return l;
    }
}
