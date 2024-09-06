// problem: 290. Word Pattern.
// difficulty: easy
// runtime: 1ms, beats 81.62%
// memory: 41.08MB, beats 94.12%
class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String> map = new HashMap<>();
        HashMap<String,Character> map2 = new HashMap<>();
        String[] words = s.split(" ");

        if (words.length != pattern.length()) return false;

        int i = 0;

        for (char c : pattern.toCharArray()) {
            if (map.containsKey(c)) {
                if (!map.get(c).equals(words[i])) return false;
            } else if (map2.containsKey(words[i])) return false;
            else {
                map.put(c,words[i]);
                map2.put(words[i],c);
            }
            
            i++;
        }

        return true;
    }
}
