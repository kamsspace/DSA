# problem: 49. Group Anagrams
# difficulty: medium
# time: O(NlogN)
# space: O(N)
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        a = collections.defaultdict(list)

        for s in strs:
            key = tuple(sorted(s))
            a[key].append(s)

        return list(a.values())


# version 2.0
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        a = collections.defaultdict(list)

        for s in strs:
            key = "".join(sorted(s))
            a[key].append(s)

        return list(a.values())
