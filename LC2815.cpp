// problem: 2815. Max Pair Sum in an Array
// difficulty: easy
// time complexity: O(n)
// space complexity: O(1)

class Solution {
public:
    int maxSum(vector<int>& nums) {
        vector<int> max1(10);
        vector<int> max2(10);
        int mx=-1;

        for (int i : nums) {
            int mxD =0;
            int j = i;

            while (i > 0) {
                int d = i % 10;
                i /= 10;

                if (mxD < d) {
                    mxD = d;
                }
            }

            if (max1[mxD] <= j) {
                max2[mxD] = max1[mxD];
                max1[mxD] = j;
            } else if (max2[mxD] < j && max1[mxD] != j) {
                max2[mxD] = j;
            }
        }

        for (int i = 1; i < 10; i++) {
            if (max1[i] > 0 && max2[i] > 0) {
                mx = max(mx, max1[i]+max2[i]);
            }
        }

        return mx;
    }
};
