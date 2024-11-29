// problem: 3174. Clear Digits
// difficulty: easy
// time complexity: O(n)
// space complexity: O(n)

class Solution {
public:
    string clearDigits(string s) {
        vector<char> clearDigits;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            if (isdigit(s.at(i))) {
                clearDigits.pop_back();
            } else {
                clearDigits.push_back(s.at(i));
            }
        }

        string str(clearDigits.begin(), clearDigits.end());
        return str;
    }
};
