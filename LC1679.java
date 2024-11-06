// problem: 1679. Max Number of K-Sum Pairs
// difficulty: medium
// runtime: 14ms, beats 97.17%
// memory: 40%

class Solution {
    public int maxOperations(int[] nums, int k) {
        int c=0;
        if (k > 5000000) {
            c=twoPointers(nums,k);
        } else {
            int[] ks=new int[k];
            int left=1,right=ks.length-1;

            for (int i:nums) {
                if (i<k) {
                    ks[i]++;
                }
            }

            while (left < right) {
                c += Math.min(ks[left++],ks[right--]);
            }

            if (left == right) {
                c = c + ks[left] / 2;
            }
        }

        return c;
    }

    public static int twoPointers(int[] nums, int k) {
        int c = 0;
        int zeros = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= k) {
                nums[i] = 0;
            }
        }
         
        Arrays.sort(nums);
        int left = zeros;
        int right = nums.length - 1;
        
        while(left < right) {
            int s=nums[left] + nums[right];
            
            if (s == k) {
                c++;
                left++;
                right--;
            } else if (s > k) {
                right--;
            } else {
                left++;
            }
        }

        return c;
    }
}




// runtime: 17ms, beats 94.95%
// memory: 61%
class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int c=0;
        int right=nums.length-1;
        int left=0;
        
        while (left<right) {
            int s=nums[left]+nums[right];
            
            if(s == k){
                c++;
                left++;
                right--;
            } else if (s > k) {
                right--;
            } else {
                left++;
            }
        }

        return c;
    }
}
