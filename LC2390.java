// problem: 2390. Removing Stars from a String
// difficulty: medium
// runtime: 9ms, beats 99.79%
// memory: 65%

class Solution {
    public String removeStars(String s) {
        char[] _stack=new char[s.length()];
        int last=-1;
        char star='*';

        for (char c:s.toCharArray()) {
            if (c==star) {
                last--;
            } else {
                _stack[++last]=c;
            }
        }

        return new String(_stack,0,last+1);
    }
}



// runtime: 12ms, beats 97.56%
// memory: 77%
class Solution {
    public String removeStars(String s) {
        char[] _stack=new char[s.length()];
        int last=-1;
        char star='*';

        for (char c:s.toCharArray()) {
            if (c==star) {
                last--;
            } else {
                _stack[++last]=c;
            }
        }

        return String.valueOf(_stack).substring(0,last+1);
    }
}
