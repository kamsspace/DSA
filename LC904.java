// LeetCode problem: 904. Fruit Into Baskets
// Difficulty: medium
// Time: O(n)
// Space: O(1)
// DSA: Array, Hash Table, Sliding Window, Weekly Contest 102

class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        
        if (n == 1) return 1;

        int mxPick = 2;
        int basket1 = fruits[0];
        int basket1Cnt = 1;
        int basket2 = -1, basket2Cnt = 0;
        int lastFruit = basket1;
        int lastFruitCnt = 1;

        for (int i = 1; i < n; i++) {
            if (basket1 == fruits[i]) {
                basket1Cnt++;
            } else if (basket2 == -1 || basket2 == fruits[i]) {
                if (basket2 == -1) {
                    basket2 = fruits[i];
                }
                basket2Cnt++;
            } else {
                basket1 = lastFruit;
                basket1Cnt = lastFruitCnt;
                basket2 = fruits[i];
                basket2Cnt = 1;
            }

            if (fruits[i] == lastFruit) {
                lastFruitCnt++;
            } else {
                lastFruit = fruits[i];
                lastFruitCnt = 1;
            }

            mxPick = Math.max(mxPick, basket1Cnt + basket2Cnt);
        }

        return mxPick;
    }
}
