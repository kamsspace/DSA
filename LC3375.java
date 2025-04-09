// problem: 3375. Minimum Operations to Make Array Values Equal to K
// difficulty: easy
// time: O(n logn)
// space: O(n)

class Solution {
    public int minOperations(int[] nums, int k) {
        TreeSet<Integer> set = new TreeSet<>();

        for (int i : nums) {
            if (i < k) return -1;
            set.add(i);
        }

        if (set.first() > k) return set.size();
        else return set.size() - 1;
    }
}


// time: O(n)
// space: O(n)

class Solution {
    public int minOperations(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();

        for (int i : nums) {
            if (i < k) return -1;
            if (i == k) continue;
            set.add(i);
        }

        return set.size();
        // else return set.size() - 1;
    }
}
