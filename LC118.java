// problem: 118. Pascal's Triangle
// difficulty: easy
// runtime: 1ms, beats 83%
// memory: 41.86MB, beats 62.99%
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();

        for (int i=1; i<numRows+1; i++) {
            List<Integer> iList = new ArrayList<>();
            int prev=-1, temp=-1;

            for (int j=0, l=0; j<i; j++) {
                if (i < 3) iList.add(1);
                else {
                    if (j == 0 || j == i-1) iList.add(1);
                    else {
                        if (prev == -1) {
                            prev = list.get(i-2).get(l++);
                        }

                        int k = list.get(i-2).get(l++);
                        iList.add(prev+k);
                        prev=k;
                        
                    }
                }
            }

            list.add(iList);
        }

        return list;
    }
}


// 0ms, beats 100%
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();

        List<Integer> one = new ArrayList<>();
        one.add(1);
        list.add(one);

        for (int i=1; i<numRows; i++) {
            list.add(getPascalRow(i));
        }

        return list;
    }

    public static List<Integer> getPascalRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            row.add(nCr(rowIndex, i));
        }
        return row;
    }

    public static int nCr(int n, int r) {
        if (r==0 || n==r) {
            return 1;
        }
        
        // int[] A=new int[2*n];
        // if (A[n]==0) A[n]=fact(n);
        // if (A[r]==0) A[r]=fact(r);
        // if (A[n-r]==0) A[n-r]=fact(n-r);
        int s=1;

        for (int i=0; i<r; i++) {
            s=s * (n-i) / (i+1);
        }
        
        return s;
        // return A[n]/A[n-r]*A[r];
    }

    // public static int fact(int n) {
    //     if (n<=1) return 1;
        
    //     int s=1;

    //     for (int i=2; i<=n; i++) {
    //         s*=i;
    //     }

    //     return s;
    // }
}
