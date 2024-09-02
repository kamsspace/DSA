// problem: 67. Add Binary
// difficulty: easy
// runtime: 2ms, beats 47.47%
// memory: 41.74MB, beats 97.53%

class Solution {
    public String addBinary(String a, String b) {
        char carry = '0';
        StringBuilder sb = new StringBuilder();

        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            char aV = i >= 0 ? a.charAt(i) : '0';
            char bV = j >= 0 ? b.charAt(j) : '0';

            if (aV == '1' && bV == '1' && carry == '0') {
                sb.insert(0,'0');
                carry = '1';
            } else if (aV == '1' && bV == '1' && carry == '1') {
                sb.insert(0,'1');
                carry = '1';
            } else if (aV == '0' && bV == '0' && carry == '1') {
                sb.insert(0,'1');
                carry = '0';
            } else if (aV == '1' && bV == '0' && carry == '1') {
                sb.insert(0,'0');
                carry = '1';
            } else if (aV == '0' && bV == '1' && carry == '1') {
                sb.insert(0,'0');
                carry = '1';
            } else if (aV == '0' && bV == '0' && carry == '0') {
                sb.insert(0,'0');
                carry = '0';
            } else if (aV == '0' && bV == '1' && carry == '0') {
                sb.insert(0,'1');
                carry = '0';
            } else if (aV == '1' && bV == '0' && carry == '0') {
                sb.insert(0,'1');
                carry = '0';
            }
        }

        if (carry == '1') sb.insert(0,'1');

        return sb.toString();
    }
}


// runtime: 6ms, beats 15.64%
// memory: 42.90MB, beats 16.51%

class Solution {
    public String addBinary(String a, String b) {
        java.math.BigInteger n1 = new java.math.BigInteger(a, 2);
        java.math.BigInteger n2 = new java.math.BigInteger(b, 2);
        return n1.add(n2).toString(2);
    }
}


// runtime: 5ms, beats 20.22%
// memory: 42.50MB, beats 28.73%

class Solution {
    public String addBinary(String a, String b) {
        return new java.math.BigInteger(a, 2).add(new java.math.BigInteger(b, 2)).toString(2);
    }
}
