// problem: 390. Elimination Game
// difficulty: medium
// runtime: 0ms, beats 100%
// memory: 9.75MB, beats 27%

class Solution {
public:
    int lastRemaining(int n) {
        return eliminateLeftFirst(1,n,1,n);
    }

    int eliminateLeftFirst(int start, int last, int diff, int n) {
        if (n == 1) return start;
        if (n % 2 == 1)
            last -= diff;
        return eliminateRightFirst(start+diff, last, diff*2, n/2);
    }

    int eliminateRightFirst(int start, int last, int diff, int n) {
        if (n == 1) return start;
        if (n % 2 == 1)
            start += diff;
        return eliminateLeftFirst(start, last-diff, diff*2, n/2);
    }
};
