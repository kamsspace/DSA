# problem: 3223. Minimum Length of String After Operations
# difficulty: medium
# time: O(n)
# space: O(n)

class Solution:
    def minimumLength(self, s: str) -> int:
        map = collections.Counter(s)

        for key in map.keys():
            map[key] = map[key] % 2
            if map[key] == 0:
                map[key] = 2
            
        return sum(map.values())

# version 2.0
class Solution:
    def minimumLength(self, s: str) -> int:
        map = collections.Counter(s)

        for key in map.keys():
            while map[key] >= 3:
                map[key] -= 2
            
        return sum(map.values())
