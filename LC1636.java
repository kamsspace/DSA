// runtime: 6ms, beats 75.35%
// memory: 44.53MB, beats 25.80%
class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> {
            int cmp = a.getValue().compareTo(b.getValue());
            if (cmp != 0) {
                return cmp;
            } else {
                return b.getKey().compareTo(a.getKey());
            }
        });
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : list) {
            int count = entry.getValue();
            while (count-- > 0) {
                nums[i++] = entry.getKey();
            }
        }
        return nums;
    }
}
