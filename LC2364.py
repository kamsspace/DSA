# problem: 2364. Count Number of Bad Pairs
# difficulty: medium
# time: O(n)
# space: O(n)

class Solution:
    def countBadPairs(self, nums: List[int]) -> int:
        N = len(nums)
        
        if N == 1:
            return 0

        c = collections.Counter()
        c[nums[0]] += 1
        bp = 0

        for i in range(1,N):
            k = nums[i] - i
            bp += i - c[k]
            c[k] += 1
        return bp

# version 2.0
class Solution:
    def countBadPairs(self, nums: List[int]) -> int:
        N = len(nums)
        
        if N == 1:
            return 0

        c = collections.Counter()
        # c[nums[0]] += 1
        bp = 0

        for i,k in enumerate(nums):
            # k = nums[i] - i
            bp += i - c[k-i]
            c[k-i] += 1
        return bp
