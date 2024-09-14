// problem 521. Student Attendance Record I
// difficulty: easy
// runtime: 0ms, beats 100%
// memory: 41.43MB, beats 52.25%
class Solution {
    public boolean checkRecord(String s) {
        if (s.length() == 1) return true;

        int a = 0, count = 0;
        
        for (char c : s.toCharArray()) {
            if (c == 'A') {
                a++;
                count = 0;
                if (a > 1) return false;
            } else if (c == 'P') {
                count = 0;
            } else if (c == 'L') {
                count++;
            } 
            if (count >= 3) return false;
        }

        return true;
    }
}
