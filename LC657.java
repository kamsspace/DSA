// problem: 657. Robot Return to Origin
// difficulty: easy
// runtime: 2ms, beats 100%
// memory: 44.56MB, beats 34.38%

class Solution {
    public boolean judgeCircle(String moves) {
        int[] origin = new int[87];

        for (char c : moves.toCharArray()) {
            origin[c]++;
        }

        if (origin[85] == origin[68] && origin[82] == origin[76]) return true;
        else return false;
    }
}


// runtime: 3ms, beats 98.27%
// memory: 44.38MB, beats 66.54%
class Solution {
    public boolean judgeCircle(String moves) {
        int[] origin = new int[87];

        for (char c : moves.toCharArray()) {
            origin[c]++;
        }

        if (origin['U'] == origin['D'] && origin['R'] == origin['L']) return true;
        else return false;
    }
}



// runtime: 5ms, beats 62.92%
// memory: 8.56%
class Solution {
    public boolean judgeCircle(String moves) {
        if (moves.length() == 1) return false;

        int[] origin = new int[2];

        for (char c: moves.toCharArray()) {
            if (c == 'U') origin[0]++;
            else if (c == 'D') origin[0]--;
            else if (c == 'R') origin[1]++;
            else if (c == 'L') origin[1]--;
        }

        if (origin[0] == 0 && origin[1] == 0) return true;
        else return false;
    }
}
