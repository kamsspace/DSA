// problem: 2942. Find Words Containing Characters
// difficulty: easy
// time complexity: O(n * m)
// space complexity: O(n)
class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        int n = words.length;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (words[i].indexOf(x) != -1) {
                list.add(i);
            }
        }

        return list;
    }
}
