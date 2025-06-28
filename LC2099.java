// LeetCode problem: 2099. Find Subsequence of Length K With the Largest Sum
// Difficulty: easy
// time: O(n log k)
// space: O(k)
class Pair implements Comparable<Pair> {
    int value;
    int index;
    Pair(int value, int index) {
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(Pair other) {
        return this.value - other.value;
    }
}
class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        if (nums.length == k) {
            return nums;
        }

        int[] mxsm = new int[k];
        PriorityQueue<Pair> valueHeap = new PriorityQueue<>();
        PriorityQueue<Pair> indexHeap = new PriorityQueue<>(
            Comparator.comparingInt(a -> a.index)
        );

        for (int i = 0; i < nums.length; i++) {
            if (valueHeap.size() < k) {
                valueHeap.offer(new Pair(nums[i], i));
            } else if (valueHeap.peek().value < nums[i]) {
                valueHeap.poll();
                valueHeap.offer(new Pair(nums[i], i));
            }
        }

        while (!valueHeap.isEmpty()) {
            indexHeap.offer(valueHeap.poll());
        }

        for (int i = 0; i < k; i++) {
            mxsm[i] = indexHeap.poll().value;
        }

        return mxsm;
    }
}
