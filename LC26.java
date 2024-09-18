// problem: 26. Remove Duplicates from Sorted Array
// difficulty: easy
// runtime: 3ms, beats 9.69%
// memory: 44.70MB, beats 44.75%
class Solution {
    public int removeDuplicates(int[] nums) {
        Set<Integer> s = new HashSet<>();
        List<Integer> l = new ArrayList<>();

        for (int i : nums) {
            if (!s.contains(i)) {
                s.add(i);
                l.add(i);
            }
        }

        int in = 0;
        for (int i : l) {
            nums[in++] = i;
        }

        return l.size();
    }
}




// runtime: 0ms, beats 100%
// memory: 44.50MB, beats 80.63%
class Solution {
    public int removeDuplicates(int[] nums) {
        int prev = nums[0];
        int in = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == prev) continue;
            else {
                prev = nums[i];
                nums[in++] = prev;
            }
        }

        return in;
    }
}
