# problem: 3066. Minimum Operations to Exceed Threshold Value II
# difficulty: medium
# time: O(NlogN)
# space: O(N)
class Solution:
    def minOperations(self, nums: List[int], k: int) -> int:
        heapq.heapify(nums)
        o = 0

        while nums[0] < k:
            f,s = heapq.heappop(nums),heapq.heappop(nums)
            heapq.heappush(nums,min(f,s) * 2+ max(f,s))
            o += 1
        return o
