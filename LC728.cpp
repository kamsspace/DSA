// problem: 728. Self Dividing Numbers
// difficulty: easy
// runtime: 0ms, beats 100%
// memory: 35%
class Solution {
public:
    vector<int> selfDividingNumbers(int left, int right) {
        vector<int> sdn;

        for (int i=left;i<=right;i++) {
            int x=i;
            bool flag=true;

            while (x>0) {
                int a=x%10;

                if (a==0 || i%a != 0) flag=false;

                x/=10;
            }

            if (flag) sdn.push_back(i);
        }

        return sdn;
    }
};


// runtime; 2ms, beats 29%
// memory: 90%
class Solution {
public:
    vector<int> selfDividingNumbers(int left, int right) {
        vector<int> sdn;

        for (int i=left;i<=right;i++) {
            if (sdnCheck(i)) sdn.push_back(i);
        }

        return sdn;
    }

    bool sdnCheck(int i) {
        int x=i;

        while (x>0) {
            int a=x%10;

            if (a==0 || i%a != 0) return false;

            x/=10;
        }

        return true;
    }
};
