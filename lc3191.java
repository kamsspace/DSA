// 3191. Minimum Operations to Make Binary Array Elements Equal to One I
// User Accepted:22910
// User Tried:24288
// Total Accepted:24246
// Total Submissions:36678
// Difficulty:Medium
// You are given a binary array nums.

// You can do the following operation on the array any number of times (possibly zero):

// Choose any 3 consecutive elements from the array and flip all of them.
// Flipping an element means changing its value from 0 to 1, and from 1 to 0.

// Return the minimum number of operations required to make all elements in nums equal to 1. If it is impossible, return -1.

// Example 1:
// Input: nums = [0,1,1,1,0,0]
// Output: 3

// Explanation:
// We can do the following operations:
// Choose the elements at indices 0, 1 and 2. The resulting array is nums = [1,0,0,1,0,0].
// Choose the elements at indices 1, 2 and 3. The resulting array is nums = [1,1,1,0,0,0].
// Choose the elements at indices 3, 4 and 5. The resulting array is nums = [1,1,1,1,1,1].
// Example 2:
// Input: nums = [0,1,1,1]
// Output: -1

// Explanation:
// It is impossible to make all elements equal to 1.

// Constraints:
// 3 <= nums.length <= 105
// 0 <= nums[i] <= 1


// Runtime: 5ms solution (beats 100%)
// Memory: 57.10MB (beats 85.10%)
class Solution {
    public int minOperations(int[] nums) {
        int count = 0, len = nums.length - 3, x = 0, y = 0, z = 0;
        x = nums[0];
        y = nums[1];
        z = nums[2];
        for (int m = 0; m < len; m++) {
            if (x == 0) {
                count++;
                x = 1;
                y = y == 0 ? 1 : 0;
                z = z == 0 ? 1 : 0;
                x = y;
                y = z;
                z = nums[m+3];
            } else {
                x = y;
                y = z;
                z = nums[m+3];
            }
        }
        if (x == 0 && y == 0 && z == 0) return ++count;
        if (x == 1 && y == 1 && z == 1) return count;
        return -1;
    }
}

// Runtime: 6ms solution (beats 99.99%)
// Memory: 56.93MB (beats 92.17%)
class Solution {
    public int minOperations(int[] nums) {
        int count = 0, len = nums.length - 2;
        for (int m = 0; m < len; m++) {
            if (nums[m] == 0) {
                count++;
                nums[m] = 1;
                if (nums[m + 1] == 0) nums[m + 1] = 1;
                else nums[m+1] = 0;
                if (nums[m + 2] == 0) nums[m + 2] = 1;
                else nums[m+2] = 0;
            }
        }
        if (nums[len] == 0 || nums[len + 1] == 0) return -1;
        else return count;
    }
}

// Runtime: 6ms solution (beats 99.99%)
// Memory: 57.18MB (beats 72.36%)
class Solution {
    public int minOperations(int[] nums) {
        int count = 0, len = nums.length - 2;
        for (int m = 0; m < len; m++) {
            if (nums[m] == 0) {
                count++;
                nums[m] = 1;
                nums[m + 1] = nums[m + 1] == 0 ? 1 : 0;
                nums[m + 2] = nums[m + 2] == 0 ? 1 : 0;
            }
        }
        if (nums[len] == 0 || nums[len + 1] == 0) return -1;
        else return count;
    }
}

// Runtime: 8ms solution (beats 36.20%)
// Memory: 57.23MB (beats 62.07%)
class lc3191 {
    public int minOperations(int[] nums) {
        int count = 0;
        for(int m=0; m<nums.length; m++){
            if(nums[m] == 0 && m < nums.length-2){
                count++;
                for(int l = m; l<m+3; l++){
                    if(nums[l] == 0)
                        nums[l]=1;
                    else
                        nums[l]=0;
                }
            }  
        }
        for(int i : nums){
            if(i == 0){
                return -1;
            }
        }
        return count;
        }
}
