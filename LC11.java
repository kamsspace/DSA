// problem: 11. Container with Most Water
// difficulty: medium
// runtime: 1ms, beats 99%
// memory: 20%

class Solution {
    public static int maxArea(int[] height) {
        int left=0; 
        int right=height.length-1; 
        int mx=0;

        while (left<right) {
            int m=Math.min(height[left], height[right]);
            mx=Math.max(mx, m*(right-left));
            
            while (left<right && height[right]<=m) {
                right--;
            } 
            while (left<right && height[left]<=m) {
                left++;
            }
        }

        return mx;
    }
}


// runtime: 4ms, beats 90.59%
// memory: 51%
class Solution {
    public int maxArea(int[] height) {
        int left=0,right=height.length-1;
        int max=0;

        while (left<right) {
            int c=height[left],d=height[right];
            
            if (c>=d) {
                max=Math.max(blueSection(right-left,c,d),max);
                right--;
            } else {
                max=Math.max(blueSection(right-left,c,d),max);
                left++;
            }
        }

        return max;
    }
    
    public static int blueSection(int diff, int left,int right) {
        return diff*Math.min(left,right);
    }
}
