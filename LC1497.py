# problem: Check If Array Pairs Are Divisible by K
# difficulty: medium
# time: O(n)
# space: O(k)
class Solution:
    def canArrange(self, arr: List[int], k: int) -> bool:
        N = len(arr)
        if N == 1:
            return False
        
        for i in range(N):
            arr[i] = ((arr[i] % k) + k) % k
        
        r = collections.Counter(arr)
        for i in r.keys():
            if i == k - i or i == 0:
                if r[i] % 2 == 1:
                    return False
            elif r[i] != r[k-i]:
                return False

        return True
