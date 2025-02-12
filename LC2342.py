# problem: 2342. Max Sum of a Pair With Equal Sum of Digits
# difficulty: medium
# time: O(n)
# space: O(1)

class Solution:
    def maximumSum(self, nums: List[int]) -> int:
        mx = -1
        c = {}
        for i in nums:
            n = 0
            j = i
            while i > 0:
                n += i % 10
                i //= 10
            if n in c:
                mx = max(mx, c[n] + j)
                c[n] = max(c[n],j)
                print(mx)
            else:
                c[n] = j
        return mx
