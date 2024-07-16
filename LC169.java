// Majority Element
// Runtime: 12ms, beats 35.88%
// Memory: 49.76MB, beats 72.36%
class Solution {
    public int majorityElement(int[] nums) {
        int k = 0, v = 0;
        Map<Integer,Integer> m = new HashMap<>();
        for (int i : nums) m.put(i, m.getOrDefault(i, 0) + 1);
        for (var e : m.entrySet()) {
            if (v < e.getValue()) {
                v = e.getValue();
                k = e.getKey();
            }
        }
        return k;
    }
}

class Solution {
    public int majorityElement(int[] nums) {
            int m = 0, v = 0;
            Hashtable<Integer,Integer> t = new Hashtable<>();
            for (int i : nums) t.put(i, t.getOrDefault(i, 0) + 1);
            for (var e : t.entrySet()) {
                if (v < e.getValue()) {
                    v = e.getValue();
                    m = e.getKey();
                }
            }
            return m;
        }
}
