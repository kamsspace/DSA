# problem: 2211. Count the Collisions
# difficulty: medium
# time complexity: O(n)
# space complexity: O(n)

class Solution:
    def countCollisions(self, directions: str) -> int:
        directions = directions.lstrip('L').rstrip('R')
        stack = []
        collisions = 0

        for d in directions:
            if d == 'L':
                if stack and stack[-1] == 'R':
                    collisions += 2
                    stack.pop()
                    while stack and stack[-1] == 'R':
                        collisions += 1
                        stack.pop()
                    stack.append('S')
                    stack.append('S')
                elif stack and stack[-1] == 'S':
                    collisions += 1
                    stack.append('S')
                else: 
                    continue
            elif d == 'R':
                stack.append('R')
            elif d == 'S':
                while stack and stack[-1] == 'R':
                    collisions += 1
                    stack.pop()
                stack.append('S')

        return collisions

# version 2.0
class Solution:
    def countCollisions(self, directions: str) -> int:
        # directions = directions.lstrip('L').rstrip('R')
        stack = []
        collisions = 0

        for d in directions:
            if d == 'L':
                if stack and stack[-1] == 'R':
                    collisions += 2
                    stack.pop()
                    while stack and stack[-1] == 'R':
                        collisions += 1
                        stack.pop()
                    stack.append('S')
                    stack.append('S')
                elif stack and stack[-1] == 'S':
                    collisions += 1
                    stack.append('S')
                else: 
                    continue
            elif d == 'R':
                stack.append('R')
            elif d == 'S':
                while stack and stack[-1] == 'R':
                    collisions += 1
                    stack.pop()
                stack.append('S')

        return collisions

# version 3.0
class Solution:
    def countCollisions(self, directions: str) -> int:
        directions = directions.lstrip('L').rstrip('R')
        collisions = 0

        for d in directions:
            if d != 'S':
                collisions += 1
        return collisions

# version 4.0
class Solution:
    def countCollisions(self, directions: str) -> int:
        directions = directions.lstrip('L').rstrip('R')
        return len(directions) - directions.count('S')
