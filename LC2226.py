# problem: 2226. Maximum Candies Allocated to K Children
# difficulty: medium
# time: O(n log(n))
# space: O(1)

class Solution:
    def maximumCandies(self, candies: List[int], k: int) -> int:
        left, right = 1, max(candies)
        mxc = 0

        while left <= right:
            mid = left + (right - left) // 2
            c = 0
            for i in candies:
                c += i // mid
            
            if c >= k:
                mxc = mid
                left = mid + 1
            else:
                right = mid - 1

        return mxc
