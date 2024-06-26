LC 9. Palindrome Number

#Solution #1 - 8ms
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        else {
            int l = Integer.toString(x).length();
            for (int i = 1, j = l - 1; i <= l / 2; i++, j-=2) {
                if ((x / (int) Math.pow(10, j)) != (x % 10)) return false;
                x = x % (int) Math.pow(10,j);
                x /= 10;
            }
            return true;
        }
    }
}

#Solution #2 - 7ms
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        else {
            int l = Integer.toString(x).length();
            int j = (int) Math.pow(10,l-1);
            for (int i = 1; i <= l / 2; i++) {
                if ((x / j) != (x % 10)) return false;
                x = x % j;
                x /= 10;
                j /=100;
            }
            return true;
        }
    }
}

#Solution #3 - 6ms
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        else {
            int l = Integer.toString(x).length();
            int y = 0;
            for (int i = 1; i <= l / 2; i++) {
                y = y * 10 + (x % 10);
                x /= 10;
            }
            if (l % 2 == 1) x/=10;
            if (x != y) return false;
            else return true;
        }
    }
}

#Solution #4 - 6ms
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        String num = Integer.toString(x);
        int len = num.length();
        for (int i=0; i < len/2; i++) {
            if (num.charAt(i) != num.charAt(len - i - 1)) return false;
        }
        return true;
    }
}

#Solution #5 - 7ms
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        String num = Integer.toString(x);
        String alt = new StringBuilder(num).reverse().toString();
        return num.equals(alt);
    }
}

#Solution #6 - 6ms
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        String num = Integer.toString(x);
        int left = 0;
        int right = num.length() - 1;

        while (left < right) {
            if (num.charAt(left) != num.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

#Solution #7 - 5ms
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int left = 0, right = x;
        while(x > 0) {
            left = left * 10 + x % 10;
            x /= 10;
        }
        return left == right;
    }
}

#Solution #8 - 4ms
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int left = 0, right = x;
        while (x > 0) {
            left = left * 10 + x % 10;
            x /= 10;
        }
        return left == right;
    }
}
