// problem: sort an array
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
