// LeetCode problem: 3598. Longest Common Prefix Between Adjacent Strings After Removals
// Difficulty: medium
// time: O(n * max word length)
// space: O(n + max word length)

class Solution {
    public int[] longestCommonPrefix(String[] words) {
        int n = words.length;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int[] lcp = new int[n-1];
        int[] res = new int[n];

        for (int i = 0; i < n-1; i++) {
            lcp[i] = findPrefixLength(words[i], words[i+1]);
            map.put(lcp[i], map.getOrDefault(lcp[i], 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            if (i < n - 1) removePrefixCount(map, lcp[i]);
            if (i > 0) removePrefixCount(map, lcp[i - 1]);
            
            int newPrefix = 0;
            if (i > 0 && i < n - 1) {
                newPrefix = findPrefixLength(words[i - 1], words[i + 1]);
                map.put(newPrefix, map.getOrDefault(newPrefix, 0) + 1);
            }

            int mx = map.isEmpty() ? 0 : map.lastKey();
            res[i] = mx;

            if (i < n - 1) map.put(lcp[i], map.getOrDefault(lcp[i], 0) + 1);
            if (i > 0) map.put(lcp[i - 1], map.getOrDefault(lcp[i - 1], 0) + 1);
            if (i > 0 && i < n - 1) removePrefixCount(map, newPrefix);
        }

        return res;
    }

    public static void removePrefixCount(TreeMap<Integer,Integer> map, int k) {
        if (!map.containsKey(k)) return;
        if (map.get(k) == 1) map.remove(k);
        else map.put(k, map.get(k) - 1);
    }

    public static int findPrefixLength(String left, String right) {
        int mn = Math.min(left.length(), right.length());
        int i = 0;
        while (i < mn && left.charAt(i) == right.charAt(i)) {
            i++;
        }

        return i;
    }
}
