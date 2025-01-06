// problem: 1769. Minimum Number of Operations to Move All Balls to Each Box
// difficulty: medium
// time complexity: O(n)
// space complexity: O(n);
class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int moves = 0;
        int balls = 0;
        // int right = 0;
        // int rightBalls = 0;
        char[] ch = boxes.toCharArray();

        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            answer[i] = moves;

            if (ch[i] == '1') {
                balls++;
            }

            moves += balls;
        }

        moves = 0;
        balls = 0;

        for (int i = n-1; i >= 0; i--) {
            answer[i] += moves;

            if (ch[i] == '1') {
                balls++;
            }

            moves += balls;
        }

        return answer;
    }
}
