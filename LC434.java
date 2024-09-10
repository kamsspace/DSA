// problem: 434. Number of Segments in a String
// difficulty: easy
// runtime: 1ms, beats 27%
// memory: 41.01MB, beats 81%
class Solution {
    public int countSegments(String s) {
        if (s.trim().isEmpty()) return 0;
        return s.trim().replaceAll("\\s+", " ").split(" ").length;
    }
}
