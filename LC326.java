// problem: 326. Power of Three
// difficulty: easy
// runtime: 8ms, beats 89%
class Solution {
    public boolean isPowerOfThree(int n) {
        int max = 1162261467;
        // if (n <= 0) return false;

        // while (n%3 == 0) n/=3;
        // int division = (int) (Math.log(n) / Math.log(3));

        return n > 0 && max % n == 0;
    }
}


// second solution
class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;

        while (n%3 == 0) n/=3;
        // int division = (int) (Math.log(n) / Math.log(3));

        return n == 1;
    }
}


// third solution
class Solution {
    public boolean isPowerOfThree(int n) {
        if (n<=0) {
            return false;
        }

        if (n%3==0) {
            return isPowerOfThree(n/=3);
        }
        return n==1;
    }
}
