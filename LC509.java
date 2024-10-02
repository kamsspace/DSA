// problem: 509. Fibonacci Number
// difficulty: easy
// runtime: 0ms, beats 100%
// memory: 90%
class Solution {
    public int fib(int n) {
        if (n<=1) return n;

        int t1=0;
        int t2=1;
        
        for (int i=2; i<=n; i++) {
            int t3=t1+t2;
            t1=t2;
            t2=t3;
        }
        
        return t2;
    }
}


// 25ms, using memoization
class Solution {
    public int fib(int n) {
        if (n<=1) return n;

        int[] m = new int[n+1];
        m[0]=0;
        m[1]=1;
        
        if (m[n-2]==0) {
            m[n-2]=fib(n-2);
        }

        if (m[n-1]==0)
            m[n-1]=fib(n-1);
        
        return m[n-1] + m[n-2];
    }
}
