# problem: 2559. Count Vowel Strings in Ranges
# difficulty: medium
# time: O(n)
# space: O(n)
class Solution:
    def vowelStrings(self, words: List[str], queries: List[List[int]]) -> List[int]:
        v = "aeiou"

        prefix = [0]
        for word in words:
            vowel = (word[0] in v and word[-1] in v)

            if vowel:
                prefix.append(prefix[-1] + 1)
            else:
                prefix.append(prefix[-1])

        res = []
        for l, r in queries:
            res.append(prefix[r+1] - prefix[l])
        return res
