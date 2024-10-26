// problem: 739. Daily Temperatures
// difficulty: medium
// runtime: 7ms, beats 97.66%
// memory: 46%
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] _s = new int[n];
        int[] index = new int[101];
        int[] answer = new int[n];
        int last = -1;

        for (int i=n-1;i>=0;i--) {
            int c=temperatures[i];

            while (last != -1 && _s[last] <= c) {
                last--;
            }

            index[c]=i;
            if (last == -1) answer[i] = 0; 
            else answer[i] = index[_s[last]]-i;
            _s[++last] = c;
        }

        return answer;
    }
}
