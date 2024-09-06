// problem: 345. Reverse Vowels in a String
// difficulty: easy
// runtime: 4ms, beats 49.95%
// memory: 44.66MB, beats 86.81%
class Solution {
    public String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' 
            || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                sb.append(c);
            }
        }

        String s2 = sb.reverse().toString();
        sb = new StringBuilder();
        int j = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
            || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                sb.append(s2.charAt(j++));
            } else sb.append(c);
        }

        return sb.toString();
    }
}
