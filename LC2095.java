// problem: 2095. Delete the Middle Node of a Linked List
// difficulty: medium
// time: 8 minutes
// runtime: 3ms, beats 99.72%
// memory: 63.93MB, beats 48.68%

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
    public ListNode deleteMiddle(ListNode head) {
        ListNode r = new ListNode();
        ListNode a = r;
        a.next = head;
        int c = 0;

        while (head != null) {
            c++;
            head = head.next;
        }

        int m = c / 2;

        while (m-- > 0) {
            a = a.next;
        }

        a.next = a.next.next;

        return r.next;
    }
}
