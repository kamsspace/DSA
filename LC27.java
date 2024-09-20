// problem: 27. Remove Element
// difficulty: easy
// runtime: 0ms, beats 100%
// memory: 41.78MB, beats 68.28%
class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;

        int in = 0;
        int prev = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) continue;
            else {
                prev = nums[i];
                nums[in++] = prev;
            }
        }

        return in;
    }
}
