// problem: 50. pow(x,n)
// difficulty: medium
// runtime: 0ms, beats 100%
// memory: 41.76MB, beats 80.25%

class Solution {
    public double myPow(double x, int n) {
        if (x == 0 || x == 1 || n == 1) return x;
        if (n == 0) return 1;
        if (x == -1) return n % 2 == 0 ? 1 : -1;

        if (n < 0) {
            x = 1 / x;
            if (n == Integer.MIN_VALUE) {
                n = Integer.MAX_VALUE;
                return myPow(x, n) * x;
            } else n *= -1;
        }
        double res = myPow(x, n / 2);
        if ((n % 2) == 0) return res * res;
        else return x * res * res;
    }
}
