// runtime: 1ms, beats 99.97%
// memory: 55.34MB, beats 50.77%
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int l = nums.length;
        int[] res = new int[l];
        int left = 1;
        for (int i = 0; i < l; i++) {
            res[i] = left;
            left *= nums[i];
        }
        int right = 1;
        for (int i = l - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}
