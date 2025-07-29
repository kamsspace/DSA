// LeetCode problem: 3587. Minimum Adjacent Swaps to Alternate Parity
// Difficulty: medium
// Time: O(n)
// Space: O(n)
// DSA: Array, Greedy, BiWeekly Contest 159

class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;

        int e = 0; // even counts
        int o = 0; // odd counts
        int j = 0;
        boolean isZero = true;

        for (int i : nums) {
            if (i % 2 == 0) {
                e++;
            } else {
                o++;
            }
            if (j > 1 && (nums[j] % 2) != (nums[j-2] % 2)) { // checking order
                isZero = false;
            }
            j++;
        }

        if (Math.abs(e-o) > 1) return -1; // if counts differ by more than 1, there is no alternating order of even and odd

        if (isZero) return 0; // if all in correct order, return 0

        if (e == o) { // if even and odd counts are equal
            int[] numscopy = new int[n];
            System.arraycopy(nums, 0, numscopy, 0, n); // another array for odd sum
            int eSum = sm(nums, n, 0, 1);
            int oSum = sm(numscopy, n, 1, 0);

            if (eSum == 0 && oSum == 0) return -1;

            if (eSum == 0) {
                return oSum > 0 ? oSum : -1;
            }
            
            if (oSum == 0) {
                return eSum > 0 ? eSum : -1;
            }

            return eSum < oSum ? eSum : oSum; // get the smallest # of swaps

        } else if (Math.abs(e-o) == 1) {
            if (e > o) {
                return sm(nums, n, 0, 1);

            } else {
                return sm(nums, n, 1, 0);
                
            }
        } else {
            return -1;
        }
    }

    public static int sm(int[] nums, int n, int eo, int oe) {
        int j = 1;
        int eoSum = 0;

        for (int i = 0; i < n; i += 2) {
            if (nums[i] % 2 == eo) {
                continue;
            } else {
                while (j < n && nums[j] % 2 == oe) {
                    j += 2;
                }

                if (j < n) {                    
                    eoSum += Math.abs(j - i);
                    nums[j] = nums[j] ^ nums[i];
                    nums[i] = nums[i] ^ nums[j];
                    nums[j] = nums[i] ^ nums[j];
                }
                j += 2;
            }

        }

        return eoSum;
    }
}

// odd = 1+1+1+3+1 = 7
// i=0
// j=1
//                                                                                    j     i
// 85, 64, 45, 28, 445, 100, 1, 98, 75, 72, 385, 272, 91, 302, 63, 34, 201, 18, 77, 664, =>2001, 3002 

// 84, 65, 45, 28, 445, 100, 1, 99, 74, 73, 384, 273, 91, 302, 62, 34, 201, 18, 76, 665, 2001, 3002
