// LeetCode problem: 1957. Delete Characters to Make Fancy String
// Difficulty: easy
// time: O(n)
// space: O(n)
class Solution {
    public String makeFancyString(String s) {
        int c = 0;
        char x = ' ';
        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (x == ch) {
                if (c < 2) {
                    c++;
                    sb.append(ch);
                } else continue;
            } else {
                c = 1;
                x = ch;
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}
