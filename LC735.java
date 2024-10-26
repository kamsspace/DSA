// problem: 735. Asteroid Collision
// difficulty: medium
// runtime: 1ms, beats 100%
// memory: 22%
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int[] ward = new int[asteroids.length];
        int last = -1;

        for (int i : asteroids) {
            if (i > 0) {
                ward[++last] = i;
            } else {
                if (last == -1) ward[++last] = i;
                else {
                    i = Math.abs(i);

                    while (last != -1) {
                        int peek = ward[last];

                        if (peek > 0) {
                            if (i > peek) {
                                last--;
                                                             
                                if (last == -1) {
                                    ward[++last] = -i;
                                    break;
                                }
                            } else if (i < peek) {
                                break;
                            } else if (i == peek) {
                                last--;
                                break;
                            } 
                        } else {
                            ward[++last] = -i;
                            break;
                        }
                    }
                }
            }
        }

        if (last == -1) return new int[0];

        int[] aste = new int[last+1];

        while (last > -1) {
            aste[last] = ward[last--];
        }

        return aste;
    }
}
