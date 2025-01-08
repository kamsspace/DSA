// problem: 3042. Count Prefix and Suffix Pairs I
// difficulty: easy
// time complexity: O(n^2 * m)
// space complexity: O(1)

class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int n = words.length;
        int c = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int leni = words[i].length();
                int lenj = words[j].length();
                if (leni <= lenj) {
                    int a = words[j].indexOf(words[i]);
                    int b = words[j].lastIndexOf(words[i]);
                    if (a == 0 && b == lenj - leni) {
                        c++;
                    }
                }
            }
        }

        return c;
    }
}


// version 2.0
class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int n = words.length;
        int c = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (words[j].startsWith(words[i]) && words[j].endsWith(words[i])) {
                    c++;
                }
            }
        }

        return c;
    }
}
