// problem: 42. Trapping Rain Water
// difficulty: hard
// time complexity: O(n)
// space complexity: O(n)
// dsa: dynamic programming
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = height[0];
        right[n-1] = height[n-1];

        for (int i = 1, j = n-2; i < n; i++, j--) {
            left[i] = Math.max(left[i-1], height[i]);
            right[j] = Math.max(right[j+1], height[j]);
        }

        int[] water = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            water[i] = Math.min(left[i], right[i]) - height[i];
            if (i > 0) {
                sum += water[i-1];
            }
        }

        return sum + water[n-1];
    }
}


// version 2.0
// time complexity: O(n)
// space complexity: O(1)
// dsa: two pointers
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int left = 0, right = n-1;
        int maxL = 0, maxR = 0;
        int water = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                maxL = Math.max(maxL, height[left]);
                water += maxL - height[left];
                left++;
            } else {
                maxR = Math.max(maxR, height[right]);
                water += maxR - height[right];
                right--;
            }
        }

        return water;
    }
}
