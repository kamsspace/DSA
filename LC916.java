// problem: 916. Word Subsets
// difficulty: medium
// time complexity: O(N)
// space complexity: O(1)

class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int n2 = words2.length;
        Map<Character,Integer> c = new HashMap<>();

        for (String word : words2) {
            Map<Character,Integer> current = new HashMap<>();
            for (char ch : word.toCharArray()) {
                current.put(ch, current.getOrDefault(ch, 0) + 1);
            }

            for (char ch : current.keySet()) {
                c.put(ch, Math.max(c.getOrDefault(ch,0),current.get(ch)));
            }
        }

        List<String> list = new ArrayList<>();
        for (String word : words1) {
            Map<Character,Integer> current = new HashMap<>();
            for (char ch : word.toCharArray()) {
                current.put(ch, current.getOrDefault(ch, 0) + 1);
            }

            boolean valid = true;
            for (char ch : c.keySet()) {
                if (c.get(ch) > current.getOrDefault(ch,0)) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                list.add(word);
            }
        }

        return list;
    }
}
