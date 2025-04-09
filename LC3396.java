// problem: 3396. Minimum Number of Operations to Make ELements in Array Distinct
// difficulty: easy
// time: O(n)
// space: O(n)

class Solution {
    public int minimumOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        int minop = 0;

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            if (map.get(i) > 1) {
                set.add(i);
            }
        }

        if (!set.isEmpty()) {
            int n = nums.length;

            if (n < 3) return ++minop;
            
            for (int i = 0; i < n;) {
                int j = i + 3;

                if (n - i < 3 || j == n) {
                    return ++minop;
                }

                while (i < j) {
                    int v = map.get(nums[i]);

                    if (v == 1) {
                        map.remove(nums[i]);
                    } else if (v == 2) {
                        set.remove(nums[i]);
                        map.put(nums[i], 1);
                    } else {
                        map.put(nums[i], map.get(nums[i]) - 1);
                    }

                    i++;
                }

                // increment minop after removing 3 elements from nums
                minop++;

                // check if no duplicates in set, return minimum operations
                if (set.isEmpty()) {
                    return minop;
                }
            }
        }

        return minop;
    }
}
