// problem: 3046. Split the Arrays
// difficulty: easy
// time complexity: O(n)
// space complexity: O(n);

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
