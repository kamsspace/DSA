// problem: 2554. Maximum Number of Integers to Choose from Range I
// difficulty: medium
// time complexity: O(n)
// space complexity: O(n)

class Solution {
public:
    int maxCount(vector<int>& banned, int n, int maxSum) {
        vector<int> v(10001);
        int sum = 0;
        int count = 0;

        for (int i : banned) {
            v[i]++;
        }

        for (int i = 1; i <= n; i++) {
            if (v[i]==0 && maxSum >= sum+i) {
                sum += i;
                count++;
            }
        }

        return count;
    }
};


// version 1.0
class Solution {
public:
    int maxCount(vector<int>& banned, int n, int maxSum) {
        set<int,less<int>> s;
        int sum = 0;
        int count = 0;

        for (int i : banned) {
            s.insert(i);
        }

        for (int i = 1; i <= n; i++) {
            if (s.find(i) == s.end() && maxSum >= sum+i) {
                sum += i;
                count++;
            }
        }

        return count;
    }
};


// version 0.0
class Solution {
public:
    int maxCount(vector<int>& banned, int n, int maxSum) {
        set<int> s;
        int sum = 0;
        int count = 0;

        for (int i : banned) {
            s.insert(i);
        }

        for (int i = 1; i <= n; i++) {
            if (s.find(i) == s.end() && maxSum >= sum+i) {
                sum += i;
                count++;
            }
        }

        return count;
    }
};
