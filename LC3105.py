# problem: 3105. Longest Strictly Increasing or Strictly Decreasing Subarray
# difficulty: easy
# time: O(n)
# space: O(1)
class Solution:
    def longestMonotonicSubarray(self, nums: List[int]) -> int:
        o = 1
        loc = 1
        o2 = 1
        loc2 = 1

        p = nums[0]
        p2 = nums[0]
        for i in nums:
            if i > p:
                loc += 1
                o = max(o,loc)
            else:
                o = max(o,loc)
                loc = 1
            if i < p2:
                loc2 += 1
                o2 = max(o2,loc2)
            else:
                o2 = max(o2,loc2)
                loc2 = 1
            p2 = i
            p = i

        if o > o2:
            return o
        else:
            return o2
        
