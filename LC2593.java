// problem: 2593. Find Score of an Array After Marking All Elements
// difficulty: medium
// time complexity: O(nlogn)
// space complexity: O(n)

class Solution {
    public long findScore(int[] nums) {
        long score = 0;
        int n = nums.length;

        List<int[]> birds = new ArrayList<>();
        Set<Integer> wings = new HashSet<>();

        for (int i = 0; i < n; i++) {
            birds.add(new int[] {nums[i],i});
        }

        birds.sort((a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        for (int[] pair : birds) {
            int i = pair[1];
            int num = pair[0];

            if (wings.contains(i)) {
                continue;
            }
            
            score += num;
            wings.add(i);
            
            if (i > 0) {
                wings.add(i-1);
            }
            if (i < n - 1) {
                wings.add(i+1);
            }
        }

        return score;
    }
}



// original solution by some professional
class Solution {
    
    class Pair {
        int num;
        int idx;
        
        Pair(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }
    }
    
    public long findScore(int[] nums) {
        Pair[] arr = new Pair[nums.length];
        for(int i = 0; i < nums.length; i++) {
            arr[i] = new Pair(nums[i], i);
        }
        
        Arrays.sort(arr, new Comparator<Pair>() {
            public int compare(Pair p1, Pair p2) {
                if(p1.num == p2.num) {
                    return p1.idx - p2.idx;
                }else {
                    return p1.num - p2.num; 
                } 
            }
        });
        
        long score = 0;
        int[] vis = new int[nums.length];
        
        for(int i = 0; i < arr.length; i++) {
            int index = arr[i].idx;
            if(vis[index] == 0) {
                score += arr[i].num;
                vis[index] = 1;
                if(index - 1 >= 0) {
                    vis[index - 1] = 1;
                }
                if(index + 1 <= nums.length - 1) {
                    vis[index + 1] = 1;
                }
            }else {
                continue;
            }
        }
        
        return score;
    }
}
