// problem: 2381. Shifting Letters II
// difficulty: medium
// time complexity: O(m+n)
// space complexity: O(n)
class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] shift_effect = new int[n + 1];

        for (int[] shift : shifts) {
            if (shift[2] == 1) {
                shift_effect[shift[0]] += 1;
                shift_effect[shift[1]+1] -= 1;
            } else {
                shift_effect[shift[0]] -= 1;
                shift_effect[shift[1]+1] += 1;
            }
        }

        int current_shift = 0;
        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < n; i++) {
            current_shift += shift_effect[i];

            shift_effect[i] = ((current_shift % 26) + 26) % 26;

            int originalChar = s.charAt(i) - 'a';
            int newChar = (originalChar + shift_effect[i]) % 26;
            sb.setCharAt(i, (char) (newChar + 'a'));
        }

        return sb.toString();
    }
}


// version 2.0
// with less overhead for string manipulation by simply using char array
class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        char[] ch = s.toCharArray();
        int[] shift_effect = new int[n + 1];

        for (int[] shift : shifts) {
            if (shift[2] == 1) {
                shift_effect[shift[0]] += 1;
                shift_effect[shift[1]+1] -= 1;
            } else {
                shift_effect[shift[0]] -= 1;
                shift_effect[shift[1]+1] += 1;
            }
        }

        int current_shift = 0;
        // StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < n; i++) {
            current_shift += shift_effect[i];

            int shifted_char = (ch[i] - 'a' + current_shift) % 26;
            if (shifted_char < 0) {
                shifted_char += 26;
            }
            ch[i] = (char) (shifted_char + (int) 'a');
        }

        return new String(ch);
    }
}
