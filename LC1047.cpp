// problem: 1047. Remove All Adjacent Duplicates in String
// difficulty: easy
// runtime: 0ms, beats 100%
// memory: 11MB, beats 95%

class Solution {
public:
    string removeDuplicates(string s) {
        int last = -1;

        for (char c : s) {
            if (last != -1 && c == s.at(last)) {
                last--;
            } else {
                s.at(++last)=c;
            }
        }

        s.resize(last+1);
        return s;
    }
};
