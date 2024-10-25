// problem: 682. Baseball Game
// difficulty: easy
// runtime: 0ms, beats 100%
// memory: 78%
class Solution {
public:
    int calPoints(vector<string>& operations) {
        int _s[operations.size()];
        int last=-1,f=0,s=0;
        string ops="CD+";

        for (string c : operations) {
            if (ops.find(c) == string::npos) {
                _s[++last]=std::stoi(c);
                continue;
            } else if (c.find("C") != string::npos) {
                last--;
                continue;
            } else if (c.find("D") != string::npos) {
                f=_s[last];
                _s[++last]=2*f;
                continue;
            } else {
                s=_s[last];
                f=_s[last-1];
                _s[++last]=f+s;
            }
        }

        if (last<0) return 0;
        else {
            while (last>0) {
                _s[0]+=_s[last--];
            }

            return _s[last];
        }
    }
};
