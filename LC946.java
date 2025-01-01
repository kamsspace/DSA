// problem: 946. Validate Stack Sequences
// difficulty: medium
// time complexity: O(n)
// space complexity: O(n)

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int end = popped.length, start = 0;
        int i = 0;
        Stack<Integer> s = new Stack<>();

        while (i < end) {
            s.push(pushed[i++]);

            while (!s.isEmpty() && start < end && popped[start] == s.peek()) {
                s.pop();
                start++;
            }
        }

        while (!s.isEmpty() && start < end && popped[start] == s.peek()) {
            s.pop();
            start++;
        }

        // System.out.println(start + " " + s.isEmpty() + " " + end);
        if (start == end && s.isEmpty()) {
            return true;
        }
        return false;
    }
}


// version 2.0
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int end = popped.length, start = 0;
        int i = 0;
        int[] s = new int[end];
        int last = -1;

        while (i < end) {
            s[++last] = pushed[i++];

            while (last != -1 && start < end && popped[start] == s[last]) {
                last--;
                start++;
            }
        }

        while (last != -1 && start < end && popped[start] == s[last]) {
            last--;
            start++;
        }

        // System.out.println(start + " " + s.isEmpty() + " " + end);
        if (start == end && last == -1) {
            return true;
        }
        return false;
    }
}
