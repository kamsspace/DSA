# problem: 2661. First Completely Painted Row or Column
# difficulty: medium
# time complexity: O(m x n)
# space complexity: O(m x n)
class Solution:
    def firstCompleteIndex(self, arr: List[int], mat: List[List[int]]) -> int:
        R = len(mat)
        C = len(mat[0])

        map = {}

        for i in range(R):
            for j in range(C):
                map[mat[i][j]] = (i, j)
        
        count_row = [0] * R
        count_col = [0] * C

        for x,v in enumerate(arr):
            i,j = map[v]
            count_row[i] += 1
            count_col[j] += 1

            if count_row[i] == C or count_col[j] == R:
                return x 
        else:
            assert(False)
