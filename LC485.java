// problem: 485. Max Consecutive Ones
// difficulty: easy
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max=0,c=0;

        for (int i : nums) {
            if (i==1) {
                c++;
                max=Math.max(c,max);
            }

            else {
                c=0;
            }
            
        }

        return max;


    }
}
