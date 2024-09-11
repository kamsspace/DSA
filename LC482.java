// problem: 482. License Key Formatting
// difficulty: easy
// runtime: 9ms, beats 93%
// memory: 44.75MB, beats 43.97%
class Solution {
    public String licenseKeyFormatting(String s, int k) {
        char[] ss = s.replaceAll("-","").toCharArray();
        int end = ss.length;
        int times = end / k;
        int rem = end % k;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < rem; i++) {
            char c = ss[i];

            if (c > 96 && c < 123) sb.append((char)(c-32));
            else sb.append(c);
        }

        if (sb.length() > 0) sb.append('-');

        for (int i = 0; i < times; i++) {
            for (int j = 0; j < k; j++) {
                char c = ss[rem++];
                
                if (c > 96 && c < 123) sb.append((char)(c-32));
                else sb.append(c);
            }

            sb.append('-');
        }

        if (sb.length() > 0) sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}



// runtime: 13ms, beats 63%
// memory: 44.45MB, beats 80.92%
class Solution {
    public String licenseKeyFormatting(String s, int k) {
        char[] ss = s.replaceAll("-","").toUpperCase().toCharArray();
        int end = ss.length;
        int times = end / k;
        int rem = end % k;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < rem; i++) {
            char c = ss[i];

            sb.append(c);
        }

        if (sb.length() > 0) sb.append('-');

        for (int i = 0; i < times; i++) {
            for (int j = 0; j < k; j++) {
                char c = ss[rem++];

                sb.append(c);
            }
            sb.append('-');
        }

        if (sb.length() > 0) sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}
