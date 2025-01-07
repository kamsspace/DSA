// problem: 3412. Find Mirror Score of a String
// difficulty: medium
// time complexity: O(n)
// space complexity: O(n)
// dsa: HashMap and Stack
class Solution {
    public long calculateScore(String s) {
        int n = s.length();
        if (n == 1) return 0;
        char[] rev = "zyxwvutsrqponmlkjihgfedcba".toCharArray();
        Map<Character, Stack<Integer>> map = new HashMap<>();
        long score = 0;
        
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (map.containsKey(ch) && !map.get(ch).isEmpty()) {
                score += i - map.get(ch).pop();
            } else {
                char c = rev[(int)(ch - 'a')];
                map.computeIfAbsent(c, k -> new Stack<>()).push(i);
            }
        }

        return score;
    }
}


// version 2.0
// precompute with static field to avoid rev[(int)(ch - 'a')];
class Solution {
    private static final Map<Character,Character> mirror = new HashMap<>();
    static {
        for (char c = 'a'; c <= 'z'; c++) {
            mirror.put(c, (char)('a'+ 'z' - c));
        }
    }

    public long calculateScore(String s) {
        int n = s.length();
        if (n == 1) return 0;
        // char[] rev = "zyxwvutsrqponmlkjihgfedcba".toCharArray();
        Map<Character, Stack<Integer>> map = new HashMap<>();
        long score = 0;
        
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            Stack<Integer> stack = map.get(ch);

            if (stack != null && !stack.isEmpty()) {
                score += i - stack.pop();
            } else {
                char c = mirror.get(ch);
                map.computeIfAbsent(c, k -> new Stack<>()).push(i);
            }
        }

        return score;
    }
}
