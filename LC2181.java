// problem: 2181. Merge Nodes in Between Zeros
// difficulty: medium
// time: 8 minutes
// runtime: 6ms, beats 27.15%
// memory: 81.94MB, beats 43.65%

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
    public ListNode mergeNodes(ListNode head) {
        ListNode r = new ListNode();
        ListNode a = r;
        int sum = 0;
        
        while (head != null) {
            if (head.val == 0 && sum != 0) {
                a.next = new ListNode(sum);
                a = a.next;
                sum = 0;
            } else {
                sum += head.val;
            }

            head = head.next;
        }

        return r.next;
    }
}
