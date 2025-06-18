// LeetCode problem: 2966. Divide Array Into Arrays With Max Difference
// difficulty: medium
// time: O(N)
// space: O(N)
// counting sort with 100001 size array
class Solution {

    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        if (n < 3 || n % 3 != 0) {
            return new int[0][];
        }

        int[] c = new int[100001];

        for (int i : nums) {
            c[i]++;
        }

        int[][] a = new int[n/3][3];

        int j = 0, m = 0;
        for (int i = 1; i < 100001; i++) {
            while (c[i] > 0) {
                if (m != 0 && (i - a[j][0]) > k) {
                    return new int[0][];
                }
                a[j][m++] = i;
                c[i]--;
                if (m == 3) {
                    m = 0;
                    j++;
                    if (j == n/3) {
                        return a;
                    }
                }
            }
        }
        return a;
    }
}

// 2nd solution:
// time: O(NlogN)
// space: O(N)
// TreeMap (for handling sorting)
class Solution {

    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        if (n < 3 || n % 3 != 0) {
            return new int[0][];
        }

        Map<Integer,Integer> c = new TreeMap<>();

        for (int i : nums) {
            c.put(i, c.getOrDefault(i, 0) + 1);
        }

        int[][] a = new int[n/3][3];

        int j = 0, m = 0;
        for (int key : c.keySet()) {
            int val = c.get(key);
            while (val > 0) {
                if (m != 0 && (key - a[j][0]) > k) {
                    return new int[0][];
                }
                a[j][m++] = key;
                val--;
                if (m == 3) {
                    m = 0;
                    j++;
                    if (j == n/3) {
                        return a;
                    }
                }
            }
        }
        return a;
    }
}

// 3rd solution:
// time: O(NlogN)
// space: O(N)
// built-in sort for Arrays
class Solution {

    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        if (n < 3 || n % 3 != 0) {
            return new int[0][];
        }

        Arrays.sort(nums);

        int[][] a = new int[n/3][3];

        int m = 0;
        for (int i = 0; i < n/3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j != 0 && nums[m] - a[i][0] > k) {
                    return new int[0][];
                }
                a[i][j] = nums[m++];
            }
        }
        return a;
    }
}
