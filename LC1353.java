// LeetCode problem: 1353. Maximum Number of Events That Can Be Attended
// Difficulty: medium
// time: O(nlogn)
// space: O(n)
class Solution {
    public int maxEvents(int[][] events) {
        PriorityQueue<int[]> startHeap = new PriorityQueue<>((a,b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0],b[0]);
            return Integer.compare(a[1],b[1]);
        });

        PriorityQueue<Integer> endHeap = new PriorityQueue<>();

        for (int[] e : events) {
            startHeap.offer(e);
        }

        int attended = 0, day = startHeap.peek()[0];
        int lastDay = 0;
        for (int[] e: events) {
            lastDay = Math.max(lastDay, e[1]);
        }

        while (day <= lastDay) {
            while (!startHeap.isEmpty() && startHeap.peek()[0] == day) {
                endHeap.offer(startHeap.poll()[1]);
            }
            while (!endHeap.isEmpty() && endHeap.peek() < day) {
                endHeap.poll();
            }

            if (!endHeap.isEmpty()) {
                endHeap.poll();
                attended++;
            }
            
            day++;
        }

        return attended;
    }
}
