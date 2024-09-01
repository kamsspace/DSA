// problem: 20. Valid Parentheses
// difficulty: easy
// runtime: 1ms, beats 98.72%
// memory: 41.84MB, beats 12.41%
class Solution {
    public boolean isValid(String s) {
        
        if (s.length() == 1) return false;

        Deque<Character> deque = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                deque.push(c);
            } else if (!deque.isEmpty()) { // avoids NullPointerException to the stack deque.
                if (c == ')') {
                    if (deque.peek() == '(') deque.pop();
                    else return false;
                } else if (c == ']') {
                    if (deque.peek() == '[') deque.pop();
                    else return false;
                } else if (c == '}') {
                    if (deque.peek() == '{') deque.pop();
                    else return false;
                }
            } else return false; // stops when there are extra closing parentheses than necessary
        }
        
        if (!deque.isEmpty()) return false; // checks whether there are extra opening parentheses
        return true;
    }
}
