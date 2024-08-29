// problem: 13. Roman to Integer
// difficulty: easy
// runtime: 2ms, beats 100% || 3ms, beats 81.16% || 5ms, beats 58.25%
// memory: 44.58MB, 70.98%  || 44.33MB, 92.95%   || 44.55MB, 70.98%

// 2ms, beats 100% - 44.58MB, 70.98%
// used static function
class Solution {
    public int romanToInt(String s) {
        if (s.length() == 1) return addNumber(s.charAt(0));

        int n = s.length();
        int sum = 0;
        int prev = 0, next = 0;

        for (int i = 1; i < n; i++) {
            prev = addNumber(s.charAt(i-1));
            next = addNumber(s.charAt(i));
            
            if (next > prev) {
                sum = sum + next - prev;
                i++;
                if (i == (n-1)) sum += addNumber(s.charAt(i));
            } else {
                sum += prev;
            }
        }

        if (next <= prev) sum += next;

        return sum;
    }

    public static int addNumber(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}

// 3ms, beats 81.16% - 44.33MB, 92.95%
// used Switch inside a function
class Solution {
    public int romanToInt(String s) {
        if (s.length() == 1) return addNumber(s.charAt(0));

        int n = s.length();
        int sum = 0;
        int prev = 0, next = 0;

        for (int i = 1; i < n; i++) {
            prev = addNumber(s.charAt(i-1));
            next = addNumber(s.charAt(i));
            
            if (next > prev) {
                sum = sum + next - prev;
                i++;
                if (i == (n-1)) sum += addNumber(s.charAt(i));
            } else {
                sum += prev;
            }
        }

        if (next <= prev) sum += next;

        return sum;
    }

    public int addNumber(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}

// 5ms, beats 58.25% - 44.55MB, 70.98%
// used HashMap
class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        if (s.length() == 1) return map.get(s.charAt(0));

        int n = s.length();
        int sum = 0, temp = 0;
        int prev = 0, next = 0;

        for (int i = 1; i < n; i++) {
            prev = map.get(s.charAt(i-1));
            next = map.get(s.charAt(i));
            
            if (next > prev) {
                temp = next - prev;
                sum += temp;
                i++;
                if (i == (n-1)) sum += map.get(s.charAt(i));
            } else {
                sum += prev;
            }
        }

        if (next <= prev) sum += next;

        return sum;
    }
}
