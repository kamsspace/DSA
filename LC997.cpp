// problem: 997. Find the Town Judge
// difficulty: easy
// time complexity: O(m+n)
// space complexity: O(n)
class Solution {
public:
    int findJudge(int n, vector<vector<int>>& trust) {
        vector<int> right(n+1);
        vector<bool> left(n+1);
        int m = trust.size();

        for (int i = 0; i < m; i++) {
            left[trust[i][0]]=true;
            right[trust[i][1]]++;
        }

        int i = 1;

        while (i <= n) {
            if (!left[i] && right[i] == n - 1) {
                return i;
            }

            i++;
        }

        return -1;
    }
};
