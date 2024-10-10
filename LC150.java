// problem: 150. Evaluate Reverse Polish Notation
// difficulty: medium
// runtime: 2ms, beats 99%
// memory: beats 60%
class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length;

        if (n == 1) return Integer.parseInt(tokens[0]);
        
        int[] s = new int[n];
        int last=-1;
        int first=201, second=201;

        for (int i = 0; i < n; i++) {
            String c = tokens[i];

            if ("+-*/".indexOf(c) == -1) {
                s[++last] = Integer.parseInt(c);
                continue;
            } else {
                second = s[last--];
                first = s[last--];
                
                s[++last] = operation(first,second,c);
            }

            
        }

        return s[last];
    }

    public static int operation(int a, int b, String op) {
        switch(op) {
            case "+": return a+b;
            case "-": return a-b;
            case "*": return a*b;
            case "/": return a/b;
            default: return 0;
        }
    }
}


// runtime: 3ms
class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length;

        if (n == 1) return Integer.parseInt(tokens[0]);
        
        int[] s = new int[n/2+2];
        int last=-1;
        int first=201, second=201;

        for (int i = 0; i < n; i++) {
            String c = tokens[i];

            if (c.equals("+")) {
                second = s[last--];
                first = s[last--];
                s[++last] = first+second;
                continue;
            } else if (c.equals("-")) {
                second = s[last--];
                first = s[last--];
                s[++last] = first-second;
                continue;
            } else if (c.equals("*")) {
                second = s[last--];
                first = s[last--];
                s[++last] = first*second;
                continue;
            } else if (c.equals("/")) {
                second = s[last--];
                first = s[last--];
                s[++last] = first/second;
                continue;
            } else {
                s[++last] = Integer.parseInt(c);
                continue;
            } 
        }

        return s[last];
    }
}

// ---------> next
class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length;

        if (n == 1) return Integer.parseInt(tokens[0]);
        
        int[] s = new int[n];
        int last=-1;
        int first=201, second=201;
        String ops = "+-/*";

        for (int i = 0; i < n; i++) {
            String c = tokens[i];

            if (ops.indexOf(c) == -1) {
                s[++last] = Integer.parseInt(c);
                continue;
            } else {
                second = s[last--];
                first = s[last--];
                
                s[++last] = operation(first,second,c);
            }

            
        }

        return s[last];
    }

    public static int operation(int a, int b, String op) {
        switch(op) {
            case "+": return a+b;
            case "-": return a-b;
            case "*": return a*b;
            case "/": return a/b;
            default: return 0;
        }
    }
}



// runtime: 5ms
class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length;

        if (n == 1) return Integer.parseInt(tokens[0]);
        
        Stack<Integer> s = new Stack<>();
        int first=201, second=201;

        for (int i = 0; i < n; i++) {
            String c = tokens[i];

            if ("+-*/".indexOf(c) == -1) {
                s.push(Integer.parseInt(c));
                continue;
            } else {
                second = s.pop();
                first = s.pop();
                
                s.push(operation(first,second,c));
            }

            
        }

        return s.peek();
    }

    public static int operation(int a, int b, String op) {
        switch(op) {
            case "+": return a+b;
            case "-": return a-b;
            case "*": return a*b;
            case "/": return a/b;
            default: return 0;
        }
    }
}


// runtime: 6ms
class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length;

        if (n == 1) return Integer.parseInt(tokens[0]);
        
        Stack<Integer> s = new Stack<>();
        int first=201, second=201;

        for (int i = 0; i < n; i++) {
            String c = tokens[i];

            if ("+-*/".indexOf(c) == -1) {
                s.push(Integer.parseInt(c));
                continue;
            } else {
                if (!s.empty()) {
                    second = s.pop();
                    first = s.pop();
                }
                
                s.push(operation(first,second,c));
            }

            
        }

        return s.peek();
    }

    public static int operation(int a, int b, String op) {
        switch(op) {
            case "+": return a+b;
            case "-": return a-b;
            case "*": return a*b;
            case "/": return a/b;
            default: return 0;
        }
    }
}
