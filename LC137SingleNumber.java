//137. Single Number II
//Medium
//Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.
//
//You must implement a solution with a linear runtime complexity and use only constant extra space.
//
//Example 1:
//
//Input: nums = [2,2,3,2]
//Output: 3
//Example 2:
//
//Input: nums = [0,1,0,1,0,1,99]
//Output: 99
//
//
//Constraints:
//
//        1 <= nums.length <= 3 * 104
//        -231 <= nums[i] <= 231 - 1
//Each element in nums appears exactly three times except for one element which appears once.
// Runtime: 0 ms | beats 100.0%
// Memory: 45.26MB | beats 52.74%
class Solution {
    public int singleNumber(int[] nums) {
        int a = 0;
        int b = 0;
        for (int i : nums) {
            a = a ^ i & (~b);
            b = b ^ i & (~a);
        }
        return a;
    }
}
