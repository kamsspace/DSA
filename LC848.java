// LeetCode problem: 848. Shifting Letters
// difficulty: medium
// time: O(n)
// space: O(n)

// StringBuilder version
class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        StringBuilder sb = new StringBuilder(s);
        int n = shifts.length - 1;
        long sh = 0;

        sb.setCharAt(n, (char)((sb.charAt(n) - 'a' + shifts[n]) % 26 + 'a'));
        sh += shifts[n];
        
        for (int i = n-1; i >= 0; i--) {
            sh += shifts[i];
            char updated = (char)((sb.charAt(i) - 'a' + sh) % 26 + 'a');
            sb.setCharAt(i, updated);
        }

        return sb.toString();
    }
}

// faster version with char array
class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        // StringBuilder sb = new StringBuilder(s);
        char[] chrs = s.toCharArray();
        int n = shifts.length - 1;
        long sh = 0;

        chrs[n] = (char)((chrs[n] - 'a' + shifts[n]) % 26 + 'a');
        sh += shifts[n];
        
        for (int i = n-1; i >= 0; i--) {
            sh += shifts[i];
            char updated = (char)((chrs[i] - 'a' + sh) % 26 + 'a');
            chrs[i] = updated;
        }

        // return sb.toString();
        return new String(chrs);
    }
}
