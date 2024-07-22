// problem: sort even and odd indices of an array separately.

// 1.
// runtime: 6ms, beats 28.55%
// memory: 44.59MB, beats 32.77%
class Solution {
    public int[] sortEvenOdd(int[] nums) {
        int n = nums.length;
        int[] evenIndices = new int[(n + 1) / 2];
        for (int i = 0; i < n; i += 2) {
            evenIndices[i / 2] = nums[i];
        }
        Integer[] oddIndices = new Integer[n / 2];
        for (int i = 1; i < n; i += 2) {
            oddIndices[i / 2] = nums[i];
        }
        Arrays.sort(evenIndices);
        Arrays.sort(oddIndices, Collections.reverseOrder());
        for (int i = 0; i < evenIndices.length; i++) {
            nums[2 * i] = evenIndices[i];
        }
        for (int i = 0; i < oddIndices.length; i++) {
            nums[2 * i + 1] = oddIndices[i];
        }
        return nums;
    }
}

// 2.
// runtime: 4ms, beats 51.33%
// memory: 44.26MB, beats 84.94%
class Solution {
    public int[] sortEvenOdd(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((i % 2 == 0 && j % 2 == 0 && nums[i] > nums[j]) ||
                        (i % 2 != 0 && j % 2 != 0 && nums[i] < nums[j])) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }
}
