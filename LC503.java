// problem: 503. Next Greater Element II
// difficulty: medium
// runtime: 2ms, beats 99.58%
// memory: 88%

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int last = -1;
        int[] _stack = new int[n];
        int[] nums2 = new int[n];

        for (int i = 2 * n -1; i >= 0; i--) {
            int in = i % n;

            while (last != -1 && _stack[last] <= nums[in]) 
                last--;
            
            nums2[in] = last == -1 ? -1 : _stack[last];
            _stack[++last] = nums[in];
        }

        return nums2;
    }
}


