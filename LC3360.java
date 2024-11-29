// problem: 3360. Stone Removal Game
// difficulty: easy
// time complexity: O(sqrt(n))
// space complexity: O(1)

class Solution {
    public boolean canAliceWin(int n) {
        int i = 0;
        int ten = 10;

        while (n >= ten) {
            n -= ten--;
            i++;
        }

        return i % 2 == 1;
    }
}
