// problem: 119. Pascal's Triangle II
// difficulty: easy
// runtime: 0ms, beats 100%
// memory: beats 50%
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> list = new ArrayList<>();

        if (rowIndex > 29) {
            list.add(getPascalRow(29));
            return generate(list, rowIndex, 29);
        }
        return getPascalRow(rowIndex);
    }

    public static List<Integer> getPascalRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        
        for (int i = 0; i <= rowIndex; i++) {
            row.add(nCr(rowIndex, i));
        }

        return row;
    }

    public static List<Integer> generate(List<List<Integer>> list, int numRows, int start) {

        for (int i = start + 1; i <= numRows; i++) {
            List<Integer> iList = new ArrayList<>();
            iList.add(1);

            for (int j = 1; j < i; j++) {
                int prev = list.get(i - start - 1).get(j - 1);
                int current = list.get(i - start - 1).get(j);
                iList.add(prev + current);
            }

            iList.add(1);
            list.add(iList);
        }

        return list.get(list.size()-1);
    }

    public static int nCr(int n, int r) {
        if (r==0 || n==r) {
            return 1;
        }

        int s=1;

        for (int i=0; i<r; i++) {
            s=s * (n-i) / (i+1);
        }
        
        return s;
    }
}
