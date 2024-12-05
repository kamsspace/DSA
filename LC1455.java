// problem: 1455. Check If a Word Occurs as a Prefix of Any Word in a Sentence
// difficulty: easy
// time complexity: O(n)
// space complexity: O(n)

class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        int i = 1;

        for (String word : words) {
            if (word.indexOf(searchWord) == 0) {
                return i;
            }
            i++;
        }

        return -1;
    }
}
