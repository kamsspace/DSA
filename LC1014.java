// problem: 1014. Best Sightseeing Pair
// difficulty: medium
// time complexity: O(n)
// space complexity: O(1)
class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int mx = 0;
        int mxi = values[0];

        for (int j = 1; j < n; j++) {
            mx = Math.max(mx, mxi + values[j] - j);
            mxi = Math.max(mxi, values[j] + j);
        }

        return mx;
    }
}


// version 2.0
class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int mx = 0;
        int mxi = values[0];

        for (int j = 1; j < n; j++) {
            if (mx < mxi + values[j] - j) {
                mx = mxi + values[j] - j;
            }

            if (mxi < values[j] + j) {
                mxi = values[j] + j;
            }
        }

        return mx;
    }
}
