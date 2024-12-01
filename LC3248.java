// problem: 3248. Snake in Matrix
// difficulty: easy
// time complexity: O(n)
// space complexity: O(1)

class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int i = 0;
        int j = 0;

        for (String s : commands) {
            switch (s.charAt(0)) {
                case 'R': j++; break;
                case 'L': j--; break;
                case 'D': i++; break;
                case 'U': i--; break;
            }
        }

        return (i * n) + j;
    }
}



// other versions
class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int i = 0;
        int j = 0;

        for (String s : commands) {
            if (s.equals("RIGHT")) {
                j++;
            } else if (s.equals("LEFT")) {
                j--;
            } else if (s.equals("DOWN")) {
                i++;
            } else {
                i--;
            }
        }

        return (i * n) + j;
    }
}


class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int i = 0;
        int j = 0;
        Map<String,Integer> map = new HashMap<>();

        for (String s : commands) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        j += map.getOrDefault("RIGHT", 0);
        j -= map.getOrDefault("LEFT", 0);
        i += map.getOrDefault("DOWN", 0);
        i -= map.getOrDefault("UP", 0);

        return (i * n) + j;
    }
}
