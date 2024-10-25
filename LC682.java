// problem: 682. Baseball Game
// difficulty: easy
// runtime: 1ms, beats 100%
// memory: 95%

class Solution {
    public int calPoints(String[] operations) {
        int[] _s = new int[operations.length];
        int last=-1;
        int f=0,s=0;
        String ops = "CD+";

        for (String c: operations) {
            if (ops.indexOf(c)==-1) {
                _s[++last] = Integer.parseInt(c);
                continue;
            } else if (c.contains("C")) {
                last--;
                continue;
            } else if (c.contains("D")) {
                f=_s[last];
                _s[++last] = 2*f;
                continue;
            } else {
                s=_s[last];
                f=_s[last-1];
                _s[++last]=f+s;
            }
        }

        if (last<0) return 0;
        else {
            while (last>0) {
                _s[0]+=_s[last--];
            }

            return _s[last];
        }
    }
}
