// problem: 405. Convert to Hexadecimal Number
// difficulty: easy
// runtime: 0ms, beats 100%
class Solution {
    public String toHex(int num) {
        return Integer.toHexString(num);
    }
}



class Solution {
    public String toHex(int num) {
        if (num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        boolean is = false;

        for (int i=28;i>=0;i-=4) {
            int a = (num>>i) & 0xF;

            if (a != 0) is=true;

            if (is) {
                if (a<10) {
                    sb.append(a);
                } else {
                    sb.append((char)('a'+a-10));
                }
            }
        }

        return sb.toString(); 
        // return Integer.toHexString(num);
    }
}
