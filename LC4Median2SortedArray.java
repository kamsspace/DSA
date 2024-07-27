// difficulty: hard
// problem: 4. Median of Two Sorted Arrays

// runtime: 2ms, beats 63.30%
// memory: 46.32MB, beats 8.88%

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] res = new int[m+n];

        int i = 0, j = 0;
        int k = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                res[k] = nums1[i];
                i++;
            } else {
                res[k] = nums2[j];
                j++;
            }
            k++;
        }

        while (i < m) {
            res[k] = nums1[i];
            i++;
            k++;
        }

        while (j < n) {
            res[k] = nums2[j];
            j++;
            k++;
        }

        double median;
        int mid = (m+n) / 2;

        if ((m + n) % 2 == 0) {
            median = (double) (res[mid-1] + res[mid]) / 2;
        } else median = res[mid];

        return median; 
    }
}
