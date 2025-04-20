// problem: 781. Rabbits in Forest
// difficulty: medium
// time: O(n)
// space: O(n)

class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        int minRabbits = 0;

        // for 0s -> i will count all of them
        // for 1 to INF -> i will count and divide (%) the count with n+1,
        // if there's a remainder, i will add n+1-remainder to the count.

        for (int i : answers) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (Integer key : map.keySet()) {
            int c = map.get(key);

            int r = c % (key + 1);
            if (r == 0) {
                minRabbits += c; 
            } else {
                minRabbits += c + key + 1 - r;
            }
        }

        // above rule works for 0 to INF, not necessarily they have separate condition

        return minRabbits;

    }
}
