// problem: 171. Excel Sheet Column Number
// difficulty: easy
// runtime: 1ms, beats 90.60%
// memory: 41.75MB, beats 97.19%
class Solution {
    public int titleToNumber(String columnTitle) {
        int x = columnTitle.length() - 1;
        int sum = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            int d = (int) Math.pow(26,x--);
            sum = sum + d * ((int) columnTitle.charAt(i) - 64);
        }

        return sum;
    }
}
