// problem: 155. Min Stack
// difficulty: medium
// runtime: 4ms, beats 96%
// memory: 28%
class MinStack {
    // Stack<int[]> stack;
    int[] stack;
    int[] mn;
    int last;

    public MinStack() {
        stack = new int[30001];
        last = -1;
        mn = new int[30001];
    }
    
    public void push(int val) {
        // int l = last;
        if (last != -1 && mn[last] < val) {
                mn[++last] = mn[last-1];
                stack[last] = val;
        } else {
            stack[++last] = val;
            mn[last] = val;
        }
    }
    
    public void pop() {
        last--;
    }
    
    public int top() {
        return stack[last];
    }
    
    public int getMin() {
        return mn[last];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
