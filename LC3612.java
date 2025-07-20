// LeetCode problem: 3612. Process String with Special Operations I
// Difficulty: medium
// time: O(n)
// space: O(n)
class Solution {
    public String processStr(String s) {
        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()) {
            switch (ch) {
                case '#': sb.append(sb); break;
                case '%': sb.reverse(); break;
                case '*': if (sb.length() > 0) sb.deleteCharAt(sb.length()-1); break;
                default: sb.append(ch);
            }
        }

        return sb.toString();
    }
}
