// problem: 819. Most Common Word
// difficulty: easy
// time: 17 minutes
// runtime: 11ms, beats 86.90%
// memory: 43.30MB, beats 18.69%

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] p = paragraph.toLowerCase().replaceAll("['.,;!?]", " ").split(" ");
        HashMap<String, Integer> map = new HashMap<>();
        String b = String.join("", banned);

        for (String s : p) {
            if (!(b.contains(s))) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }

        int max = 0;
        StringBuilder maxS = new StringBuilder();

        for (String s : map.keySet()) {
            int v = map.get(s);
            if (max < v) {
                maxS = new StringBuilder(s);
                max = v;
            }
        }

        return maxS.toString();
    }
}
