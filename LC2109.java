// problem: 2109. Adding Spaces to a String
// difficulty: medium
// time complexity: O(n)
// space complexity: O(n)

class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;

        for (i = 0; i < spaces.length; i++) {
            j = i == 0 ? 0 : spaces[i-1];
            sb.append(s,j,spaces[i]);
            sb.append(' ');
        }

        sb.append(s.substring(spaces[i-1]));
        return sb.toString();
    }
}


// version 1.0
class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int i=0;
        int j=0;

        for (i = 0; i < spaces.length; i++) {
            j = i == 0 ? 0 : spaces[i-1];

            for (; j < spaces[i]; j++) {
                sb.append(s.charAt(j));
                
            }

            sb.append(' ');
        }

        for (; j < s.length(); j++) {
            sb.append(s.charAt(j));
        }

        return sb.toString();
    }
}
