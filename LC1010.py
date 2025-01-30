# problem: 1010. Pairs of Songs With Total Durations Divisible by 60
# difficulty: medium
# time: O(n)
# space: O(1)
class Solution:
    def numPairsDivisibleBy60(self, time: List[int]) -> int:
        N = len(time)
        if N == 1:
            return 0
        
        s = [0] * 60
        s[time[0] % 60] += 1
        c = 0
        for i in range(1,N):
            r = time[i] % 60
            c += s[(60-r) % 60]
            s[r] += 1
        return c
