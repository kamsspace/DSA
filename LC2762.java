// problem: 2762. Continuous Subarrays
// difficulty: medium

// VERSION 1.0
// time complexity: O(n^2)
// space complexity: O(n)

class Solution {
    public long continuousSubarrays(int[] nums) {
        int n = nums.length;
        long c = 0;

        if (n == 1) {
            return n;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> queue = new LinkedList<>();
        int i = 0, j = 0;

        while (j < n) {
            minHeap.offer(nums[j]);
            maxHeap.offer(nums[j]);
            queue.add(nums[j]);

            while (maxHeap.peek() - minHeap.peek() > 2) {
                int firstOnQueue = queue.poll();
                minHeap.remove(firstOnQueue);
                maxHeap.remove(firstOnQueue);
                i++;
            } 
            
            c += (j - i + 1);
            j++;
        }

        return c;
    }
}


// VERSION 2.0
// time complexity: O(nlogn)
// space complexity: O(n)
// this solution removes the heap remove operation
class Solution {
    public long continuousSubarrays(int[] nums) {
        int n = nums.length;
        long c = 0;

        if (n == 1) {
            return n;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Integer> queue = new LinkedList<>();
        int i = 0, j = 0;

        while (j < n) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            queue.add(nums[j]);

            while (map.lastKey() - map.firstKey() > 2) {
                int firstOnQueue = queue.poll();
                map.put(firstOnQueue, map.get(firstOnQueue) - 1);
                if (map.get(firstOnQueue) == 0) {
                    map.remove(firstOnQueue);
                }
                i++;
            }
            
            c += (j - i + 1);
            j++;
        }

        return c;
    }
}



// VERSION 3.0
// time complexity: O(n^2)
// space complexity: O(1)
// nested for loop inside the while loop for recalculating the min and max values for each subarray is taking a lot of time
class Solution {
    public long continuousSubarrays(int[] nums) {
        int n = nums.length;
        long c = 0;

        if (n == 1) {
            return n;
        }

        int i = 0, j = 0;
        int mn = nums[0], mx = nums[0];

        while (j < n) {
            mn = Math.min(mn, nums[j]);
            mx = Math.max(mx, nums[j]);

            while (mx - mn > 2) {
                i++;
                mn = mx = nums[i];

                for (int k = i; k <= j; k++) {
                    mn = Math.min(mn, nums[k]);
                    mx = Math.max(mx, nums[k]);
                }
            }
            
            c += (j - i + 1);
            j++;
        }

        return c;
    }
}



// VERSION 4.0
// time complexity: O(n^2)
// space complexity: O(1)
// inner while loop takes longer time actually
class Solution {
    public long continuousSubarrays(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return n;
        }

        long c = 0;
        int i = 0, j = 0;
        int mn = nums[0], mx = nums[0];

        while (j < n) {
            mn = Math.min(mn, nums[j]);
            mx = Math.max(mx, nums[j]);

            if (mx - mn > 2) {

                long windowLen = j - i;
                c += (windowLen * (windowLen + 1)) / 2;
                i = j;
                mn = mx = nums[i];

                while (i > 0 && Math.abs(nums[j] - nums[i - 1]) <= 2) {
                    i--;
                    mn = Math.min(mn, nums[i]);
                    mx = Math.max(mx, nums[i]);
                }

                if (i < j) {
                    windowLen = j - i;
                    c -= (windowLen * (windowLen + 1)) / 2;
                }
            }
            
            j++;
        }

        long windowLen = j - i;
        c += (windowLen * (windowLen + 1)) / 2;

        return c;
    }
}
