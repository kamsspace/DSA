# problem: 3151. Special Array I
# difficulty: easy
# time: O(n)
# space: O(1)
# version 1.0:
class Solution:
    def isArraySpecial(self, nums: List[int]) -> bool:
        N = len(nums)
        for i in range(N-1):
            if nums[i] % 2 == 0 and nums[i+1] % 2 == 0:
                return False
            if nums[i] % 2 == 1 and nums[i+1] % 2 == 1:
                return False
        return True

#version 2.0:
class Solution:
    def isArraySpecial(self, nums: List[int]) -> bool:
        N = len(nums)
        if N == 1:
            return True
        for i in range(N-1):
            if (nums[i] % 2) == (nums[i+1] % 2):
                return False
        return True
