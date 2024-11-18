// problem: 1652. Defuse the Bomb.
// difficulty: easy
// runtime: 0ms, beats 100%
// memory: 8%
class Solution {
    public int[] decrypt(int[] code, int k) {
        if (k == 0) return new int[code.length];

        int n = code.length;
        boolean isNeg = k < 0 ? true : false;
        k = Math.abs(k);
        int[] defuse = new int[n];
        int kSum = 0;

        for (int i=0;i<k;i++) {
            kSum += code[i];
        }

        if (isNeg) {
            defuse[k] = kSum;

            for (int i=0,j=k,m=k+1;j<n+k;i++,j++,m++) {
                if (j>=n) {
                    kSum = kSum + code[j-n] - code[i];
                } else {
                    kSum = kSum + code[j] - code[i];
                }
                if (m>=n) {
                    m -= n;
                }
                
                defuse[m] = kSum;
            }
        } else {
            defuse[n-1] = kSum;

            for (int i=n+k-1,j=n-1,m=n-2;m>=0;i--,j--,m--) {
                if (i>=n) {
                    kSum = kSum + code[j] - code[i-n];
                } else {
                    kSum = kSum + code[j] - code[i];
                }
                
                defuse[m] = kSum;
            }
        }

        return defuse;
    }
}
