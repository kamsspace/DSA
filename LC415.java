// problem: 415. Add Strings
// difficulty: easy
// runtime: 2ms, beats 64.20%
// memory: 42.79MB, beats 41.19%

class Solution {
    public String addStrings(String num1, String num2) {
        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();
        char[] num = {'0','1','2','3','4','5','6','7','8','9'};
        char carry = '0';
        StringBuilder sb = new StringBuilder();
        int sum = 0;

        for (int i = n1.length-1, j = n2.length-1; i >= 0 || j >= 0; i--, j--) {
            char a = j >= 0 ? n2[j] : '0';
            char b = i >= 0 ? n1[i] : '0';
            
            sum = getNum(a) + getNum(b) + getNum(carry);
            carry = num[sum/10];
            sb.append(num[sum%10]);
        }

        if (carry == '1') sb.append(carry);

        return sb.reverse().toString();
    }

    public static int getNum(char c) {
        switch(c) {
            case '0': return 0;
            case '1': return 1;
            case '2': return 2;
            case '3': return 3;
            case '4': return 4;
            case '5': return 5;
            case '6': return 6;
            case '7': return 7;
            case '8': return 8;
            case '9': return 9;
            default: return -1;
        }
    }
}
