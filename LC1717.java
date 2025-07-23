// LeetCode problem: 1717. Maximum Score From Removing Substrings
// Difficulty: medium
// Time: O(n)
// Space: O(n)
// DSA: String, Stack, Greedy, Biweekly Contest 43

class Solution {
    public int maximumGain(String s, int x, int y) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();

        int i = 0;
        int aba = 0;
        int bab = 0;
        char ch1, ch2;
        StringBuilder sb = new StringBuilder();
        int big = 0;
        int small = 0;

        if (x >= y) {
            big = x;
            small = y;
            ch1 = 'a';
            ch2 = 'b';
        } else {
            big = y;
            small = x;
            ch1 = 'b';
            ch2 = 'a';
        }

        while (i < n) {
            char ch = s.charAt(i);
            
            if (!stack.isEmpty() && stack.peek() == ch1 && ch == ch2) {
                stack.pop();
                aba += big;
            } else {
                stack.push(ch);
            }

            i++;
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        stack.clear();
        s = sb.toString();
        i = s.length() - 1;

        while (i >= 0) {
            char ch = s.charAt(i);
            
            if (!stack.isEmpty() && stack.peek() == ch2 && ch == ch1) {
                stack.pop();
                bab += small;
            } else {
                stack.push(ch);
            }

            i--;
        }

        return aba + bab;
    }
}
