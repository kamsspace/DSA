// runtime: 5ms | beats 92.65%
// memory: 42.04MB | beats 61.87%
// difficulty: medium 

class Solution {
    public String reverseWords(String s) {
        String[] a = s.replaceAll("\\s+", ",").split(",");
        StringBuilder w = new StringBuilder();
        for (int i = a.length-1; i >= 0; i--) {
            if (!w.isEmpty() && !a[i].isEmpty()) w.append(" ");
            w.append(a[i]);
        }
        return w.toString();
    }
}
