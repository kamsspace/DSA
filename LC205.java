// problem: 205. Isomorphic Strings
// difficulty: easy
// runtime: 17ms, beats 25.40%
// memory: 42.35MB, beats 56.65%
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() == 1) return true;

        HashMap<Character,Character> mapS = new HashMap<>();
        HashMap<Character,Character> mapT = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (!mapS.containsKey(c1)) mapS.put(c1,c2); 
            else if (mapS.get(c1) != c2) return false; 
            if (!mapT.containsKey(c2)) mapT.put(c2,c1); 
            else if (mapT.get(c2) != c1) return false; 
        }

        return true;
    }
}
