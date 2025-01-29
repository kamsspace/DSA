# problem: 3170. Lexicographically Minimum String After Removing Stars
# difficulty: medium
# time: O(N logN)
# space: O(n)

""" 
- you need to be aware of using the logic of min_heap for the letters
- the logic of max_heap for their indexes while pushing the elements into the heap
- then, sort the heap based on letters' indexes in descending order
"""
class Solution:
    def clearStars(self, s: str) -> str:
        # N = len(s)
        heap = []

        if '*' not in s:
            return s
        
        for i, ch in enumerate(s):
            if ch == '*':
                c, j = heapq.heappop(heap)
            else:
                heapq.heappush(heap,(ch,-i))
        heap.sort(key=lambda x: -x[1])
        return ''.join(x[0] for x in heap)
