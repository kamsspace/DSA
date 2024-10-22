// problem: 442. Find All Duplicates in an Array
// difficulty: medium
// runtime: 5ms, beats 94%
// memory: 80%

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int[] map = new int[100001];

        for (int i : nums) {
            if (++map[i] > 1) list.add(i);
        }

        return list;
    }
}
