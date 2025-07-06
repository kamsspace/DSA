// LeetCode problem: 1865. Finding Pairs With a Certain Sum
// Difficulty: medium
// time: O(n)
// space: O(n)
class FindSumPairs {
    int[] nums1, nums2;
    Map<Integer,Integer> map;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        initializeMap();
    }

    private void initializeMap() {
        this.map = new HashMap<>();
        for (int i : nums2) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
    }
    
    public void add(int index, int val) {
        int x = nums2[index];
        int w = map.getOrDefault(x, 0);
        if (w == 1) map.remove(x);
        if (w > 1) map.put(x, w - 1);
        nums2[index] += val;
        map.put(nums2[index], map.getOrDefault(nums2[index], 0) + 1);
    }
    
    public int count(int tot) {
        int c = 0;
        for (int i : nums1) {
            if (!map.isEmpty() && map.containsKey(tot - i)) {
                c += map.get(tot - i);
            }
        }

        return c;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */
