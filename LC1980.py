# problem: 1980. Find Unique Binary String
# difficulty: medium
# time: O((2^N) x N)
# space: O(N)


class Solution:
    def findDifferentBinaryString(self, nums: List[str]) -> str:
        N = len(nums)
        s = set()

        for i in nums:
            s.add(int(i,2))

        for i in range(pow(2,N)):
            if i not in s:
                u = bin(i)[2:]
                while len(u) < N:
                    u = "0" + u
                return u
