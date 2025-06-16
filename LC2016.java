/*
LeetCode problem: 2016. Maximum Difference Between Increasing Elements
Difficulty: easy
Time: O(n)
Space: O(1)
*/

class Solution {
    public int maximumDifference(int[] nums) {
        if (nums.length == 2) {
            return nums[1] > nums[0] ? nums[1] - nums[0] : -1;
        }

        int mx = nums[0];
        int mn = nums[0];
        int mxDiff = -1;

        int diff = -1;
        for (int i = 0; i < nums.length; i++) {
            if (mn > nums[i]) {
                mn = nums[i];
                mx = nums[i];
                diff = -1;
            } else if (mn < nums[i]) {
                mx = nums[i];
                diff = mx - mn;
                mxDiff = Math.max(diff, mxDiff);
            }
        }

        return mxDiff;
    }
}

/*


nums: 7, 5, 3, 42, 6, 21, 34, 5, 2, 99, 54, 32, 1
mini: 7  5  3  3   3  3   3   3  2  2   2   2   1    
maxi: 7  5  3  42  6  21  34  5  2  99  54  32  1
diff:-1 -1 -1  39  3  18  31  2 -1  97  52  30  -1

solution #1: counting sort with 10^9 size array
after counting sort, find the two numbers from the front and from the end and return the difference
requires 10^9 size array (space = O(n)) and sorting and searching takes time = O(n)

solution #2: 
check only smallest possible number and the highest possible number from a range of numbers
until those range of two numbers changes, keep looking
requires space = O(1) and time = O(n)

I will go with solution #2.
 */
