// problem: 2956. Find Common Elements between Arrays
// difficulty: easy
// time complexity: O(n)
// space complexity: O(n)

class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        boolean[] n1 = new boolean[101];
        boolean[] n2 = new boolean[101];
        int c1 = 0, c2 = 0;

        for (int i : nums1) {
            n1[i] = true;
        }
        for (int i : nums2) {
            n2[i] = true;
        }

        for (int i : nums1) {
            if (n2[i]) {
                c1++;
            }
        }

        for (int i : nums2) {
            if (n1[i]) {
                c2++;
            }
        }

        return new int[] {c1,c2};
    }
}


class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        int[] n1 = new int[101];
        int[] n2 = new int[101];
        int c = 0;

        for (int i : nums1) {
            n1[i]++;
        }
        for (int i : nums2) {
            n2[i]++;

            if (n1[i] > 0) {
                c++;
            }
        }

        int[] total = new int[] {0,c};
        c = 0;

        for (int i : nums1) {
            if (n2[i] > 0) {
                c++;
            }
        }

        total[0] = c;

        return total;
    }
}
