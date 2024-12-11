// problem: 15. 3Sum
// difficulty: medium
// time complexity: O(n^2)
// space complexity: O(n^2)

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        int k;

        for (int i = 0; i < n-2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            int left = i + 1; 
            int right = n - 1;
            k = nums[i];

            while (left < right) {
                int sum = k + nums[left] + nums[right];

                if (sum == 0) {
                    list.add(Arrays.asList(k, nums[left] , nums[right]));

                    while (left < right && nums[left] == nums[left+1]) {
                        left++;
                    }

                    while (left < right && nums[right] == nums[right-1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return list;
    }
}
