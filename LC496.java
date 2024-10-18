// problem: 496. Next Greater Element I
// difficulty: easy
// runtime: 1ms, beats 99.52%
// memory: 42.64MB, 51% 

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] map = new int[10001];
        int in = 1;

        for (int i : nums1) {
            map[i] = in++;
        }

        // Stack<Integer> _stack = new Stack<>();
        int[] _stack = new int[1000];
        int last = -1;

        for (int i=nums2.length-1; i>=0; i--) {
            int n = nums2[i];

            while (last != -1 && _stack[last] <= n)
                last--;

            if (map[n] > 0)
                nums1[--map[n]] = last == -1 ? -1 : _stack[last];
            
            _stack[++last] = n;    
        }

        return nums1;
    }
}


// runtime: 2ms
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int in = 0;

        for (int i : nums1) {
            map.put(i,in++);
        }

        // Stack<Integer> _stack = new Stack<>();
        int[] _stack = new int[1000];
        int last = -1;

        for (int i=nums2.length-1; i>=0; i--) {
            int n = nums2[i];

            while (last != -1 && _stack[last] <= n)
                last--;

            if (map.containsKey(n))
                nums1[map.get(n)] = last == -1 ? -1 : _stack[last];
            
            _stack[++last] = n;    
        }

        return nums1;
    }
}



// runtime: 3ms
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        for (int i=0; i<nums1.length; i++) {
            int c = nums1[i], d = -1, e = -1, f = -1;
            
            for (int j=0; j<nums2.length; j++) {
                if (c == nums2[j]) {
                    d = j;
                    break;
                }
            }

            for (int j=d; j<nums2.length; j++) {
                if (c < nums2[j]) {
                    e = nums2[j];
                    f = j;
                    break;
                }
            }

            if (d > f) nums1[i] = -1;
            else if (d < f) nums1[i] = e; 
        }

        return nums1;
    }
}



// runtime: 4ms
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int in = 0;

        for (int i : nums1) {
            map.put(i,in++);
        }

        Stack<Integer> _stack = new Stack<>();

        for (int i=nums2.length-1; i>=0; i--) {
            int n = nums2[i];

                while (!_stack.isEmpty() && _stack.peek() <= n) {
                    _stack.pop();
                }    

            if (map.containsKey(n))
                nums1[map.get(n)] = _stack.empty() ? -1 : _stack.peek();
            
            _stack.push(n);    
        }

        return nums1;
    }
}
