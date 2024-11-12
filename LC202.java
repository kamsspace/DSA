// problem: 202. Happy Number
// difficulty: easy
// runtime: 0ms, beats 100%
// memory: 77%
class Solution {
    public boolean isHappy(int n) {
        if (n == 1) return true;

        int slow=n,fast=n;
        
        while (fast != 1 && nextSum(fast) != 1) {
            slow = nextSum(slow);
            fast = nextSum(nextSum(fast));

            if (slow == fast) {
                return false;
            }
        }

        return true;
    }

    public static int nextSum(int pace) {
        int sum = 0;

        while (pace > 0) {
            int k = pace % 10;
            sum += k*k;
            pace /= 10;
        }

        return sum;
    }
}
