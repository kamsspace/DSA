// LeetCode problem: 2566. Maximum Difference By Remapping a Digit
// difficulty: easy
// time: O(1)
// space: O(1)

// OPTIMAL VERSION
class Solution {
    public int minMaxDifference(int num) {
        int copyNum = num;
        
        int[] digits = new int[9];
        int[] minDigits = new int[9];

        int i = 0;
        while (copyNum >= 10) {
            minDigits[i] = copyNum % 10;
            digits[i++] = copyNum % 10;
            copyNum /= 10;
        }
        
        minDigits[i] = copyNum % 10;
        digits[i++] = copyNum % 10;

        int remapMax = 0;
        int mx = 0;
        int remapMin = 0;
        int mn = 0;
        boolean minSet = false;

        for (int j = i-1; j >= 0; j--) {
            if (digits[j] == 0) {
                continue;
            } else if (digits[j] == 9) {
                if (!minSet && minDigits[j] != 0) {
                    remapMin = minDigits[j];
                    mn = remapMinimizer(minDigits, remapMin, i);
                    minSet = true;
                }
                for (int k = j-1; k >= 0; k--) {
                    if (digits[k] != 9) {
                        remapMax = digits[k];
                        mx = remapMaximizer(digits, remapMax, i);
                        break;
                    } else {
                        mx = num;
                    }
                }
                break;
            } else {
                if (!minSet && minDigits[j] != 0) {
                    remapMin = minDigits[j];
                    mn = remapMinimizer(minDigits, remapMin, i);
                    minSet = true;
                }
                remapMax = digits[j];
                mx = remapMaximizer(digits, remapMax, i);
                break;
            }
        }

        return mx - mn;
    }

    public static int remapMinimizer(int[] a, int remapNum, int last) {
        int ans1 = 0;
        for (int i = 0; i < last; i++) {
            if (a[i] == remapNum) {
                a[i] = 0;
            }

            ans1 += a[i] * (int) Math.pow(10,i);
        }

        return ans1;
    }

    public static int remapMaximizer(int[] b, int remapNum, int last) {
        int ans2 = 0;
        for (int i = 0; i < last; i++) {
            if (b[i] == remapNum) {
                b[i] = 9;
            }

            ans2 += b[i] * (int) Math.pow(10,i);
        }

        return ans2;
    }
}


// FIRST SUB-OPTIMAL VERSION
class Solution {
    public int minMaxDifference(int num) {
        int maximizer = num;
        int minimizer = num;
        
        int[] digits = new int[9];
        int[] minDigits = new int[9];

        int i = 0;
        while (maximizer >= 10) {
            digits[i++] = maximizer % 10;
            maximizer /= 10;
        }
        
        digits[i++] = maximizer % 10;

        int remapMax = 0;
        int mx = 0;
        for (int j = i-1; j >= 0; j--) {
            if (digits[j] == 0) {
                continue;
            } else if (digits[j] == 9) {
                for (int k = j-1; k >= 0; k--) {
                    if (digits[k] != 9) {
                        remapMax = digits[k];
                        mx = remapMaximizer(digits, remapMax, i);
                        break;
                    } else {
                        mx = num;
                    }
                }
                break;
            } else {
                remapMax = digits[j];
                mx = remapMaximizer(digits, remapMax, i);
                break;
            }
        }

        i = 0;
        while (minimizer >= 10) {
            minDigits[i++] = minimizer % 10;
            minimizer /= 10;
        }

        minDigits[i++] = minimizer % 10;

        int remapMin = 0;
        int mn = 0;
        for (int j = i-1; j >= 0; j--) {
            if (minDigits[j] != 0) {
                remapMin = minDigits[j];
                mn = remapMinimizer(minDigits, remapMin, i);
                break;
            }
        }

        return mx - mn;
    }

    public static int remapMinimizer(int[] a, int remapNum, int last) {
        int ans1 = 0;
        for (int i = 0; i < last; i++) {
            if (a[i] == remapNum) {
                a[i] = 0;
            }

            ans1 += a[i] * (int) Math.pow(10,i);
        }

        return ans1;
    }

    public static int remapMaximizer(int[] b, int remapNum, int last) {
        int ans2 = 0;
        for (int i = 0; i < last; i++) {
            if (b[i] == remapNum) {
                b[i] = 9;
            }

            ans2 += b[i] * (int) Math.pow(10,i);
        }

        return ans2;
    }
}
