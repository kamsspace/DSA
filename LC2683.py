# problem: 2683. Neighboring Bitwise XOR
# difficulty: medium
# time complexity: O(n)
# space complexity: O(1)
class Solution:
    def doesValidArrayExist(self, derived: List[int]) -> bool:
        return sum(derived) % 2 == 0

# solution 1.0
class Solution:
    def doesValidArrayExist(self, derived: List[int]) -> bool:
        x = 0
        for i in derived:
            x ^= i
        return x == 0
