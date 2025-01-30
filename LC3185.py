# problem: 3185. Count Days that Form a Complete Day II
# difficulty: medium
# time: O(n)
# space: O(1)
class Solution:
    def countCompleteDayPairs(self, hours: List[int]) -> int:
      '''
      STEPS:
      1. do % on each number in hours
      2. count all the previous complements of the current remainder in the map
      3. add +1 to the current remainder index in the map
      '''
        N = len(hours)
        if N == 1:
            return 0

        r = [0] * 24
        r[hours[0] % 24] += 1
        c = 0
        for i in range(1, N):
            rem = hours[i] % 24
            c += r[(24-rem) % 24]
            r[rem] += 1

        return c
