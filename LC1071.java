// problem: 1071. Greatest Common Divisor of Strings
// difficulty: easy
// runtime: 0ms, beats 100%
// memory: 25%

class Solution {
    public String gcdOfStrings(String str1, String str2) {
        String a=str1+str2;
        String b=str2+str1;

        if (!a.equals(b)) return "";

        int one=str1.length();
        int two=str2.length();
        int last=gcd(one,two);
        return str1.substring(0,last);
    }

    // euclid's algorithm
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}


// runtime: 1ms, beats 67%
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        String a=str1+str2;
        String b=str2+str1;

        if (!a.equals(b)) return "";

        int one=str1.length();
        int two=str2.length();
        int last=gcd(one,two);
        String can=str1.substring(0,last);
        
        if (str1.equals(can.repeat(one/last)) && str2.equals(can.repeat(two/last))) {
            return can;
        }

        return "";
    }

    // euclid's algorithm
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}
