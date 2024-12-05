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


// version 2.0
class Solution {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> m = new HashSet<>();
        for (int i : arr) {
            if (m.contains(i * 2) || (i % 2 == 0 && m.contains(i / 2))) {
                return true;
            }
            m.add(i);
        }
        return false;
    }
}
