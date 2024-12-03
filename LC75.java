// problem: 75. Sort Colors
// difficulty: medium
// time complexity: O(n)
// space complexity: O(1)

// counting 0s, 1s, and 2s
// setting 0s, 1s, and 2s back to nums array
class Solution {
    public void sortColors(int[] nums) {
        int[] zero12 = new int[3];
        int n = nums.length;

        for (int i=0; i<n; i++) {
            zero12[nums[i]]++;
        }

        int i = zero12[0];
        int j = 0;

        for (; j<i; j++) {
            nums[j] = 0;
        }

        i = zero12[0]+zero12[1];
        j = zero12[0];

        for (; j<i; j++) {
            nums[j] = 1;
        }

        i = zero12[0] + zero12[1] + zero12[2];
        j = zero12[0] + zero12[1];

        for (; j<i; j++) {
            nums[j] = 2;
        }
    }
}



// bubble sort 
// time complexity: O(n^2)
// space complexity: O(n)
class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        for (int i=0; i<n-1; i++) {
            for (int j=0; j<n-1-i; j++) {
                if (nums[j] > nums[j+1]) {
                    swap(nums,j,j+1);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
