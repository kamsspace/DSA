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
