// problem: 2696. Minimum String Length After Removing Substrings
// difficulty: easy
// runtime: 4-5ms, beats 84%
class Solution {
    public int minLength(String s) {
        if (s.length() == 1) return 1;

        Stack<Character> stack = new Stack<>();
        int count = 0;

        for (char c : s.toCharArray()) {
            if (stack.empty()) {
                stack.push(c);
                continue;
            }

            if (c == 'B' && stack.peek() == 'A') {
                stack.pop();
                continue;
            }

            if (c == 'D' && stack.peek() == 'C') {
                stack.pop();
                continue;
            } else stack.push(c); 
        }

        return stack.size();
    }
}


class Solution {
    public int minLength(String s) {
        if (s.length() == 1) return 1;

        Stack<Character> stack = new Stack<>();
        char temp = ' ';

        for (char c : s.toCharArray()) {
            if (!stack.empty()) temp = stack.peek();
            else temp = ' ';
            if (c == 'B' && temp == 'A' || c == 'D' && temp == 'C') {
                stack.pop();
            } else stack.push(c);
        }

        return stack.size();
    }
}
