// LeetCode problem: 3597. Partition String
// difficulty: medium
// time: O(n^2)
// space: O(n^2)
class Solution {
    public List<String> partitionString(String s) {
        Set<String> segments = new LinkedHashSet<>();
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            sb.append(c);
            String w = sb.toString();
            
            if (!segments.contains(w)) {
                sb.setLength(0);
                segments.add(w);
            }
        }

        return new ArrayList<>(segments);
    }
}
