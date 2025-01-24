# problem: 1441. Build an Array with Stack Operations
# difficulty: medium
# time: O(n*k)
# space: O(n)
class Solution:
    def buildArray(self, target: List[int], n: int) -> List[str]:
        stack = []
        mx = target[-1]

        for i in range(1,n+1):
            if i <= mx:
                if i in target:
                    stack.append("Push")
                else:
                    stack.append("Push")
                    stack.append("Pop")
        
        return stack
