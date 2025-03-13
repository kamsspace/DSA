# problem: 2529. Maximum Count of Positive Integer and Negative Integer
# difficulty: medium made easy with O(log(n)) complexity with binary search
# time: O(log(n))
# space: O(1)

class Solution:
    def maximumCount(self, nums: List[int]) -> int:
        N = len(nums)

        if nums[0] > 0 or nums[N-1] < 0:
            return N

        # n = negative
        # p = positive
        n, p = 0, 0

        # l = left index, starts at index 0
        # r = right index, starts at last index
        l, r = 0, N - 1

        # binary search
        # check the left and right bounds
        while l <= r:

            # find mid index
            m = (l + r) // 2

            # if found mid=0, now optimize left and right by decrementing and incrementing their indexes
            if nums[m] == 0:
                if nums[r] == 0 and nums[l] == 0:
                    z = r - l + 1
                    n = l
                    p = N - n - z
                    break
                else:
                    if nums[l] < 0:
                        l += 1
                    if nums[r] > 0:
                        r -= 1
            # if mid element is positive, reduce right index to index mid-1
            elif nums[m] > 0:
                r = m - 1
              
            # if mid element is negative, increase left to index mid+1
            else:
                l = m + 1

        # handling edge cases:
        # if left and right indexes are equal, find # of zeros, and find negative and positive
        if l == r:
            if nums[l] < 0:
                n = l + 1
            else:
                z = r - l + 1
                n = l
            p = N - n - z
        elif r < l:
            r += 1
            n = l
            p = N - n

        return max(n,p)

        # find mid index equals to 0, stop at 0s range (left and right), find negative and positives, handle edge cases: 0s count, left and right swaps

        # -20, -19, -18, -16, -15, -14, -13, -4, -3, -2, -1, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
