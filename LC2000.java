// problem: 2000. Reverse Prefix of Word
// difficulty: easy
// runtime: 0ms, beats 100%
// memory: 89%
class Solution {
    public String reversePrefix(String word, char ch) {
        int i = word.indexOf(ch);

        if (i == -1) return word;

        StringBuilder sb = new StringBuilder();

        for (int j=i;j>=0;j--) {
            sb.append(word.charAt(j));
        }

        sb.append(word.substring(i+1));

        return sb.toString();
    }
}
