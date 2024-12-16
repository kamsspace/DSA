// problem: 3264. Final Array State After K Multiplication Operations I
// difficulty: easy
// time complexity: O((n+k) logn)
// space complexity: O(n)
// data structure used: Heap (Priority Queue), Pair class automatically overrides compareTo method of Interface Comparable

class Pair implements Comparable<Pair> {
    int value;
    int index;

    public Pair(int value, int index) {
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(Pair other) {
        if (this.value == other.value) {
            return Integer.compare(this.index, other.index);
        }
        return Integer.compare(this.value, other.value);
    }
}

class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            minHeap.add(new Pair(nums[i],i));
        }

        for (int i = 0; i < k; i++) {
            Pair p = minHeap.poll();
            p.value *= multiplier;
            nums[p.index] = p.value;
            minHeap.add(p);
        }

        return nums;
    }
}
