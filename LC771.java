// problem: 771. Jewels and Stones
// difficulty: easy
// runtime: 0ms, beats 100%
//          1ms, beats 54%
// memory: 30%

// 0ms
class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int i = 0;
        
        for (char c : jewels.toCharArray()) {
            for (char cc : stones.toCharArray()) {
                if (c == cc) i++;
            }
        }

        return i;
    }
}


// 1ms, memory 80%
class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> set = new HashSet<>();

        for (char c : jewels.toCharArray()) {
            set.add(c);
        }

        int i = 0;

        for (char c : stones.toCharArray()) {
            if (set.contains(c)) i++;
        }

        return i;
    }
}
