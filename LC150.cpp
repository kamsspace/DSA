// problem: Evaluate Reverse Polish Notation
// difficulty: medium
// runtime: 4ms, beats 91%
// memory: 82%
class Solution {
public:
    int operation(int &a, int &b, string& op) {
        if (op == "+") return a+b;
        else if (op == "-") return a-b;
        else if (op == "*") return a*b;
        else return a/b;
    }

    int evalRPN(vector<string>& tokens) {
        int n = tokens.size();
        // int _stack[n];
        stack<int> _stack;
        const string ops = "+-/*";
        int first=201,second=201,last=-1;

        for (int i=0;i<n;i++) {
            string c = tokens[i];

            if (ops.find(c) == string::npos) {
                _stack.push(std::stoi(c));
                continue;
            } else {
                second = _stack.top();
                _stack.pop();
                first = _stack.top();
                _stack.pop();
                _stack.push(operation(first, second, c));
            }
        }

        return _stack.top();
    }
};
