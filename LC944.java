// problem: 944. Delete Columns to Make Sorted
// difficulty: easy
// runtime: 7ms, beats 85.85%
// memory: 44.35MB, beats 38.13%
class Solution {
    public int minDeletionSize(String[] strs) {
        if (strs.length == 1) return 0;

        int c = 0;
        int l = strs[0].length();

        for (int i = 0; i < l; i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j-1].charAt(i) > strs[j].charAt(i)) {
                    c++;
                    break;
                }
            }
        }

        return c;
    }
}
