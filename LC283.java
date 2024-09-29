// problem: 283. Move Zeros
// difficulty: easy
// runtime: 2ms, beats 84%
// memory: 45MB, beats 67%
class Solution {
    public void moveZeroes(int[] nums) {
        int n=nums.length;
        int j=0,c=0;

        for (int i=0; i<n;i++) {

            if (nums[i] == 0) {
                c++;
                continue;
            } else {
                if (c>0) {
                    nums[j++] = nums[i];
                    nums[i] = 0;
                } else j++;
            } 
        }
    }
}
