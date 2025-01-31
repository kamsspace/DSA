# problem: 3175. Find The First Player to win K Games in a Row
# difficulty: medium
# time: O(n)
# space: O(n)
class Solution:
    def findWinningPlayer(self, skills: List[int], k: int) -> int:
        N = len(skills)
        if k >= N:
            return skills.index(max(skills))
        
        q = collections.deque([[v,i,0] for i, v in enumerate(skills)])

        w = 0

        while True:
            if q[0][0] < q[1][0]:
                q.append(q.popleft())
            else:
                h = q.popleft()
                q.append(q.popleft())
                q.appendleft(h)
            q[0][2] += 1
            if q[0][2] == k:
                w = q[0][1]
                break
        
        return w
        
