// problem: 2215. Find the Difference of Two Arrays
// difficulty: easy
// runtime: 4ms, beats 99.32%
// memory: 74%

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        int[] map=new int[2001];
        List<List<Integer>> list=new ArrayList<>();

        for (int i:nums2) {
            if (map[i+1000]==0) {
                map[i+1000]++;
            }
        }

        for (int i:nums1) {    
            if(map[i+1000]>0) {
                map[i+1000]++;
            } else if(map[i+1000]==0) {
                map[i+1000]--;
            } 
        }

        List<Integer> n1=new ArrayList<>();
        List<Integer> n2=new ArrayList<>();

        for (int i=0;i<map.length;i++) {
            if (map[i]==0) continue;
            if (map[i]==-1) {
                n1.add(i-1000);
            } else if (map[i]==1) {
                n2.add(i-1000);
            }
        }

        list.add(n1);
        list.add(n2);

        return list;
    }
}
