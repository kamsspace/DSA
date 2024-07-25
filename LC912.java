// problem: sort an array

// 1.
// runtime: 38ms, beats 31.01%
// memory: 55.61MB, beats 67.65%
class Solution {
    public static void heapSort(int[] check) {
        int len = check.length;

        for (int i = len / 2 - 1; i >= 0; i--) heap(check, len, i);

        for (int i = len - 1; i > 0; i--) {
            int temp = check[0];
            check[0] = check[i];
            check[i] = temp;

            heap(check, i, 0);
        }
    }
    public static void heap(int[] check, int len, int i) {
        int max = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < len && check[left] > check[max]) max = left;

        if (right < len && check[right] > check[max]) max = right;

        if (max != i) {
            int swap = check[i];
            check[i] = check[max];
            check[max] = swap;
            heap(check, len, max);
        }
    }
    public int[] sortArray(int[] nums) {
        heapSort(nums);
        return nums;
    }
}

// 2.
// runtime: 26ms, beats 65.17%
// memory: 56.05MB, beats 53.26%
class Solution {
    public static void mergeSort(int[] check, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(check, l, m);
            mergeSort(check, m + 1, r);
            merge(check, l, m, r);
        }
    }
    public static void merge(int[] check, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] L = new int[n1];
        int[] R = new int[n2];
        System.arraycopy(check, l, L, 0, n1);
        System.arraycopy(check, m + 1, R, 0, n2);

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                check[k] = L[i];
                i++;
            } else {
                check[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            check[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            check[k] = R[j];
            j++;
            k++;
        }
    }
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }
}
