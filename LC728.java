// problem: 728. Self Dividing Numbers
// difficulty: easy
// runtime: 1ms, beats 100%
// memory: 97%

class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> sdn = new ArrayList<>();
        
        for (int i=left;i<=right;i++) {
            if (sdnCheck(i)) sdn.add(i);
        }

        return sdn;
    }

    public static boolean sdnCheck(int i) {
        int x=i;

        while (x>0) {
            int a=x%10;

            if (a == 0 || i%a != 0) return false;

            x/=10;
        }

        return true;
    }
}
