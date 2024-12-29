// problem: 1324. Print Words Vertically
// difficulty: medium
// Time Complexity: O(n * mx + mx^2)
// Space Complexity: O(n * mx + mx^2)

class Solution {
    public List<String> printVertically(String s) {
        String[] words = s.split(" ");
        int n = words.length;
        List<StringBuilder> text = new ArrayList<>();
        int mx = 0;

        for (String word : words) {
            if (mx < word.length()) {
                mx = word.length();
            }
        }

        for (int i = 0; i < mx; i++) {
            text.add(new StringBuilder());
        }

        for (int i = 0; i < n; i++) {
            int len = words[i].length();
            for (int j = 0; j < mx; j++) {
                if (j < len) {
                    text.get(j).append(words[i].charAt(j));
                } else {
                    text.get(j).append(" ");
                }
            }
        }

        List<String> lastly = new ArrayList<>();

        for (int i = 0; i < mx; i++) {
            lastly.add(text.get(i).toString().replaceAll("\\s+$", ""));
        }

        return lastly;
    }
}



// version 2.0
class Solution {
    public List<String> printVertically(String s) {
        String[] words = s.split(" ");
        int n = words.length;
        List<StringBuilder> text = new ArrayList<>();
        int mx = 0;

        for (String word : words) {
                mx = Math.max(mx,word.length());
        }
        // for (int i = 0; i < mx; i++) {
        //     text.add(new StringBuilder());
        // }

        List<String> lastly = new ArrayList<>();

        for (int i = 0; i < mx; i++) {
            StringBuilder sb = new StringBuilder();

            for (String word : words) {
                if (i < word.length()) {
                    sb.append(word.charAt(i));
                } else {
                    sb.append(' ');
                }
            }

            int end = sb.length() - 1;
            while (end > 0 && sb.charAt(end) == ' ') {
                sb.deleteCharAt(end);
                end--;
            }

            lastly.add(sb.toString());
        }


        // for (int i = 0; i < mx; i++) {
        //     lastly.add(text.get(i).toString().replaceAll("\\s+$", ""));
        // }

        return lastly;
    }
}
