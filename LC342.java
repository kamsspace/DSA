// problem: 342. Power of Four
// difficulty: easy
// runtime: 0ms, beats 100%
// memory: 64%
class Solution {
    public boolean isPowerOfFour(int n) {
        if (n<=0) {
            return false;
        }

        if (n%4==0) {
            return isPowerOfFour(n/=4);
        }

        return n==1;
    }
}


// second solution
// runtime: 1ms, beats 29%
// memory: 35%
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
