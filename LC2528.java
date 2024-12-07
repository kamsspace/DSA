// problem: 2528. Make String a Subsequence Using Cyclic Increments
// difficulty: medium
// time complexity: O(n)
// space complexity: O(1)

// version 2.0
class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();
        int i = 0,j = 0;

        for (; i < n1 && j < n2; i++) {
            if (((int) str2.charAt(j) - (int) str1.charAt(i) + 26)%26 <=1) {
                j++;
            } 
        }

        return j == n2;
    }
}


// version 1.0
class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();

        for (int i = 0; i < n2; i++) {
            boolean found = false;
            
            for (int j = i; j < n1 - (n2 - (i + 1)); j++) {
                int diff = str2.charAt(i) - str1.charAt(j);

                if (diff == 1 || diff == 0 || diff == -25) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                return false;
            }
        }

        return true;
    }
}
