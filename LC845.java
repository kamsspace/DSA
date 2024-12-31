// problem: 845. Longest Mountain in Array
// difficulty: medium
// time complexity: O(n)
// space complexity: O(1)

class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;

        if (arr.length < 3) {
            return 0;
        }

        // int c = 1, d = 0;
        int mx = 0;
        // int j = 0;

        int i = 0;
        
        while (i < n - 1) {
            int c = 1, d = 0;

            while (i < n - 1 && arr[i] >= arr[i+1]) {
                i++;
            } 
            while (i < n - 1 && arr[i] < arr[i+1]) {
                c++;
                i++;
                // System.out.println("c=" + c + " i=" + i);
            }
            while (i < n - 1 && arr[i] > arr[i+1]) {
                d++;
                i++;
                // System.out.println("d=" + d + " i=" + i);
            }

            // System.out.println("i=" + i + " c=" + c + " d=" + d + " mx=" + mx);
            

            if (c > 1 && d > 0) {
                mx = Math.max(mx,c + d);
            } 
            
            while (i < n - 1 && arr[i] == arr[i + 1]) {
                i++;
            }
            
            // i++;
        }

        return mx;
    }
}
