# problem: 1800. Maximum Ascending Subarray Sum
# difficulty: easy
# time: O(n)
# space: O(1)

class Solution:
    def maxAscendingSum(self, nums: List[int]) -> int:
        mx = nums[0]
        loc = nums[0]
        p = nums[0]
        N = len(nums)
        for i in range(1,N):
            if p < nums[i]:
                loc += nums[i]
            else:
                loc = nums[i]
            p = nums[i]
            mx = max(mx, loc)
        
        return mx
                
