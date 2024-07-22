// problem: 2418. Sort the People
// runtime: 7ms, beats 90.64%
// memory: 45.22MB, beats 50.36%

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> map = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < names.length; i++) {
            map.put(heights[i], names[i]);
        }
        int ind = 0;
        for (Map.Entry<Integer, String> i : map.entrySet()) {
            names[ind++] = i.getValue();
        }
        return names;
    }
}
