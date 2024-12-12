// problem: 997. Find the Town Judge
// difficulty: easy
// time complexity: O(n+m)
// space complexity: O(n)

class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] right = new int[n+1];
        int[] left = new int[n+1];

        for (int[] row : trust) {
            left[row[0]]++;
            right[row[1]]++;
        }

        int i = 1;

        while (i <= n) {
            if (left[i] == 0 && right[i] == n-1) {
                return i;
            }
            i++;
        }

        return -1;
    }
}
