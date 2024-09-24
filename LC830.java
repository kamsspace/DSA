// problem: 830. Positions of Large Groups
// difficulty: easy
// runtime: 1ms, beats 100%
// memory: 44.59MB, beats 64%

class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        if (s.length() < 3) return new ArrayList<>();
        int count = 0;
        char prev = ' ';
        int start = -1;
        int in = -1;
        List<List<Integer>> list = new ArrayList<>();

        for (char c : s.toCharArray()) {
            in++;
            if (c == prev) {
                count++;
            } else {
                if (count > 2) {
                    // end = in-1;
                    List<Integer> l = new ArrayList<>();
                    l.add(start);
                    l.add(in-1);
                    list.add(l);
                }

                count = 1;
                prev = c;
                start = in;
            }
        }

        if (count > 2) {
            // end = in;
            List<Integer> l = new ArrayList<>();
            l.add(start);
            l.add(in);
            list.add(l);
        }

        return list;
    }
}
