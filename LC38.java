// problem: 38. Count and Say
// difficulty: medium
// time: O(2^n)
// space: O(2^n)
// approach: iterative, same can be implemented with two helper functions (count and say) to count and say the string using recursive calls turn by turn

class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        StringBuilder start = new StringBuilder("1");

        for (int i = 1, j = 0; i < n; i++) {
            char[] digits = start.toString().toCharArray();
            int c = 1;
            char temp = digits[j++];
            StringBuilder bld = new StringBuilder();

            if (digits.length != 1) {
                while (j < digits.length) {
                    if (temp != digits[j]) {
                        bld.append(c);
                        bld.append(temp);
                        c = 1;
                        temp = digits[j++];
                    } else {
                        c++;
                        j++;
                    }
                }

                if (j == digits.length) {
                    bld.append(c);
                    bld.append(temp);
                    j = 0;
                }
            } else {
                bld.append(c);
                bld.append(temp);
                j = 0;
            }

            start = bld;
        }

        return start.toString();
    }
}

