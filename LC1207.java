// problem: 1207. Unique Number of Occurences
// difficulty: easy
// runtime: 2ms, beats 99.28%
// memory: 6%

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int[] map=new int[2001];
        int[] occ=new int[2001];

        for (int i:arr) {
            map[i+1000]++;
        }

        for (int i:map) {
            if (occ[i]>=1) return false;
            if (i>0) occ[i]++;
        }

        return true;
    }
}
