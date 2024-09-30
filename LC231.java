// problem: 231. Power of Two
// difficulty: easy
// runtime: 1ms, beats 42%
class Solution {
    public boolean isPowerOfFour(int n) {
        if (n<=0) {
            return false;
        }

        while (n%4==0) {
            n/=4;
        }

        return n==1;
    }
}


// second solution
class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n<=0) {
            return false;
        }

        if (n%2==0) {
            return isPowerOfTwo(n/=2);
        }

        return n==1;
    }
}
