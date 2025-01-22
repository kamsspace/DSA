# problem: 2017. Grid Game
# difficulty: medium
# time complexity: O(n)
# space complexity: O(1)
class Solution:
    def gridGame(self, grid: List[List[int]]) -> int:
        r = len(grid)
        c = len(grid[0])
        INF = 10 ** 20
        top_sum = sum(grid[0])
        btm_sum = sum(grid[1])
        
        mx = INF
        top = grid[0][0]
        btm = btm_sum

        score = max(top_sum - top, btm_sum - btm)
        mx = min(mx, score)

        for i in range(1,c):
            top += grid[0][i]
            btm -= grid[1][i-1]
            score = max(top_sum - top, btm_sum - btm)
            mx = min(mx, score)

        return mx
