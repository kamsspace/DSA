// problem: 383. Ransome Note
// difficulty: easy
// runtime: 14ms, beats 31.23%
// memory: 44.85MB, beats 58.85%

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;

        HashMap<Character,Integer> map = new HashMap<>();
        char[] r = ransomNote.toCharArray();
        char[] m = magazine.toCharArray();

        for (char c : m) {
            if (map.containsKey(c)) {
                map.put(c,map.get(c)+1);
            } else map.put(c,1);
        }

        for (char c : r) {
            if (!map.containsKey(c)) {
                return false;
            } else {
                map.put(c,map.get(c)-1);      
            }
            if (map.get(c) == 0) {
                map.remove(c);
            }
        }

        return true;
    }
}
