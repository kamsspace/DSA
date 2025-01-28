# problem: 3324. Find the Sequence of Strings Appeared on the Screen
# difficulty: medium
# time: O(n)
# space: O(n^2)
class Solution:
    def stringSequence(self, target: str) -> List[str]:
        N = len(target)

        words = ["a"]
        while words[-1][-1] < target[0]:
            words.append(words[-1][:-1] + chr(ord(words[-1][-1]) + 1))

        for i in range(1,N):
            words.append(words[-1] + 'a')
            while words[-1][-1] < target[i]:
                words.append(words[-1][:-1] + chr(ord(words[-1][-1]) + 1))
        return words
