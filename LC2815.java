// problem: 2815. Max Pair Sum in an Array
// difficulty: easy
// time complexity: O(n)
// space complexity: O(1)

class Solution {
    public int maxSum(int[] nums) {
        int[] max1 = new int[10];
        int[] max2 = new int[10];

        for (int i : nums) {
            int j = i;
            int maxDigit = 0;
             
            while (i > 0) {
                int digit = i % 10;
                i /= 10;
                if (maxDigit < digit) {
                    maxDigit = digit;
                }
            }

            if (max1[maxDigit] <= j) {
                max2[maxDigit] = max1[maxDigit];
                max1[maxDigit] = j;
            } else if (j > max2[maxDigit] && j != max1[maxDigit]) {
                max2[maxDigit] = j;
            }
        }

        int mx = -1;

        for (int i = 1; i < 10; i++) {
            if (max1[i] > 0 && max2[i] > 0) {
                mx = Math.max(mx,max1[i]+max2[i]);
            }
        }

        return mx;
    }
}
