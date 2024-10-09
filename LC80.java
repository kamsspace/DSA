// problem: 80. Remove Duplicates from Sorted Array II
// difficulty: medium
// runtime: 0ms, beats 100%
class Solution {
    public int removeDuplicates(int[] nums) {
        int in=1;
        int two=1;
        int prev=nums[0];

        for (int i=1; i<nums.length; i++)  {
            if (prev == nums[i]) {
                if (two >= 2) {
                    continue;
                }
                else {
                    nums[in++] = prev;
                    two++;
                }
            } else {
                prev = nums[i];
                nums[in++] = prev;
                two = 1;
            }
        }

        return in;
    }
}
