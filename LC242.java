// problem: 242. Valid Anagram
// difficulty: easy

// runtime: 8ms, beats 35.26%
// memory: 45.10MB, beats 6.98%

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() == 1 && t.length() == 1) return t.equals(s);
        String a = sortString(s);
        String b = sortString(t);
        return a.equals(b);
    }
    static public String sortString(String s) {
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return Arrays.toString(c);
    }
}

// runtime: 3ms, beats 88%
// memory: 44.42MB, beats 41%

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        if (s.length() == 1 && t.length() == 1) return t.equals(s);
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);

        return new String(a).equals(new String(b));
    }
}
