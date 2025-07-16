// LeetCode problem: 3201. Find the Maximum Length of Valid Subsequence I
// Difficulty: medium
// time: O(n)
// space: O(1)
class Solution {
    public int maximumLength(int[] nums) {
        int zero = 0, one = 0;
        int two = 0, three = 0;
      
        for (int i : nums) {
            if (i % 2 == 0) {
                zero++;
                if (two % 2 == 0) {
                    two++;
                } 
                if (three % 2 == 1) {
                    three++;
                }
            } else {
                one++;
                if (two % 2 == 1) {
                    two++;
                } 
                if (three % 2 == 0) {
                    three++;
                }
            }
        }

        int lx = zero > one ? zero : one;
        int ly = two > three ? two : three;
        return lx > ly ? lx : ly;
    }
}
