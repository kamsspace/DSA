# problem: 636. Exclusive Time of Functions
# difficulty: medium
# time complexity: O(n)
# space complexity: O(n)
class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        exclusive_time = [0] * n
        stack = []
        start_time = 0

        for log in logs:
            id, status, time = log.split(":")
            id = int(id)
            time = int(time)

            if status == "start":
                if stack:
                    exclusive_time[stack[-1]] += time - start_time
                
                stack.append(id)
                start_time = time
            else:
                exclusive_time[stack.pop()] += time - start_time + 1
                start_time = time + 1
        
        return exclusive_time
