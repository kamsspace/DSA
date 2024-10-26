// problem: 739. Daily Temperatures
// difficulty: medium
// runtime: 3ms, beats 100%
// memory: 71%

class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        int n = temperatures.size();
        vector<int> answer(n);
        vector<int> index(101);
        int _s[n];
        int last = -1;

        for (int i=n-1;i>=0;i--) {
            int c = temperatures[i];

            while (last != -1 && _s[last] <= c) {
                last--;
            }

            index[c]=i;

            if (last == -1) answer[i] = 0;
            else answer[i] = index[_s[last]]-i;

            _s[++last] = c;
        }

        return answer;
    }
};
