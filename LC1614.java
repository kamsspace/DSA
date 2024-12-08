// problem: 1614. Maximum Nesting Depth of the Parentheses
// difficulty: easy
// time complexity: O(n)
// space complexity: O(n)

class Solution {
    public int maxDepth(String s) {
        if (s.length() == 1) return 0;

        int mx = 0;
        char[] stack = new char[101];
        int last = -1;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack[++last] = '(';
                mx = Math.max(mx, last+1);
            } else if (ch == ')') {
                last--;
            }
        }

        return mx;
    }
}
