// LeetCode problem: 1394. Find Lucky Integer in an Array
// Difficulty: easy
// time: O(n)
// space: O(n)

class Solution {
    public int findLucky(int[] arr) {
        int n = arr.length;
        Map<Integer,Integer> nums = new HashMap<>();

        for (int i = 0; i < n; i++) {
            nums.put(arr[i], nums.getOrDefault(arr[i],0)+1);
        }

        int lucky = -1;
        for (int i : nums.keySet()) {
            if (nums.get(i) == i) {
                lucky = Math.max(i,lucky);
            }
        }

        return lucky;
    }
}


// simple array
class Solution {
    public int findLucky(int[] arr) {
        int n = arr.length;
        int[] nums = new int[501];

        for (int i : arr) {
            nums[i]++;
        }

        int j = 0, lucky = -1;
        for (int i : nums) {
            if (i == 0) {j++; continue;}
            if (j == i) {
                lucky = Math.max(j,lucky);
            }
            j++;
        }

        return lucky;
    }
}
