// LeetCode problem: 3304. Find the k-th character in string-game I
// difficulty: easy
// time: O(1)
// space: O(1)
class Solution {
    static final StringBuilder sb = new StringBuilder("a");
    static {
        for (int i = 0; i < 10; i++) {
            int n = sb.length();
            int c = 0;
            while (c < n && n < 500) {
                if (sb.charAt(c) == 'z') {
                    sb.append('a');
                } else {
                    sb.append((char)(sb.charAt(c) + 1));
                }
                c++;
            }
        }
    }
    public char kthCharacter(int k) {
        return sb.charAt(k - 1);
    }
}


// k = 1 = a
// k = 2 = a(b)

// k = 3 = ab(b)c
// k = 4 = abb(c)

// k = 5..8 abbc(bccd)
// k = 9..16 abbcbccd(bccdcdde)

// 1 = a
// 2,3,5,9,17,33 = b
// 4,6,7,10,11,13
