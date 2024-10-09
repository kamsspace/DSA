// problem: 1047. Remove All Adjacent Duplicates of String
// difficulty: easy 
// runtime: 4ms, beats 99%
class Solution {
    public String removeDuplicates(String s) {
        int n=s.length();
        char[] stack = new char[n];
        int last = -1;

        for (char c : s.toCharArray()) {
            if (last != -1 && (c == stack[last])) {
                last--;
            } else stack[++last] = c;
        }

        // StringBuilder sb = new StringBuilder();
        
        // for (int i=0; i<last+1; i++) {
        //     sb.append(stack[i]);
        // }

        return new String(stack, 0, last+1);
    }
}


// 6ms, beats 94%
class Solution {
    public String removeDuplicates(String s) {
        int n=s.length();
        char[] stack = new char[n];
        int last = -1;

        for (char c : s.toCharArray()) {
            if (last != -1 && (c == stack[last])) {
                last--;
            } else stack[++last] = c;
        }

        StringBuilder sb = new StringBuilder();
        
        for (int i=0; i<last+1; i++) {
            sb.append(stack[i]);
        }

        return sb.toString();
    }
}
