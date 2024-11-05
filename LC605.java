// problem: 605. Can Place Flowers
// difficulty: easy
// runtime: 0ms, beats 100%
// memory: 63%

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int l=flowerbed.length;
        int i=0;

        while (n>0 && i<l) {
            if (flowerbed[i] == 1) {
                i+=2;
            } else if (i == l-1 || flowerbed[i+1] == 0) {
                i+=2;
                n--;
            } else {
                i+=3;
            }
        }

        return n<=0;
    }
}
