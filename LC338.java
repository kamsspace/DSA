// problem: 338. Counting Bits
// difficulty: easy
// runtime: 2ms & 3ms, beats 95%
class Solution {
    public int[] countBits(int n) {
        
        int[] c= new int[n+1];
        
        for (int i=0;i<c.length;i++) {
            c[i]=howManyOnes(i);
        }
        return c;
    }

    public static int howManyOnes(int n) {
        if (n==0) return 0;
        return (n&1)+howManyOnes(n >> 1);
    }
}


class Solution {
    public int[] countBits(int n) {
        int[] c= new int[n+1];
        for (int i=0;i<c.length;i++) {
            int j=i;
            while (j!=0) {
                j &= (j - 1);
                c[i]++;
            }
        }
        return c;
    }
}



class Solution {
    public int[] countBits(int n) {
        int[] c= new int[n+1];
        for (int i=0;i<c.length;i++) {
            int j=i;
            while (j!=0) {
                c[i] += (j & 1);
                j >>= 1;
            }
        }
        return c;
    }
}



class Solution {
    public int[] countBits(int n) {
        int[] c= new int[n+1];
        for (int i=0;i<=n;i++) c[i] = Integer.bitCount(i);
        return c;
    }
}
