// problem: 1910. Remove All Occurrences of a Substring
// difficulty: medium
// time complexity: O(n^2)
// space complexity: O(n)

class Solution {
    public String removeOccurrences(String s, String part) {
        int n = s.length();
        int m = part.length();
        if (n < m) {
            return s;
        }

        int i = s.indexOf(part);

        while (i > -1) {
            s = s.substring(0, i) + s.substring(i + m);
            i = s.indexOf(part);
        }

        return s;
    }
}


// new version will come soon: using stack
...
