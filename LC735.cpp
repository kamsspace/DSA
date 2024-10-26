// problem: 735. Asteroid Collision
// difficulty: medium
// runtime: 0ms, beats 100%
// memory: 76%

class Solution {
public:
    vector<int> asteroidCollision(vector<int>& asteroids) {
        vector<int> arr(asteroids.size());
        int last=-1;

        for (int i : asteroids) {
            if (i > 0) {
                arr[++last] = i;
            } else {
                if (last == -1) arr[++last] = i;
                else {
                    i = abs(i);

                    while (last != -1) {
                        int top = arr[last];

                        if (top > 0) {
                            if (i > top) {
                                last--;

                                if (last == -1) {
                                    arr[++last] = -i;
                                    break;
                                }
                            } else if (i < top) {
                                break;
                            } else {
                                last--;
                                break;
                            }
                        } else {
                            arr[++last] = -i;
                            break;
                        }
                    }
                }
            }
        }

        if (last == -1) return vector<int>();
        
        arr.resize(last+1);
        return arr;
    }
};
