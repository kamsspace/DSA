// problem: 806. Number of Lines to Write String
// difficulty: easy
// time: 15 minutes
// runtime: 1ms, beats 45.74%
// memory: 41.40MB, beats 68.56%

class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int[] result = new int[2];
        result[0]++;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int n = widths[c - 97];
            if (100 - result[1] >= n) result[1] += n;
            else {
                result[0]++;
                result[1] = 0;
                result[1] += n;
            }
        }

        return result;
    }
}
