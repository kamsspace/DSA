// LeetCode problem: 2410. Maximum Matching of Players With Trainers
// Difficulty: medium
// time: O(n)
// space: O(1)
class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int p = players.length;
        int t = trainers.length;

        if (players[p-1] <= trainers[0]) {
            return t > p ? p : t;
        }

        int i = p - 1;
        while (i > 0 && players[i] > trainers[t - 1]) {
            i--;
        }

        int j = 0;
        while (j < t && players[0] > trainers[j]) {
            j++;
        }

        int match = 0;
        int k = 0;
        while (k <= i && j < t) {
            if (players[k] <= trainers[j]) {
                match++;
                j++;
                k++;
            } else {
                j++;
            } 
        }

        return match;
    }
}
