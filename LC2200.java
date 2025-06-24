// LeetCode problem: 2200 Find All K-Distant Indices in an Array
// difficulty: easy
// time: O(n)
// space: O(n)
class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> kdi = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == key) {
                int j = i - k;
                while (j <= i + k) {
                    if (kdi.isEmpty()) {
                        if (j >= 0 && j < n) {
                            kdi.add(j);
                        }
                    } else{
                        if (j >= 0 && j > kdi.get(kdi.size() - 1) && j < n) {
                            kdi.add(j);
                        }
                    }
                    j++;
                }
            }
        }

        return kdi;
    }
}
