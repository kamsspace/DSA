// problem: 2058. Find the Maximum and Minimum Number of Nodes Between Critical Points
// difficulty: medium
// time: 1 hour
// runtime: 4ms, beats 99.92%
// memory: 60.67MB, beats 53.46%

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head.next.next == null) return new int[]{-1,-1};

        int min = 0, max = 0, prev = head.val, c = 0, minD = 0, maxD = 0;
        head = head.next;

        while (head.next != null) {
            if (head.val < prev && head.val < head.next.val) {
                min = head.val;
                maxD += c; 

                if (minD > c || minD == 0) {
                    minD = c;
                }

                c = 0;
            }

            if (head.val > prev && head.val > head.next.val) {
                max = head.val; 
                maxD += c;
                
                if (minD > c || minD == 0) {
                    minD = c;
                }
                
                c = 0;
            }

            if (max > 0 || min > 0) {
                c++;
            }

            prev = head.val;
            head = head.next;
        }

        if (maxD == 0 && minD == 0) return new int[]{-1,-1};
        if (maxD > 0 && minD == 0) return new int[]{maxD,maxD};
        if (maxD == 0 && minD > 0) return new int[]{minD,minD};

        return new int[]{minD, maxD};
    }
}
