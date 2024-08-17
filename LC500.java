// problem: 500. Keyboard Row
// difficulty: easy
// time: 30 minutes
// runtime: 0ms, beats 100%
// memory: 41.07MB, beats 93.67%

class Solution {
    public String[] findWords(String[] words) {

        String top = "qwertyuiop", mid = "asdfghjkl", btm = "zxcvbnm";
        List<String> list = new ArrayList<>();

        for (String s : words) {
            String row;

            String low = s.toLowerCase();

            if (top.indexOf(low.charAt(0)) != -1) row = top;
            else if (mid.indexOf(low.charAt(0)) != -1) row = mid;
            else row = btm;
            
            if (consistOf(low, row)) list.add(s); 
        }

        String[] s = list.toArray(new String[list.size()]);
        return s;
    }

    public boolean consistOf(String s, String r) {
        for (int i = 0; i < s.length(); i++) {
            if (r.indexOf(s.charAt(i)) == -1) return false;
        }

        return true;
    }
}
