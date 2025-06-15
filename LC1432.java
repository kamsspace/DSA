// LeetCode problem: 1432. Max Difference You Can Get from Changing an Integer
// difficulty: medium
// time: O(1)
// space: O(1)
// math, greedy

class Solution {
    public int maxDiff(int num) {
        int numCopy = num;

        int[] mxDigits = new int[9];
        int[] mnDigits = new int[9];

        int i = 0;
        while (numCopy >= 10) {
            mnDigits[i] = numCopy % 10;
            mxDigits[i++] = numCopy % 10;
            numCopy /= 10;
        }

        mnDigits[i] = numCopy % 10;
        mxDigits[i++] = numCopy % 10;

        int mxNum = 0;
        int mx = 0;
        int mnNum = 0;
        int mn = 0;
        boolean mnSet = false;
        boolean isZero = false;
        for (int j = i - 1; j >= 0; j--) {
            if (mxDigits[j] == 9) {
                mx = num;
                if (!mnSet) {
                    mnNum = mnDigits[j];
                    mn = returnMin(mnDigits, mnNum, i, isZero);
                    mnSet = true; 
                }
                for (int k = j - 1; k >= 0; k--) {
                    if (mxDigits[k] != 9) {
                        mxNum = mxDigits[k];
                        mx = returnMax(mxDigits, mxNum, i);
                        break;
                    } else {
                        mx = num;
                    }
                }
                break;
            } else {
                if (!mnSet && mnDigits[j] == 1) {
                    mn = num;
                    for (int k = j - 1; k >= 0; k--) {
                        if (!mnSet && mnDigits[k] != 0 && mnDigits[k] != 1) {
                            mnNum = mnDigits[k];
                            isZero = true;
                            mn = returnMin(mnDigits, mnNum, i, isZero);
                            mnSet = true;
                            break;
                        } else {
                            mn = num;
                        }
                    }
                    mnSet = true;
                } else if (!mnSet && mnDigits[j] != 1) {
                    mnNum = mnDigits[j];
                    mn = returnMin(mnDigits, mnNum, i, isZero);
                    mnSet = true;
                }
                mxNum = mxDigits[j];
                mx = returnMax(mxDigits, mxNum, i);
                break;
            }
        }

        return mx - mn;
    }

    public static int returnMin(int[] b, int key, int last, boolean isZero) {
        int ans = 0;
        for (int i = 0; i < last; i++) {
            if (b[i] == key) {
                if (isZero) {
                    b[i] = 0;
                } else {
                    b[i] = 1;
                }
            }

            ans += b[i] * (int) Math.pow(10, i);
        }

        return ans;
    }

    public static int returnMax(int[] a, int key, int last) {
        int ans = 0;
        for (int i = 0; i < last; i++) {
            if (a[i] == key) {
                a[i] = 9;
            }

            ans += a[i] * (int) Math.pow(10, i);
        }

        return ans;
    }
}
/*
123 = 923 - 103 = 820

321 = 921 - 121 = 800

909 = 999 - 101 = 898

90 = 99 - 10 = 89

1 = 9 - 1 = 8

10240 = 90240 - 10040 = 80200

100000000 = 900000000 - 100000000 = 800000000
*/
