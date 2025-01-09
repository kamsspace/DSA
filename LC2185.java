// problem: 2185. Counting the Words with a Give Prefix
// difficulty: easy
// time complexity: O(n)
// space complexity: O(1)

class Solution {
    public int prefixCount(String[] words, String pref) {
        int n = words.length;
        int c = 0;

        for (String s : words) {
            if (s.startsWith(pref)) {
                c++;
            }
        }

        return c;
    }
}
