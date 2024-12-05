// problem: 1346. Check if N and its Double exists
// difficulty: easy
// time complexity: O(nlogn)
// space complexity: O(n)

class Solution {
public:
    bool checkIfExist(vector<int>& arr) {
        map<int,int> m;

        for (int i : arr) {
            if (m.find(i*2) != m.end() || i%2 == 0 && m.find(i/2) != m.end()) {
                return true;
            }
            m[i]++;
        }
        return false;
    }
};
